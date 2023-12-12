package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Passageiro;


@Repository
public interface PassageiroRepository extends JpaRepository <Passageiro, Long>{

}