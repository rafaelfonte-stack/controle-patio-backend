package com.controlepatio.controller;

import com.controlepatio.model.Veiculo;
import com.controlepatio.service.VeiculoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping("/veiculos")
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoService.cadastrar(veiculo);
    }
}