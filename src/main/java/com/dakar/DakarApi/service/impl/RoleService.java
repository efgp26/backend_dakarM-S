package com.dakar.DakarApi.service.impl;

import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.RoleEntity;
import com.dakar.DakarApi.persistence.IRoleDAO;
import com.dakar.DakarApi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleDAO roleDAO;

    @Override
    public Optional<RoleEntity> findById(Long id) {
        return roleDAO.findById(id);
    }

    @Override
    public List<RoleEntity> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public void save(RoleEntity role) {
        roleDAO.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleDAO.deleteById(id);
    }

    @Override
    public Optional<RoleEntity> findByName(ERole name) {
        return roleDAO.findByName(name);
    }
}
