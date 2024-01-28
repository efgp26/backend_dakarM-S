package com.dakar.DakarApi.persistence;

import com.dakar.DakarApi.entities.TokenEntity;
import com.dakar.DakarApi.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface ITokenDAO {

    boolean existsByToken(String token);
    Optional<TokenEntity> findByToken(String token);
    List<TokenEntity> findAll();
    void save(TokenEntity tokenEntity);
    void deleteByToken(String token);
    void deleteExpiredTokens();
}
