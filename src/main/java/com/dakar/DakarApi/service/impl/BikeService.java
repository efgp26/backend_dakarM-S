package com.dakar.DakarApi.service.impl;

import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.persistence.IBikeDAO;
import com.dakar.DakarApi.service.IBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService implements IBikeService {

    @Autowired
    private IBikeDAO bikeDAO;

    @Override
    public Optional<BikeEntity> findById(Long id) {
        return bikeDAO.findById(id);
    }

    @Override
    public List<BikeEntity> findAll() {
        return bikeDAO.findAll();
    }

    @Override
    public void save(BikeEntity bike) {
        bikeDAO.save(bike);
    }

    @Override
    public void deleteById(Long id) {
        bikeDAO.deleteById(id);
    }

    @Override
    public List<BikeEntity> findBikeByIdUser(Long idUser) {
        return bikeDAO.findBikeByIdUser(idUser);
    }

    @Override
    public BikeEntity findBikeByIdService(Long idService) {
        return bikeDAO.findBikeByIdService(idService);
    }

    @Override
    public Optional<BikeEntity> findBikeByLicensePlate(String licensePlate) {
        return bikeDAO.findBikeByLicensePlate(licensePlate);
    }
}
