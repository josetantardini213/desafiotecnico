package com.desafio.tecnico.controller;

import com.desafio.tecnico.entity.Mercado;
import com.desafio.tecnico.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mercados")
public class MercadoController {
    @Autowired
    private MercadoService mercadoService;

    @GetMapping
    public List<Mercado> getAllMercados() {
        return mercadoService.getAllMercados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mercado> getMercadoById(@PathVariable Long id) {
        Mercado mercado = mercadoService.getMercadoById(id);
        return ResponseEntity.ok(mercado);
    }

    @PostMapping
    public Mercado createMercado(@RequestBody Mercado mercado) {
        return mercadoService.createMercado(mercado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercado> updateMercado(@PathVariable Long id, @RequestBody Mercado mercadoDetails) {
        Mercado updatedMercado = mercadoService.updateMercado(id, mercadoDetails);
        return ResponseEntity.ok(updatedMercado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMercado(@PathVariable Long id) {
        mercadoService.deleteMercado(id);
        return ResponseEntity.noContent().build();
    }
}