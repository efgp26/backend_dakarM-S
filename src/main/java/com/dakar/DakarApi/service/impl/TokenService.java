package com.dakar.DakarApi.service.impl;

import com.dakar.DakarApi.entities.TokenEntity;
import com.dakar.DakarApi.persistence.ITokenDAO;
import com.dakar.DakarApi.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TokenService implements ITokenService {

    @Autowired
    private ITokenDAO tokenDAO;

    @Override
    public boolean existsByToken(String token) {
        return tokenDAO.existsByToken(token);
    }

    @Override
    public Optional<TokenEntity> findByToken(String token) {
        return tokenDAO.findByToken(token);
    }

    @Override
    public List<TokenEntity> findAll() {
        return tokenDAO.findAll();
    }

    @Override
    public void save(TokenEntity tokenEntity) {
        tokenDAO.save(tokenEntity);
    }

    @Override
    public void deleteByToken(String token) {
        tokenDAO.deleteByToken(token);
    }

    @Override
    public void deleteExpiredTokens() {
        tokenDAO.deleteExpiredTokens();
    }
}
