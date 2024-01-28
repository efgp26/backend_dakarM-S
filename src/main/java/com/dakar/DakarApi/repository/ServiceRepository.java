package com.dakar.DakarApi.repository;

import com.dakar.DakarApi.entities.ServiceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {

    @Query("SELECT p FROM ServiceEntity p WHERE p.stade = ?1")
    List<ServiceEntity> findAllServiceForStade(Boolean stade);

    @Query("SELECT p FROM ServiceEntity p WHERE p.stade = ?1 AND p.bikeEntity.userEntity = ?2")
    List<ServiceEntity> findServiceForStade(Boolean stade, Long idUser);

    @Query("SELECT p FROM ServiceEntity p WHERE p.bikeEntity.id = ?1")
    List<ServiceEntity> findServiceByIdBike(Long idBike);

    @Query("SELECT p FROM ServiceEntity p WHERE p.userEntity.id = ?1")
    List<ServiceEntity> findServiceByMechanic(Long id);
}
