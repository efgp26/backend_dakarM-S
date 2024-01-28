package com.dakar.DakarApi.controller.dto;

import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDate dateAdmission;
    private BigDecimal payment;
    private BigDecimal valueService;
    private Boolean stade;
    private LocalDate departureDate;
    private BikeEntity bikeEntity;
    private UserEntity userEntity;
}
