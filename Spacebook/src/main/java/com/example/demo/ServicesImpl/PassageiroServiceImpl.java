package com.example.demo.ServicesImpl;

import com.example.demo.models.Passageiro;
import com.example.demo.repositories.PassageiroRepository;
import com.example.demo.services.PassageiroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroServiceImpl implements PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Override
    public List<Passageiro> getAllPassageiros() {
        return passageiroRepository.findAll();
    }

    @Override
    public Passageiro getPassageiroById(Long idPassageiro) {
        return passageiroRepository.findById(idPassageiro).orElse(null);
    }

    @Override
    public Passageiro savePassageiro(Passageiro passageiro) {
        return passageiroRepository.save(passageiro);
    }

    @Override
    public Passageiro updatePassageiro(Long idPassageiro, Passageiro passageiroAtualizado) {
        Optional<Passageiro> existingPassageiro = passageiroRepository.findById(idPassageiro);

        if (existingPassageiro.isPresent()) {
            Passageiro updatedPassageiro = existingPassageiro.get();
            // Update the fields as needed
            updatedPassageiro.setNomePassageiro(passageiroAtualizado.getNomePassageiro());
            updatedPassageiro.setEmailPassageiro(passageiroAtualizado.getEmailPassageiro());
            // Set other fields as needed

            // Save and return the updated Passageiro
            return passageiroRepository.save(updatedPassageiro);
        } else {
            // Handle the case where the Passageiro with the given ID is not found
            return null;
        }
    }

    @Override
    public void deleteById(Long idPassageiro) {
        passageiroRepository.deleteById(idPassageiro);
    }
}


