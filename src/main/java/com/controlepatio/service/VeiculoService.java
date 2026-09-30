package com.controlepatio.service;

import com.controlepatio.model.Veiculo;
import com.controlepatio.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import com.controlepatio.execption.PlacaDuplicadaException;
import com.controlepatio.execption.VeiculoNaoEncontradoException;

@Service 
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo cadastrar(Veiculo veiculo){

        veiculo.setPlaca(veiculo.getPlaca().trim().toUpperCase());

        if(veiculoRepository.existsByPlacaIgnoreCase(veiculo.getPlaca())){
            throw new PlacaDuplicadaException("A placa já está cadastrada.");
        }
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo atualizar(String placa, Veiculo veiculoAtualizado ){

        String placaNormalizada = placa.trim().toUpperCase();

        Veiculo veiculo = veiculoRepository.findByPlacaIgnoreCase(placaNormalizada).orElseThrow(() -> new VeiculoNaoEncontradoException("Veículo não encontrado."));
        
        String novaPlaca = veiculoAtualizado.getPlaca().trim().toUpperCase();

        if(!novaPlaca.equalsIgnoreCase(veiculo.getPlaca()) && veiculoRepository.existsByPlacaIgnoreCase(novaPlaca)){

            throw new PlacaDuplicadaException("A placa já está cadastrada.");

        }

        veiculo.setProprietario(veiculoAtualizado.getProprietario());
        veiculo.setPlaca(novaPlaca);
        veiculo.setModelo(veiculoAtualizado.getModelo());
        veiculo.setDataEntrada(veiculoAtualizado.getDataEntrada());
    
        return veiculoRepository.save(veiculo);
    }

    public void remover(String placa){
        String placaNormalizada = placa.trim().toUpperCase();
        Veiculo veiculo = veiculoRepository.findByPlacaIgnoreCase(placaNormalizada).orElseThrow(() -> new VeiculoNaoEncontradoException("Veículo não encontrado."));
        
        veiculoRepository.delete(veiculo);
    }
}