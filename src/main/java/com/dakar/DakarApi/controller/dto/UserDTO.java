package com.dakar.DakarApi.controller.dto;

import com.dakar.DakarApi.entities.BikeEntity;
import com.dakar.DakarApi.entities.RoleEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 50)
    private String name;

    private String username;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 12)
    private String numbrePhone;

    private LocalDate dataCreate;

    private Set<RoleEntity> roles;

    private List<BikeEntity> bikeEntityList = new ArrayList<>();
}
