package com.dakar.DakarApi.service.impl;


import com.dakar.DakarApi.entities.TypeOfServiceEntity;
import com.dakar.DakarApi.persistence.ITypeServiceDAO;
import com.dakar.DakarApi.service.ITypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceServiceImpl implements ITypeServiceService {


    @Autowired
    private ITypeServiceDAO typeOfServiceDAO;

    @Override
    public Optional<TypeOfServiceEntity> findById(Long id) {
        return typeOfServiceDAO.findById(id);
    }

    @Override
    public List<TypeOfServiceEntity> findAll() {
        return typeOfServiceDAO.findAll();
    }

    @Override
    public void save(TypeOfServiceEntity typeOfService) {
        typeOfServiceDAO.save(typeOfService);
    }

    @Override
    public void deleteById(Long id) {
        typeOfServiceDAO.deleteById(id);
    }
}
