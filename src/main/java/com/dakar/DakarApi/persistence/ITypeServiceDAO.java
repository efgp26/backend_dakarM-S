package com.dakar.DakarApi.persistence;

import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.RoleEntity;
import com.dakar.DakarApi.entities.TypeOfServiceEntity;

import java.util.List;
import java.util.Optional;

public interface ITypeServiceDAO {
    Optional<TypeOfServiceEntity> findById(Long id);
    List<TypeOfServiceEntity> findAll();
    void save(TypeOfServiceEntity typeOfService);
    void deleteById(Long id);
}
