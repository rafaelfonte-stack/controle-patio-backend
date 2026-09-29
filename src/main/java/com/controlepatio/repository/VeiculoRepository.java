package com.controlepatio.repository;

import com.controlepatio.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VeiculoRepository extends JpaRepository <Veiculo, Long>  {

    Boolean existsByPlacaIgnoreCase(String placa);
}