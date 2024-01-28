package com.dakar.DakarApi.persistence;

import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.ServiceEntity;
import com.dakar.DakarApi.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    Optional<UserEntity> findById(Long id);
    List<UserEntity> findAll();
    void save(UserEntity userEntity);
    void deleteById(Long id);
    Optional<UserEntity> getName(String username);

    List<UserEntity> getUsersByRole(ERole role);
}
