package com.dakar.DakarApi.repository;

import com.dakar.DakarApi.entities.BikeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BikeRepository extends CrudRepository<BikeEntity, Long> {

    @Query("SELECT p FROM BikeEntity p WHERE p.userEntity.id = ?1")
    List<BikeEntity> findBikeByIdUser(Long idUser);

    @Query("SELECT p FROM BikeEntity p WHERE p.userEntity.id = ?1")
    BikeEntity findBikeByIdService(Long idService);

    @Query("SELECT p FROM BikeEntity p WHERE p.licensePlate = ?1")
    Optional<BikeEntity> findBikeByLicensePlate(String licensePlate);
}
