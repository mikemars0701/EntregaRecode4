package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository <Viagem, Long>{

}
