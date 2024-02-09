package com.dakar.DakarApi.service;


import com.dakar.DakarApi.entities.TypeOfServiceEntity;

import java.util.List;
import java.util.Optional;

public interface ITypeServiceService {
    Optional<TypeOfServiceEntity> findById(Long id);
    List<TypeOfServiceEntity> findAll();
    void save(TypeOfServiceEntity typeOfService);
    void deleteById(Long id);
}
