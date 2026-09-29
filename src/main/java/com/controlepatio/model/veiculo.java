package com.controlepatio.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity 
public class veiculo {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propietario;

    private String placa;

    private String modelo;

    private LocalDate dataEntrada;


    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }


    public String getPropietario(){
        return propietario;
    }
    public void setPropietario(String propietario){
        this.propietario = propietario;
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
    public void setplaca(String placa){
        this.placa = placa;
    

    }
    public LocalDate getDataEntrada(){
        return dataEntrada;
    }
    public void dataEntrada(LocalDate dataEntrada){
        this.dataEntrada = dataEntrada;
    }
}
