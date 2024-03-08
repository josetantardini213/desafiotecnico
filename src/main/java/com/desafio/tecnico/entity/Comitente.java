package com.desafio.tecnico.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Comitente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "comitente_mercado",
            joinColumns = @JoinColumn(name = "comitente_id"),
            inverseJoinColumns = @JoinColumn(name = "mercado_id")
    )
    private Set<Mercado> mercados;

}