package com.dakar.DakarApi.controller.dto;

import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.entities.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateServiceDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
    private LocalDate dateAdmission;
    private BigDecimal payment;
    private BigDecimal valueService;
    private Boolean stade;
    private LocalDate departureDate;
    private BikeEntity bikeEntity;
    private UserEntity userEntity;
}
