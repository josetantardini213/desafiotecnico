package com.desafio.tecnico.service;

import com.desafio.tecnico.entity.Comitente;

import java.util.List;

public interface ComitenteService {
    List<Comitente> getAllComitentes();

    Comitente getComitenteById(Long id);

    Comitente createComitente(Comitente comitente);

    Comitente updateComitente(Long id, Comitente comitenteDetails);

    void deleteComitente(Long id);
}
