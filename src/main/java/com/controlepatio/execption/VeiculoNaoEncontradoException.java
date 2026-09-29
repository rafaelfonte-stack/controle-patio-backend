package com.controlepatio.execption;

public class VeiculoNaoEncontradoException extends RuntimeException{
    
    public VeiculoNaoEncontradoException(String menssagem){
        super(menssagem);
    }
}