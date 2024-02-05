package com.dakar.DakarApi.controller;

import com.dakar.DakarApi.controller.dto.CreateServiceDTO;
import com.dakar.DakarApi.controller.dto.ServiceDTO;
import com.dakar.DakarApi.entities.ApiResponses;
import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.entities.ServiceEntity;
import com.dakar.DakarApi.entities.UserEntity;
import com.dakar.DakarApi.service.impl.BikeService;
import com.dakar.DakarApi.service.impl.ServiceEntityService;
import com.dakar.DakarApi.service.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController
{
    @Autowired
    private ServiceEntityService serviceEntityService;

    @Autowired
    private UserService userService;

    @Autowired
    private BikeService bikeService;

    @GetMapping("/findServiceId/{id}")
    public ResponseEntity<?> findServiceId(@PathVariable Long id) {
        Optional<ServiceEntity> optionalServiceEntity = serviceEntityService.findById(id);
        if (optionalServiceEntity.isPresent()) {
            ServiceEntity serviceEntity = optionalServiceEntity.get();
            ServiceDTO serviceDTO = ServiceDTO.builder()
                    .id(serviceEntity.getId())
                    .name(serviceEntity.getName())
                    .description(serviceEntity.getDescription())
                    .dateAdmission(serviceEntity.getDateAdmission())
                    .payment(serviceEntity.getPayment())
                    .valueService(serviceEntity.getValueService())
                    .stade(serviceEntity.getStade())
                    .departureDate(serviceEntity.getDepartureDate())
                    .bikeEntity(serviceEntity.getBikeEntity())
                    .build();
            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "servicio encontrado", serviceDTO ));

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "servicio no encontrado", null));
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAll(){
        List<ServiceEntity> entityList = serviceEntityService.findAll();
        List<ServiceDTO> serviceEntityList = mapListService(entityList);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario encontrado", serviceEntityList ));

    }

    @GetMapping("/listServiceByMechanic/{id}")
    public ResponseEntity<?> findServiceByMechanic(@PathVariable Long id){
        List<ServiceEntity> entityList = serviceEntityService.findServiceByMechanic(id);
        List<ServiceDTO> serviceEntityList = mapListService(entityList);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "", serviceEntityList ));
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid CreateServiceDTO createServiceDTO){
        if (createServiceDTO != null){
            ServiceEntity serviceEntity = ServiceEntity.builder()
                    .name(createServiceDTO.getName())
                    .description(createServiceDTO.getDescription())
                    .dateAdmission(LocalDate.now())
                    .payment(createServiceDTO.getPayment())
                    .valueService(createServiceDTO.getValueService())
                    .stade(createServiceDTO.getStade())
                    .departureDate(createServiceDTO.getDepartureDate())
                    .bikeEntity(createServiceDTO.getBikeEntity())
                    .userEntity(createServiceDTO.getUserEntity())
                    .build();
            serviceEntityService.save(serviceEntity);
            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario guardado", createServiceDTO ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "servicio no encontrado", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<ServiceEntity> optionalServiceEntity = serviceEntityService.findById(id);
        if (optionalServiceEntity.isPresent()){
            serviceEntityService.deleteById(id);
            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "servicio eliminado", null ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "servicio no encontrado", null));
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ServiceDTO serviceDTO){
        Optional<ServiceEntity> optionalServiceEntity = serviceEntityService.findById(serviceDTO.getId());
        if (optionalServiceEntity.isPresent()){
            ServiceEntity serviceEntity = optionalServiceEntity.get();
            serviceEntity.setName(serviceDTO.getName());
            serviceEntity.setDescription(serviceDTO.getDescription());
            serviceEntity.setDateAdmission(serviceDTO.getDateAdmission());
            serviceEntity.setPayment(serviceDTO.getPayment());
            serviceEntity.setValueService(serviceDTO.getValueService());
            serviceEntity.setStade(serviceDTO.getStade());
            serviceEntity.setDepartureDate(serviceDTO.getDepartureDate());

            serviceEntityService.save(serviceEntity);
            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "servicio actualizado", null ));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listAllServiceByStade/{stade}")
    public ResponseEntity<?> findAllServiceByStade(@PathVariable Boolean stade){
        List<ServiceEntity> entityList = serviceEntityService.findAllServiceForStade(stade);
        List<ServiceDTO> serviceEntityList = mapListService(entityList);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "", serviceEntityList ));
    }


    @GetMapping("/listServiceByStadeAndUser/{stade}/{idUser}")
    public ResponseEntity<?> findServiceForStade(@PathVariable Boolean stade, @PathVariable Long idUser){
        if (stade != null && idUser != null){
            Optional<UserEntity> optionalUser = userService.findById(idUser);
            if (optionalUser.isPresent()){
                List<ServiceEntity> entityList = serviceEntityService.findServiceForStade(stade, idUser);
                List<ServiceDTO> serviceEntityList = mapListService(entityList);
                return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, " ", serviceEntityList ));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "servicio no encontrado", null));
    }


    @GetMapping("/listServiceByIdBike/{idBike}")
    public ResponseEntity<?> listServiceByIdBike(@PathVariable Long idBike){
        Optional<BikeEntity> optionalBikeEntity = bikeService.findById(idBike);
        if (optionalBikeEntity.isPresent()){
            List<ServiceEntity> entityList = serviceEntityService.findServiceByIdBike(idBike);
            List<ServiceDTO> serviceDTOList = mapListService(entityList);

            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario encontrado",  serviceDTOList));

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "servicio no encontrado", null));
    }


    private List<ServiceDTO> mapListService(List<ServiceEntity> entityList){

        List<ServiceDTO> serviceEntityList = entityList.stream()
                .map(service -> ServiceDTO.builder()

                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .dateAdmission(service.getDateAdmission())
                        .payment(service.getPayment())
                        .valueService(service.getValueService())
                        .stade(service.getStade())
                        .departureDate(service.getDepartureDate())
                        .bikeEntity(service.getBikeEntity())
                        .build())
                .toList();

        return serviceEntityList;
    }

}
