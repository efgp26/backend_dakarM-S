package com.dakar.DakarApi.security.jwt;

import com.dakar.DakarApi.entities.TokenEntity;
import com.dakar.DakarApi.service.ITokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDate;
import java.util.Date;
import java.util.function.Function;

@Slf4j
@Component
public class JwtUtils {

    @Value(("${jwt.secret.key}"))
    private String secretKey;

    @Value(("${jwt.time.expiration}"))
    private  String timeExpiration;

    @Autowired
    private ITokenService blacklistedTokenRepository;

    public void logout(String token) {
        String username = getUsernameFromToken(token);
        Date expiration = extractAllClaims(token).getExpiration();
        TokenEntity blacklistedToken = new TokenEntity();
        blacklistedToken.setToken(token);
        blacklistedToken.setUsername(username);
        blacklistedToken.setExpirationDate(expiration);
        blacklistedTokenRepository.save(blacklistedToken);
    }


    // Crear un token de acceso
    public String generateAccesToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration) ))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //Validar el token de acceso
    public boolean isTokenValid(String token){
        if (blacklistedTokenRepository.existsByToken(token)) {
            log.info("Token is blacklisted");
            return false;
        }

        try{
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return  true;
        }catch (Exception e){
            log.error("Token invalido, error: " + e.getMessage());
            return false;
        }
    }


    //Obtener el username del token
    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }

    //Obtener un solo claim
    public <T>T getClaim(String token, Function<Claims, T> claimsFunction){

        Claims claims = extractAllClaims(token);
        return claimsFunction.apply(claims);
    }

    //Obtener todos los claims del token
    public Claims extractAllClaims(String token){

        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    //Obtener firma del token
    public Key getSignatureKey(){
        byte[] KeyBites = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(KeyBites);
    }
}
