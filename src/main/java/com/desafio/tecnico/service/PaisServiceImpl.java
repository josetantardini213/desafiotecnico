package com.desafio.tecnico.service;

import com.desafio.tecnico.entity.Pais;
import com.desafio.tecnico.repository.PaisRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(ComitenteServiceImpl.class);


    @Override
    public Pais updatePais(Long id, Pais paisDetails) {
        try {
            Pais pais = paisRepository.findById(id).orElse(null);
            if (pais != null) {
                pais.setNombre(paisDetails.getNombre());
                return paisRepository.save(pais);
            }
            return null;
        } catch (Exception e) {
            logger.error("Error al actualizar pais", e);
            return null;
        }
    }

    @Override
    public void deletePais(Long id) {
        try{
            paisRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error al eliminar pais", e);
        }
    }
}
