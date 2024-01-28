package com.dakar.DakarApi.persistence;

import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface IRoleDAO {

    Optional<RoleEntity> findById(Long id);
    List<RoleEntity> findAll();
    void save(RoleEntity role);
    void deleteById(Long id);
    Optional<RoleEntity> findByName(ERole name);
}
