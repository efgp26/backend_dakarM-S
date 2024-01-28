package com.dakar.DakarApi.repository;

import com.dakar.DakarApi.entities.TokenEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, String> {

    boolean existsByToken(String token);

    Optional<TokenEntity> findByToken(String token);

    void deleteByToken(String token);

    @Modifying
    @Transactional
    @Query("DELETE FROM TokenEntity t WHERE t.expirationDate < CURRENT_TIMESTAMP")
    void deleteExpiredTokens();
}
