package com.desafio.tecnico.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Mercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToMany(mappedBy = "mercados")
    private Set<Comitente> comitentes;
}