package com.dakar.DakarApi.entities;

import com.dakar.DakarApi.service.impl.BikeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "correo_electronico", unique = true)
    private String email;

    @NotBlank
    @Column(name = "contrasena")
    private String password;

    @Column(name = "nombre_usuario_session")
    private String username;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre")
    private String name;

    @NotBlank
    @Size(max = 50)
    @Column(name = "apellidos")
    private String lastName;

    @NotBlank
    @Size(max = 12)
    @Column(name = "telefono")
    private String numbrePhone;

    @Column(name = "fecha_creacion", columnDefinition = "DATE")
    private LocalDate dataCreate;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<RoleEntity> roles;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = BikeEntity.class, mappedBy ="userEntity")
    @JsonIgnore
    private List<BikeEntity> bikeEntityList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ServiceEntity.class, mappedBy ="userEntity")
    @JsonIgnore
    private List<ServiceEntity> serviceEntityList = new ArrayList<>();

}
