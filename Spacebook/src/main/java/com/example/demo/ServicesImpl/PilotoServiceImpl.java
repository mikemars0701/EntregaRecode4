package com.example.demo.ServicesImpl;

import com.example.demo.models.Piloto;
import com.example.demo.repositories.PilotoRepository;
import com.example.demo.services.PilotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotoServiceImpl implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    @Override
    public List<Piloto> getAllPilotos() {
        return pilotoRepository.findAll();
    }

    @Override
    public Piloto getPilotoById(Long idPiloto) {
        return pilotoRepository.findById(idPiloto).orElse(null);
    }

    @Override
    public Piloto savePiloto(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    @Override
    public Piloto updatePiloto(Long idPiloto, Piloto pilotoAtualizado) {
        Optional<Piloto> existingPiloto = pilotoRepository.findById(idPiloto);

        if (existingPiloto.isPresent()) {
            Piloto updatedPiloto = existingPiloto.get();
            // Update the fields as needed
            updatedPiloto.setNomePiloto(pilotoAtualizado.getNomePiloto());
            updatedPiloto.setEspecialidadePiloto(pilotoAtualizado.getEspecialidadePiloto());
            // Set other fields as needed

            // Save and return the updated Piloto
            return pilotoRepository.save(updatedPiloto);
        } else {
            // Handle the case where the Piloto with the given ID is not found
            return null;
        }
    }

    @Override
    public void deleteById(Long idPiloto) {
        pilotoRepository.deleteById(idPiloto);
    }
}

