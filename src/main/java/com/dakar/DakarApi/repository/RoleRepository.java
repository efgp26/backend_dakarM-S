package com.dakar.DakarApi.repository;

import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.RoleEntity;
import com.dakar.DakarApi.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    @Query("SELECT p FROM RoleEntity p WHERE p.name = ?1 ")
    Optional<RoleEntity> findByName(ERole name);
}
