package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;

@Entity
public class Passageiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPassageiro;

    private String emailPassageiro;
    private String senhaPassageiro;
    private String nomePassageiro;
    private String enderecoPassageiro;
    private String cpfPassageiro;
    private String telefonePassageiro;

    
    @Transient
    @OneToMany(mappedBy = "viagens")
	@JsonIgnore
	private Set<Viagem> viagens = new HashSet<>();
    
    // Getters e Setters

    public long getIdPassageiro() {
        return idPassageiro;
    }

    public void setIdPassageiro(long idPassageiro) {
        this.idPassageiro = idPassageiro;
    }

    public String getEmailPassageiro() {
        return emailPassageiro;
    }

    public void setEmailPassageiro(String emailPassageiro) {
        this.emailPassageiro = emailPassageiro;
    }

    public String getSenhaPassageiro() {
        return senhaPassageiro;
    }

    public void setSenhaPassageiro(String senhaPassageiro) {
        this.senhaPassageiro = senhaPassageiro;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public String getEnderecoPassageiro() {
        return enderecoPassageiro;
    }

    public void setEnderecoPassageiro(String enderecoPassageiro) {
        this.enderecoPassageiro = enderecoPassageiro;
    }

    public String getCpfPassageiro() {
        return cpfPassageiro;
    }

    public void setCpfPassageiro(String cpfPassageiro) {
        this.cpfPassageiro = cpfPassageiro;
    }

    public String getTelefonePassageiro() {
        return telefonePassageiro;
    }

    public void setTelefonePassageiro(String telefonePassageiro) {
        this.telefonePassageiro = telefonePassageiro;
    }

   
    }

