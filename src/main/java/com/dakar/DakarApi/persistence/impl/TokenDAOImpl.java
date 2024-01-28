package com.dakar.DakarApi.persistence.impl;

import com.dakar.DakarApi.entities.TokenEntity;
import com.dakar.DakarApi.persistence.ITokenDAO;
import com.dakar.DakarApi.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TokenDAOImpl implements ITokenDAO {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public boolean existsByToken(String token) {
        return tokenRepository.existsByToken(token);
    }

    @Override
    public Optional<TokenEntity> findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public List<TokenEntity> findAll() {
        return (List<TokenEntity>) tokenRepository.findAll();
    }

    @Override
    public void save(TokenEntity tokenEntity) {
        tokenRepository.save(tokenEntity);
    }

    @Override
    public void deleteByToken(String token) {
        tokenRepository.deleteByToken(token);
    }

    @Override
    public void deleteExpiredTokens() {
        tokenRepository.deleteExpiredTokens();
    }
}
