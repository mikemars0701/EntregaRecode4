package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idViagem;

    private LocalDateTime dataViagem;

    @Column(name = "destino_viagem", length = 50, nullable = false)
    private String destinoViagem;

    @ManyToOne
    @JoinColumn(name = "passageiro_fk")
    private Passageiro passageiro;

    @ManyToOne
    @JoinColumn(name = "piloto_fk")
    private Piloto piloto;
    
    // Getters and setters

    public long getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(long idViagem) {
        this.idViagem = idViagem;
    }

    public String getDestinoViagem() {
        return destinoViagem;
    }

    public void setDestinoViagem(String destinoViagem) {
        this.destinoViagem = destinoViagem;
    }

    public LocalDateTime getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(LocalDateTime dataViagem) {
        this.dataViagem = dataViagem;
    }

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	

   
    }

