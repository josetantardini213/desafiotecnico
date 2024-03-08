package com.desafio.tecnico.service;

import com.desafio.tecnico.entity.Pais;

import java.util.List;

public interface PaisService {
    List<Pais> getAllPaises();

    Pais getPaisById(Long id);

    Pais createPais(Pais pais);

    Pais updatePais(Long id, Pais paisDetails);

    void deletePais(Long id);
}
