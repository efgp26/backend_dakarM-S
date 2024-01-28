package com.dakar.DakarApi.controller.dto;

import com.dakar.DakarApi.entities.ServiceEntity;
import com.dakar.DakarApi.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBikeDTO {

    @NotBlank
    private String licensePlate;
    @NotBlank
    private String displacement;
    @NotBlank
    private String dateModel;
    @NotBlank
    private String brand;
    @NotBlank
    private String reference;
    @NotBlank
    private String mileage;
    private LocalDate dataCreate;
    private UserEntity userEntity;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ServiceEntity> serviceEntityList;
}
