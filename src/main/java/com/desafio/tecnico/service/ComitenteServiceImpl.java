package com.desafio.tecnico.service;

import com.desafio.tecnico.entity.Comitente;
import com.desafio.tecnico.repository.ComitenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComitenteServiceImpl implements ComitenteService{
    @Autowired
    private ComitenteRepository comitenteRepository;


    @Override
    public List<Comitente> getAllComitentes() {
        return comitenteRepository.findAll();
    }

    @Override
    public Comitente getComitenteById(Long id) {
        return comitenteRepository.findById(id).orElse(null);
    }

    @Override
    public Comitente createComitente(Comitente comitente) {
        // Verificar que el comitente no esté repetido
        Comitente existingComitente = comitenteRepository.findByDescripcion(comitente.getDescripcion());
        if (existingComitente == null) {
            return comitenteRepository.save(comitente);
        }
        return null;
    }


    @Override
    public Comitente updateComitente(Long id, Comitente comitenteDetails) {
        Comitente comitente = comitenteRepository.findById(id).orElse(null);
        if (comitente != null) {
            comitente.setDescripcion(comitenteDetails.getDescripcion());
            return comitenteRepository.save(comitente);
        }
        return null;
    }

    @Override
    public void deleteComitente(Long id) {
        comitenteRepository.deleteById(id);
    }
}