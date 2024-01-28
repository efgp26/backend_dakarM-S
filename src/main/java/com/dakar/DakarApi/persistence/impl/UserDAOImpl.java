package com.dakar.DakarApi.persistence.impl;

import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.UserEntity;
import com.dakar.DakarApi.persistence.IUserDAO;
import com.dakar.DakarApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements IUserDAO {

    private UserRepository userRepository;

    public UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) this.userRepository.findAll();
    }

    @Override
    public void save(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Optional<UserEntity> getName(String username) {
        return this.userRepository.getName(username);
    }

    @Override
    public List<UserEntity> getUsersByRole(ERole role) {
        return  this.userRepository.getUsersByRole(role);
    }
}
