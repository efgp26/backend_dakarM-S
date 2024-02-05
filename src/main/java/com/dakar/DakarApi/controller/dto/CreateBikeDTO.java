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
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBikeDTO {

    @NotBlank
    @Size(min=3, max = 10)
    private String licensePlate;

    @NotBlank
    @Size(max = 6)
    private String displacement;

    @NotBlank
    @Size(max = 4)
    private String dateModel;

    @NotBlank
    @Size(max = 30)
    private String brand;

    @NotBlank
    @Size(max = 30)
    private String reference;

    @NotBlank
    @Size(max = 10)
    private String mileage;
    private LocalDate dataCreate;
    private UserEntity userEntity;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ServiceEntity> serviceEntityList;
}
