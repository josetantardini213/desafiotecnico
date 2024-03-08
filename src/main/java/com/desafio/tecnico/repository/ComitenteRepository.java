package com.desafio.tecnico.repository;

import com.desafio.tecnico.entity.Comitente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComitenteRepository extends JpaRepository<Comitente, Long> {
    // Método personalizado para buscar comitentes por descripción
    Comitente findByDescripcion(String descripcion);
}