package com.estudos.estudos.rest.controller;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
    @Getter
    public List<String> erros;

    public ApiErros(List<String> erros) {
        this.erros = erros;
    }

    public ApiErros(String messageError) {
        this.erros = Arrays.asList(messageError);
    }
}
