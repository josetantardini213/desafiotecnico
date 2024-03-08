package com.desafio.tecnico.controller;

import com.desafio.tecnico.entity.Comitente;
import com.desafio.tecnico.service.ComitenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comitentes")
public class ComitenteController {
    @Autowired
    private ComitenteService comitenteService;

    @GetMapping
    public List<Comitente> getAllComitentes() {
        return comitenteService.getAllComitentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comitente> getComitenteById(@PathVariable Long id) {
        Comitente comitente = comitenteService.getComitenteById(id);
        return ResponseEntity.ok(comitente);
    }

    @PostMapping
    public ResponseEntity<Comitente> createComitente(@RequestBody Comitente comitente) {
        Comitente createdComitente = comitenteService.createComitente(comitente);
        if (createdComitente == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(createdComitente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comitente> updateComitente(@PathVariable Long id, @RequestBody Comitente comitenteDetails) {
        Comitente updatedComitente = comitenteService.updateComitente(id, comitenteDetails);
        return ResponseEntity.ok(updatedComitente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComitente(@PathVariable Long id) {
        comitenteService.deleteComitente(id);
        return ResponseEntity.noContent().build();
    }
}