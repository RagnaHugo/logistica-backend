package com.hugo.logistica_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String conductor;
    private Double capacidadToneladas;

    //Relacion 1:N
    //mappedBy dice que la dueña de la relacion es camion en la clase envio
    //CascadeType.All : Si borro el camion, se borran sus envios.
    @OneToMany(mappedBy = "camion", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Envio> envios;



}
