package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Passageiro;
import com.example.demo.models.Piloto;
import com.example.demo.models.Viagem;
@Service
public interface ViagemService {

    List<Viagem> getAllViagens();

    Viagem getViagemById(Long idViagem);

    Viagem saveViagem(Viagem viagem, Passageiro passageiro, Piloto piloto);

    Viagem updateViagem(Long idViagem, Viagem viagemAtualizada, Long idPassageiro, Long idPiloto);

    void deleteById(Long idViagem);

	
    
    
}

