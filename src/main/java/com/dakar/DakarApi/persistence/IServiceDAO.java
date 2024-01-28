package com.dakar.DakarApi.persistence;

import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.entities.RoleEntity;
import com.dakar.DakarApi.entities.ServiceEntity;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

public interface IServiceDAO {

    Optional<ServiceEntity> findById(Long id);
    List<ServiceEntity> findAll();
    void save(ServiceEntity serviceEntity);
    void deleteById(Long id);
    List<ServiceEntity> findAllServiceForStade(Boolean stade);
    List<ServiceEntity> findServiceForStade(Boolean stade, Long idUser);
    List<ServiceEntity> findServiceByIdBike(Long idBike);
    List<ServiceEntity> findServiceByMechanic(Long id);
}
