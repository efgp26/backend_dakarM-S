package com.dakar.DakarApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "mantenimientos")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "fecha_ingreso", columnDefinition = "DATE")
    private LocalDate dateAdmission;

    @Column(name = "abono")
    private BigDecimal payment;

    @Column(name = "costo_mantenimiento")
    private BigDecimal valueService;

    @Column(name = "estado")
    private Boolean stade;

    @Column(name = "fecha_salida", columnDefinition = "DATE")
    private LocalDate departureDate;

    @ManyToOne
    @JoinColumn(name = "id_bike", nullable = false)
    @JsonIgnore
    private BikeEntity bikeEntity;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity userEntity;
}
