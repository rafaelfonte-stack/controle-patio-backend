package com.controlepatio.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> tratarErroValidacao(MethodArgumentNotValidException exception) {
        return Map.of(
                "tipo", "VALIDACAO",
                "mensagem", "Existem campos obrigatórios não preenchidos."
        );
    }

    @ExceptionHandler(PlacaDuplicadaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> tratarPlacaDuplicada(PlacaDuplicadaException exception) {
        return Map.of(
                "tipo", "PLACA_DUPLICADA",
                "mensagem", exception.getMessage()
        );
    }

    @ExceptionHandler(VeiculoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public String VeiculoNaoEncontradoException(VeiculoNaoEncontradoException exception){
        return exception.getMessage();
    }
    

    public String tratarErro(MethodArgumentNotValidException exception){
        return ("preencha todos os campos");
    }
}
