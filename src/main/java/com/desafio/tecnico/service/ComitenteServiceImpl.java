package com.desafio.tecnico.service;

import com.desafio.tecnico.entity.Comitente;
import com.desafio.tecnico.repository.ComitenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

@Service
public class ComitenteServiceImpl implements ComitenteService{
    @Autowired
    private ComitenteRepository comitenteRepository;


    @Override
    public List<Comitente> getAllComitentes() {
        return comitenteRepository.findAllWithMercadosAndPais();
    }

    @Override
    public Comitente getComitenteById(Long id) {
        return comitenteRepository.findById(id).orElse(null);
    }

    private static final Logger logger = LogManager.getLogger(ComitenteServiceImpl.class);


    @Override
    public Comitente createComitente(Comitente comitente) {
        try{
        // Verificar que el comitente no esté repetido
        Comitente existingComitente = comitenteRepository.findByDescripcion(comitente.getDescripcion());
        if (existingComitente == null) {
            return comitenteRepository.save(comitente);
        }
        return null;
        } catch (Exception e) {
            logger.error("Error al crear comitente", e);
            return null;
        }
    }


    @Override
    public Comitente updateComitente(Long id, Comitente comitenteDetails) {
        try {
            Comitente comitente = comitenteRepository.findById(id).orElse(null);
            if (comitente != null) {
                comitente.setDescripcion(comitenteDetails.getDescripcion());
                return comitenteRepository.save(comitente);
            }
            return null;
        } catch (Exception e) {
            logger.error("Error al actualizar comitente", e);
            return null;
        }
    }

    @Override
    public void deleteComitente(Long id) {
        try {
            comitenteRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error al eliminar comitente", e);
        }
    }
}