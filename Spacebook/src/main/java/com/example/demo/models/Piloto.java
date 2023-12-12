package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;



@Entity
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPiloto;

    private String nomePiloto;
    private String especialidadePiloto;
    private String certificacaoPiloto;

    @Transient
    @OneToMany(mappedBy = "viagens")
	@JsonIgnore
	private Set<Viagem> viagens = new HashSet<>();

    // Getters and setters

    public long getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(long idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public String getEspecialidadePiloto() {
        return especialidadePiloto;
    }

    public void setEspecialidadePiloto(String especialidadePiloto) {
        this.especialidadePiloto = especialidadePiloto;
    }

    public String getCertificacaoPiloto() {
        return certificacaoPiloto;
    }

    public void setCertificacaoPiloto(String certificacaoPiloto) {
        this.certificacaoPiloto = certificacaoPiloto;
    }

    
}
