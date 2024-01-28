package com.dakar.DakarApi.service;

import com.dakar.DakarApi.entities.BikeEntity;

import java.util.List;
import java.util.Optional;

public interface IBikeService {

    Optional<BikeEntity> findById(Long id);
    List<BikeEntity> findAll();
    void save(BikeEntity bike);
    void deleteById(Long id);
    List<BikeEntity> findBikeByIdUser(Long idUser);
    BikeEntity findBikeByIdService(Long idService);
    Optional<BikeEntity> findBikeByLicensePlate(String licensePlate);
}
