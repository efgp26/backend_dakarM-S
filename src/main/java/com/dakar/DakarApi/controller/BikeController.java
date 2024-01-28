package com.dakar.DakarApi.controller;

import com.dakar.DakarApi.controller.dto.BikeDTO;
import com.dakar.DakarApi.controller.dto.CreateBikeDTO;
import com.dakar.DakarApi.entities.ApiResponses;
import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.service.IBikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bike")
public class BikeController {

    @Autowired
    private IBikeService bikeService;

    @GetMapping("/findBikeId/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<BikeEntity> optionalBikeEntity = bikeService.findById(id);

        if(optionalBikeEntity.isPresent()){
            BikeEntity bike = optionalBikeEntity.get();
            BikeDTO bikeDTO = mapBikeDTO(bike);

            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "MOto encontrado", bikeDTO ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "Moto no encontrado", null));
    }

    @GetMapping("/listAllBike")
    public ResponseEntity<?> findAll(){
        List<BikeEntity> entityList = bikeService.findAll();
        List<BikeDTO> bikeDTOList = mapListBikeDTO(entityList);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "", bikeDTOList ));
    }

    @PostMapping("/save")
    public  ResponseEntity<?> save(@Valid @RequestBody CreateBikeDTO bikeDTO) throws URISyntaxException {

        BikeEntity bikeEntity = BikeEntity.builder()
                .brand(bikeDTO.getBrand())
                .mileage(bikeDTO.getMileage())
                .displacement(bikeDTO.getDisplacement())
                .dateModel(bikeDTO.getDateModel())
                .licensePlate(bikeDTO.getLicensePlate())
                .reference(bikeDTO.getReference())
                .dataCreate(LocalDate.now())
                .userEntity(bikeDTO.getUserEntity())
                .build();

        bikeService.save(bikeEntity);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Moto guardada con exito", bikeEntity ));
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody CreateBikeDTO bikeDTO) throws URISyntaxException {

        Optional<BikeEntity> optionalBikeEntity = bikeService.findById(id);

        if (optionalBikeEntity.isPresent()){
            BikeEntity bikeEntity = optionalBikeEntity.get();
            bikeEntity.setBrand(bikeDTO.getBrand());
            bikeEntity.setMileage(bikeDTO.getMileage());
            bikeEntity.setDisplacement(bikeDTO.getDisplacement());
            bikeEntity.setDateModel(bikeDTO.getDateModel());
            bikeEntity.setLicensePlate(bikeDTO.getLicensePlate());
            bikeEntity.setReference(bikeDTO.getReference());
            bikeEntity.setUserEntity(bikeDTO.getUserEntity());

            bikeService.save(bikeEntity);

            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Resgistro actualizado", null ));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "No se pudo actualizar el registro", null));
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<BikeEntity> optionalBikeEntity = bikeService.findById(id);
        if (optionalBikeEntity.isPresent()){
            bikeService.deleteById(id);
            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Registro eliminado", null ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "Moto no encontrado", null));
    }

    @GetMapping("/findBikeByUser/{id}")
    public ResponseEntity<?> findBikeByIUser(Long id){
        List<BikeEntity> bikeEntityList= (List<BikeEntity>) bikeService.findBikeByIdUser(id);

        if (bikeEntityList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<BikeDTO> bikeDTOList = mapListBikeDTO(bikeEntityList);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "", bikeDTOList ));

    }

    @GetMapping("/findBikeLicensePlate/{licensePlate}")
    public ResponseEntity<?> findBikeByLicensePlate(@PathVariable String licensePlate){
        Optional<BikeEntity> optionalBike = bikeService.findBikeByLicensePlate(licensePlate);
        if (optionalBike.isPresent()){
            BikeEntity bike = optionalBike.get();
            BikeDTO bikeDTO = mapBikeDTO(bike);

            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Moto encontrado", bikeDTO ));

        }
         return  ResponseEntity.notFound().build();
    }


    private BikeDTO mapBikeDTO(BikeEntity bike){
        BikeDTO bikeDTO = BikeDTO.builder()
                .id(bike.getId())
                .brand(bike.getBrand())
                .mileage(bike.getMileage())
                .displacement(bike.getDisplacement())
                .dataCreate(bike.getDataCreate())
                .dateModel(bike.getDateModel())
                .licensePlate(bike.getLicensePlate())
                .reference(bike.getReference())
                .userEntity(bike.getUserEntity())
                .build();
        return bikeDTO;
    }

    private List<BikeDTO> mapListBikeDTO(List<BikeEntity> bikeEntityList){
        List<BikeDTO> bikeDTOList = bikeEntityList
                .stream()
                .map(bike -> BikeDTO.builder()
                        .id(bike.getId())
                        .brand(bike.getBrand())
                        .mileage(bike.getMileage())
                        .displacement(bike.getDisplacement())
                        .dataCreate(bike.getDataCreate())
                        .dateModel(bike.getDateModel())
                        .licensePlate(bike.getLicensePlate())
                        .reference(bike.getReference())
                        .userEntity(bike.getUserEntity())
                        .build())
                .toList();
        return bikeDTOList;
    }
}


