package com.example.demo.controllers;

import com.example.demo.models.Piloto;
import com.example.demo.repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    private PilotoRepository pilotoRepository;

    // Create a new Piloto
    @PostMapping
    public Piloto createPiloto(@RequestBody Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    // Get all Pilotos
    @GetMapping
    public List<Piloto> getAllPilotos() {
        return pilotoRepository.findAll();
    }

    // Get a specific Piloto by ID
    @GetMapping("/{id}")
    public ResponseEntity<Piloto> getPilotoById(@PathVariable Long id) {
        Piloto piloto = pilotoRepository.findById(id).orElse(null);
        if (piloto != null) {
            return ResponseEntity.ok(piloto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a Piloto by ID
    @PutMapping("/{id}")
    public ResponseEntity<Piloto> updatePiloto(@PathVariable Long id, @RequestBody Piloto updatedPiloto) {
        if (!pilotoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedPiloto.setIdPiloto(id);
        Piloto savedPiloto = pilotoRepository.save(updatedPiloto);
        return ResponseEntity.ok(savedPiloto);
    }

    // Delete a Piloto by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePiloto(@PathVariable Long id) {
        if (!pilotoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pilotoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
