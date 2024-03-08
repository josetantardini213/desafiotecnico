package com.desafio.tecnico.service;

import com.desafio.tecnico.entity.Pais;
import com.desafio.tecnico.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    @Override
    public Pais getPaisById(Long id) {
        return paisRepository.findById(id).orElse(null);
    }

    @Override
    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public Pais updatePais(Long id, Pais paisDetails) {
        Pais pais = paisRepository.findById(id).orElse(null);
        if (pais != null) {
            pais.setNombre(paisDetails.getNombre());
            return paisRepository.save(pais);
        }
        return null;
    }

    @Override
    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }
}
