package com.dakar.DakarApi.service;

import com.dakar.DakarApi.entities.ServiceEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceEntityService {

    Optional<ServiceEntity> findById(Long id);
    List<ServiceEntity> findAll();
    void save(ServiceEntity serviceEntity);
    void deleteById(Long id);
    List<ServiceEntity> findAllServiceForStade(Boolean stade);
    List<ServiceEntity> findServiceForStade(Boolean stade, Long idUser);
    List<ServiceEntity> findServiceByIdBike(Long idBike);
    List<ServiceEntity> findServiceByMechanic(Long id);
}
