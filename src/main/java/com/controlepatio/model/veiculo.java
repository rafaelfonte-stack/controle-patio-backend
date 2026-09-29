package com.controlepatio.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity 
public class Veiculo {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String proprietario;

    private String placa;

    private String modelo;

    private LocalDate dataEntrada;


    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }


    public String getProprietario(){
        return proprietario;
    }
    public void setProprietario(String proprietario){
        this.proprietario = proprietario;
    }


    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }


    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    

    }
    public LocalDate getDataEntrada(){
        return dataEntrada;
    }
    public void setDataEntrada(LocalDate dataEntrada){
        this.dataEntrada = dataEntrada;
    }
}
