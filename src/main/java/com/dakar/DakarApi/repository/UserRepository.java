package com.dakar.DakarApi.repository;

import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Query("SELECT p FROM UserEntity p WHERE p.username = ?1 ")
    Optional<UserEntity> getName(String username);

    @Query("SELECT u FROM UserEntity u JOIN u.roles r WHERE r.name = :role ")
    List<UserEntity> getUsersByRole(ERole role);
}
