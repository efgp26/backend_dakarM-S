package com.dakar.DakarApi.persistence.impl;


import com.dakar.DakarApi.entities.TypeOfServiceEntity;
import com.dakar.DakarApi.persistence.ITypeServiceDAO;
import com.dakar.DakarApi.repository.TypeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TypeServiceDAOImpl implements ITypeServiceDAO {

    @Autowired
    private TypeServiceRepository typeOfServiceRepository;

    @Override
    public Optional<TypeOfServiceEntity> findById(Long id) {
        return typeOfServiceRepository.findById(id);
    }

    @Override
    public List<TypeOfServiceEntity> findAll() {
        return (List<TypeOfServiceEntity>) typeOfServiceRepository.findAll();
    }

    @Override
    public void save(TypeOfServiceEntity typeOfService) {
        typeOfServiceRepository.save(typeOfService);
    }

    @Override
    public void deleteById(Long id) {
        typeOfServiceRepository.deleteById(id);
    }
}
