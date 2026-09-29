package com.controlepatio.service;

import com.controlepatio.model.Veiculo;
import com.controlepatio.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service 
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo cadastrar(Veiculo veiculo){

        if(veiculoRepository.existsByPlacaIgnoreCase(veiculo.getPlaca())){
            throw new RuntimeException("A placa já está cadastrada.");
        }
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }
}