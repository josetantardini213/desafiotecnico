package com.desafio.tecnico.controller;

import com.desafio.tecnico.entity.Pais;
import com.desafio.tecnico.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> getAllPaises() {
        return paisService.getAllPaises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Pais pais = paisService.getPaisById(id);
        return ResponseEntity.ok(pais);
    }

    @PostMapping
    public Pais createPais(@RequestBody Pais pais) {
        return paisService.createPais(pais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais paisDetails) {
        Pais updatedPais = paisService.updatePais(id, paisDetails);
        return ResponseEntity.ok(updatedPais);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        paisService.deletePais(id);
        return ResponseEntity.noContent().build();
    }
}