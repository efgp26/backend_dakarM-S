package com.dakar.DakarApi.service;

import com.dakar.DakarApi.entities.TokenEntity;

import java.util.List;
import java.util.Optional;

public interface ITokenService {

    boolean existsByToken(String token);
    Optional<TokenEntity> findByToken(String token);
    List<TokenEntity> findAll();
    void save(TokenEntity tokenEntity);
    void deleteByToken(String token);
    void deleteExpiredTokens();
}
