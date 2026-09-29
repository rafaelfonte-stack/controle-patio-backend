package com.controlepatio.repository;

import com.controlepatio.model.Veiculo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VeiculoRepository extends JpaRepository <Veiculo, Long>  {

    Boolean existsByPlacaIgnoreCase(String placa);

    Optional<Veiculo> findByPlacaIgnoreCase(String placa);
}