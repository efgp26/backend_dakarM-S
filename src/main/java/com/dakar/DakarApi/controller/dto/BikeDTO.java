package com.dakar.DakarApi.controller.dto;

import com.dakar.DakarApi.entities.ServiceEntity;
import com.dakar.DakarApi.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BikeDTO {

    private Long id;
    private String licensePlate;
    private String displacement;
    private String dateModel;
    private String brand;
    private String reference;
    private String mileage;
    private LocalDate dataCreate;
    private UserEntity userEntity;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ServiceEntity> serviceEntityList;
}
