package com.desafio.tecnico.service;

import com.desafio.tecnico.entity.Mercado;
import com.desafio.tecnico.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MercadoServiceImpl implements MercadoService{
    @Autowired
    private MercadoRepository mercadoRepository;

    @Override
    public List<Mercado> getAllMercados() {
        return mercadoRepository.findAll();
    }

    @Override
    public Mercado getMercadoById(Long id) {
        return mercadoRepository.findById(id).orElse(null);
    }


    @Override
    public Mercado createMercado(Mercado mercado) {
        return mercadoRepository.save(mercado);
    }


    @Override
    public Mercado updateMercado(Long id, Mercado mercadoDetails) {
        Mercado mercado = mercadoRepository.findById(id).orElse(null);
        if (mercado != null) {
            mercado.setCodigo(mercadoDetails.getCodigo());
            mercado.setDescripcion(mercadoDetails.getDescripcion());
            mercado.setPais(mercadoDetails.getPais());
            return mercadoRepository.save(mercado);
        }
        return null;
    }

    @Override
    public void deleteMercado(Long id) {
        mercadoRepository.deleteById(id);
    }
}