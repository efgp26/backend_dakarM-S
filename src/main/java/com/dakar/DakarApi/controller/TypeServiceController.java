package com.dakar.DakarApi.controller;

import com.dakar.DakarApi.controller.dto.CreateTypeServiceDTO;
import com.dakar.DakarApi.entities.ApiResponses;
import com.dakar.DakarApi.entities.TypeOfServiceEntity;
import com.dakar.DakarApi.service.ITypeServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeService")
public class TypeServiceController {

    @Autowired
    private ITypeServiceService typeServiceService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid CreateTypeServiceDTO typeServiceDTO){

        if( typeServiceDTO != null){
            TypeOfServiceEntity  typeServiceEntity = TypeOfServiceEntity.builder()
                    .name(typeServiceDTO.getName())
                    .price(typeServiceDTO.getPrice())
                    .build();
            typeServiceService.save(typeServiceEntity);
            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Tipo de servicio guardado", typeServiceDTO ));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponses<>(HttpStatus.BAD_REQUEST.value(), false, "servicio no encontrado", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponses<>(HttpStatus.BAD_REQUEST.value(), false, "id no encontrado", null));
        }
        if (!typeServiceService.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "id no encontrado", null));
        }
        typeServiceService.deleteById(id);
        return ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Tipo de servicio eliminado", null));
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAll(){
        List<TypeOfServiceEntity> typeServiceEntityList = typeServiceService.findAll();
        List<CreateTypeServiceDTO> typeServiceDTOList = typeServiceEntityList.stream()
                .map(typeService -> CreateTypeServiceDTO.builder()
                        .id(typeService.getId())
                        .name(typeService.getName())
                        .price(typeService.getPrice())
                        .build())
                .toList();
        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Tipo de servicio encontrado", typeServiceDTOList ));
    }


}
