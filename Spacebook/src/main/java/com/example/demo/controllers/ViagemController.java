package com.example.demo.controllers;
import com.example.demo.models.Viagem;
import com.example.demo.repositories.ViagemRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

  
    @Autowired
    private ViagemRepository viagemRepository;

    // Create a new Viagem
    @PostMapping
    public Viagem createViagem(@RequestBody Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    // Get all Viagens
    @GetMapping
    public List<Viagem> getAllViagens() {
        return viagemRepository.findAll();
    }

    // Get a specific Viagem by ID
    @GetMapping("/{id}")
    public ResponseEntity<Viagem> getViagemById(@PathVariable Long id) {
        Viagem viagem = viagemRepository.findById(id).orElse(null);
        if (viagem != null) {
            return ResponseEntity.ok(viagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a Viagem by ID
    @PutMapping("/{id}")
    public ResponseEntity<Viagem> updateViagem(@PathVariable Long id, @RequestBody Viagem updatedViagem) {
        if (!viagemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedViagem.setIdViagem(id);
        Viagem savedViagem = viagemRepository.save(updatedViagem);
        return ResponseEntity.ok(savedViagem);
    }

    // Delete a Viagem by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViagem(@PathVariable Long id) {
        if (!viagemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        viagemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
