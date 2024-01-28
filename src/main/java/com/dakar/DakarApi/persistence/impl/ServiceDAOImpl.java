package com.dakar.DakarApi.persistence.impl;

import com.dakar.DakarApi.entities.ServiceEntity;
import com.dakar.DakarApi.persistence.IServiceDAO;
import com.dakar.DakarApi.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceDAOImpl implements IServiceDAO {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Optional<ServiceEntity> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<ServiceEntity> findAll() {
        return (List<ServiceEntity>) serviceRepository.findAll();
    }

    @Override
    public void save(ServiceEntity serviceEntity) {
        serviceRepository.save(serviceEntity);
    }

    @Override
    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<ServiceEntity> findAllServiceForStade(Boolean stade) {
        return serviceRepository.findAllServiceForStade(stade);
    }

    @Override
    public List<ServiceEntity> findServiceForStade(Boolean stade, Long idUser) {
        return serviceRepository.findServiceForStade(stade, idUser);
    }

    @Override
    public List<ServiceEntity> findServiceByIdBike(Long idBike) {
        return serviceRepository.findServiceByIdBike(idBike);
    }

    @Override
    public List<ServiceEntity> findServiceByMechanic(Long id) {
        return serviceRepository.findServiceByMechanic(id);
    }
}
