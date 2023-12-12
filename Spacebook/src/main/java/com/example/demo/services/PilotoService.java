package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Piloto;
@Service
public interface PilotoService {

    List<Piloto> getAllPilotos();

    Piloto getPilotoById(Long idPiloto);

    Piloto savePiloto(Piloto piloto);

    Piloto updatePiloto(Long idPiloto, Piloto pilotoAtualizado);

    void deleteById(Long idPiloto);
}

