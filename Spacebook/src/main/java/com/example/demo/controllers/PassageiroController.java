package com.example.demo.controllers;
import com.example.demo.models.Passageiro;
import com.example.demo.repositories.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroRepository passageiroRepository;

    // Create a new Passageiro
    @PostMapping
    public Passageiro createPassageiro(@RequestBody Passageiro passageiro) {
        return passageiroRepository.save(passageiro);
    }

    // Get all Passageiros
    @GetMapping
    public List<Passageiro> getAllPassageiros() {
        return passageiroRepository.findAll();
    }

    // Get a specific Passageiro by ID
    @GetMapping("/{id}")
    public ResponseEntity<Passageiro> getPassageiroById(@PathVariable Long id) {
        Passageiro passageiro = passageiroRepository.findById(id).orElse(null);
        if (passageiro != null) {
            return ResponseEntity.ok(passageiro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a Passageiro by ID
    @PutMapping("/{id}")
    public ResponseEntity<Passageiro> updatePassageiro(@PathVariable Long id, @RequestBody Passageiro updatedPassageiro) {
        if (!passageiroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedPassageiro.setIdPassageiro(id);
        Passageiro savedPassageiro = passageiroRepository.save(updatedPassageiro);
        return ResponseEntity.ok(savedPassageiro);
    }

    // Delete a Passageiro by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassageiro(@PathVariable Long id) {
        if (!passageiroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        passageiroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
