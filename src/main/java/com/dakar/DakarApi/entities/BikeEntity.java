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

    @Column(name = "placa", unique = true)
    private String licensePlate;

    @Column(name = "cilindraje")
    private String displacement;

    @Column(name = "modelo")
    private String dateModel;

    @Column(name = "marca")
    private String brand;


    @Column(name = "referencia")
    private String reference;

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
