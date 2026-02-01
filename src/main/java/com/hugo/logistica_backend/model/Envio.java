package com.hugo.logistica_backend.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guiaRemision;
    private String cliente;
    private Double peso;


    //RElACION N:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camion_id") //nombre de la columna en BD
    private Camion camion;
}