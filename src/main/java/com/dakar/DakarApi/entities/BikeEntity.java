package com.dakar.DakarApi.entities;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "motocicletas")
public class BikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 10)
    @Column(name = "placa", unique = true)
    private String licensePlate;

    @NotBlank
    @Size(max = 6)
    @Column(name = "cilindraje")
    private String displacement;

    @NotBlank
    @Size(max = 4)
    @Column(name = "modelo")
    private String dateModel;

    @NotBlank
    @Size(max = 30)
    @Column(name = "marca")
    private String brand;

    @NotBlank
    @Size(max = 30)
    @Column(name = "referencia")
    private String reference;

    @NotBlank
    @Size(max = 10)
    @Column(name = "kilometraje")
    private String mileage;

    @Column(name = "fecha_creacion", columnDefinition = "DATE")
    private LocalDate dataCreate;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity userEntity;

    @OneToMany(targetEntity = ServiceEntity.class,mappedBy = "bikeEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<ServiceEntity> serviceEntityList = new ArrayList<>();


}
