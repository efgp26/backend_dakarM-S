package com.dakar.DakarApi.controller.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTypeServiceDTO {

    @NotBlank
    private String name;

    private Long id;

    private BigDecimal price;
}
