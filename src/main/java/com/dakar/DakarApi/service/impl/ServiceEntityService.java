package com.dakar.DakarApi.service.impl;

import com.dakar.DakarApi.entities.ServiceEntity;
import com.dakar.DakarApi.persistence.IServiceDAO;
import com.dakar.DakarApi.service.IServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntityService implements IServiceEntityService {

    @Autowired
    private IServiceDAO serviceDAO;

    @Override
    public Optional<ServiceEntity> findById(Long id) {
        return serviceDAO.findById(id);
    }

    @Override
    public List<ServiceEntity> findAll() {
        return serviceDAO.findAll();
    }

    @Override
    public void save(ServiceEntity serviceEntity) {
        serviceDAO.save(serviceEntity);
    }

    @Override
    public void deleteById(Long id) {
        serviceDAO.deleteById(id);
    }

    @Override
    public List<ServiceEntity> findAllServiceForStade(Boolean stade) {
        return serviceDAO.findAllServiceForStade(stade);
    }

    @Override
    public List<ServiceEntity> findServiceForStade(Boolean stade, Long idUser) {
        return serviceDAO.findServiceForStade(stade, idUser);
    }

    @Override
    public List<ServiceEntity> findServiceByIdBike(Long idBike) {
        return serviceDAO.findServiceByIdBike(idBike);
    }

    @Override
    public List<ServiceEntity> findServiceByMechanic(Long id) {
        return serviceDAO.findServiceByMechanic(id);
    }
}
