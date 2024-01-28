package com.dakar.DakarApi.persistence.impl;

import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.persistence.IBikeDAO;
import com.dakar.DakarApi.repository.BikeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BikeDAOImpl implements IBikeDAO {

    private BikeRepository bikeRepository;

    public BikeDAOImpl(BikeRepository bikeRepository){
        this.bikeRepository = bikeRepository;
    }


    @Override
    public Optional<BikeEntity> findById(Long id) {
        return this.bikeRepository.findById(id);
    }

    @Override
    public List<BikeEntity> findAll() {
        return (List<BikeEntity>) this.bikeRepository.findAll();
    }

    @Override
    public void save(BikeEntity bike) {
        this.bikeRepository.save(bike);
    }

    @Override
    public void deleteById(Long id) {
        this.bikeRepository.deleteById(id);
    }

    @Override
    public List<BikeEntity> findBikeByIdUser(Long idUser) {
        return this.bikeRepository.findBikeByIdUser(idUser);
    }

    @Override
    public BikeEntity findBikeByIdService(Long idService) {
        return this.bikeRepository.findBikeByIdService(idService);
    }

    @Override
    public Optional<BikeEntity> findBikeByLicensePlate(String licensePlate) {
        return bikeRepository.findBikeByLicensePlate(licensePlate);
    }
}
