package com.dakar.DakarApi.service.impl;

import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.UserEntity;
import com.dakar.DakarApi.persistence.IUserDAO;
import com.dakar.DakarApi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(UserEntity userEntity) {
        userDAO.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public Optional<UserEntity> getName(String username) {
        return userDAO.getName(username);
    }

    @Override
    public List<UserEntity> getUsersByRole(ERole role) {
        return userDAO.getUsersByRole(role);
    }
}
