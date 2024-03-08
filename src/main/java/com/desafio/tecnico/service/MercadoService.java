package com.desafio.tecnico.service;

import com.desafio.tecnico.entity.Mercado;

import java.util.List;

public interface MercadoService {
    List<Mercado> getAllMercados();

    Mercado getMercadoById(Long id);

    Mercado createMercado(Mercado mercado);

    Mercado updateMercado(Long id, Mercado mercadoDetails);

    void deleteMercado(Long id);
}
