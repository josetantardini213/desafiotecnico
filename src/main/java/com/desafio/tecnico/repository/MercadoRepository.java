package com.desafio.tecnico.repository;

import com.desafio.tecnico.entity.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {
}