package com.example.demo.ServicesImpl;


import com.example.demo.models.Passageiro;
import com.example.demo.models.Piloto;
import com.example.demo.models.Viagem;
import com.example.demo.repositories.ViagemRepository;
import com.example.demo.services.PassageiroService;
import com.example.demo.services.ViagemService;
import com.example.demo.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ViagemServiceImpl implements ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;
    
    @Autowired
    private PassageiroService passageiroService;

    @Autowired
    private PilotoService pilotoService;

    @Override
    public List<Viagem> getAllViagens() {
        return viagemRepository.findAll();
    }

    @Override
    public Viagem getViagemById(Long idViagem) {
        return viagemRepository.findById(idViagem).orElse(null);
    }

    @Override
    public Viagem saveViagem(Viagem viagem, Passageiro passageiro, Piloto piloto) {
        return viagemRepository.save(viagem);
    }

    @Override
    public Viagem updateViagem(Long idViagem, Viagem viagemAtualizada, Long idPassageiro, Long idPiloto) {
        Viagem viagemExistente = viagemRepository.findById(idViagem).orElse(null);

        if (viagemExistente != null) {
            // Update other fields of Viagem
            viagemExistente.setDestinoViagem(viagemAtualizada.getDestinoViagem());
            viagemExistente.setDataViagem(viagemAtualizada.getDataViagem());

            // Add Passageiro if idPassageiro is provided
            if (idPassageiro != null) {
                Passageiro passageiro = passageiroService.getPassageiroById(idPassageiro);
                viagemExistente.setPassageiro(passageiro);
            }

            // Add Piloto if idPiloto is provided
            if (idPiloto != null) {
                Piloto piloto = pilotoService.getPilotoById(idPiloto);
                viagemExistente.setPiloto(piloto);
            }

            // Save the updated Viagem
            return viagemRepository.save(viagemExistente);
        }

        // Handle the case where Viagem with the given id is not found
        return null;
    }


      

    @Override
    public void deleteById(Long idViagem) {
        viagemRepository.deleteById(idViagem);
    }

	
}


