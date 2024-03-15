package com.desafio.tecnico.repository;

import com.desafio.tecnico.entity.Mercado;
import com.desafio.tecnico.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {
    List<Mercado> findByPais(Pais pais);

}