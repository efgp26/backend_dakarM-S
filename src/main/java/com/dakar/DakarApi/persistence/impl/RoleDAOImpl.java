package com.dakar.DakarApi.persistence.impl;

import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.RoleEntity;
import com.dakar.DakarApi.persistence.IRoleDAO;
import com.dakar.DakarApi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleDAOImpl implements IRoleDAO {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<RoleEntity> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<RoleEntity> findAll() {
        return (List<RoleEntity>) roleRepository.findAll();
    }

    @Override
    public void save(RoleEntity role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<RoleEntity> findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
