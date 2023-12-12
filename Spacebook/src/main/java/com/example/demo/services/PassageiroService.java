package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Passageiro;
@Service
public interface PassageiroService {

    List<Passageiro> getAllPassageiros();

    Passageiro getPassageiroById(Long idPassageiro);

    Passageiro savePassageiro(Passageiro passageiro);

    Passageiro updatePassageiro(Long idPassageiro, Passageiro passageiroAtualizado);

    void deleteById(Long idPassageiro);
}

