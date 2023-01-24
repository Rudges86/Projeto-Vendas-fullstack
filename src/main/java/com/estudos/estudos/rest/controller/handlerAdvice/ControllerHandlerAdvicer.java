package com.estudos.estudos.rest.controller.handlerAdvice;

import com.estudos.estudos.exception.RegradeNegocio;
import com.estudos.estudos.rest.controller.ApiErros;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerHandlerAdvicer{

    @ExceptionHandler(RegradeNegocio.class)
    public ApiErros handlerRegraException(RegradeNegocio ex){
        String messageError = ex.getMessage();
        return new ApiErros(messageError);
    }



    /*
     fluxo normal sem extender o ResponseEntityException nele já vem oMethodArgumentNotvalid
     @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiErros methodArgumentNotValidException (MethodArgumentNotValidException ex){
        List<String> messageError = ex.getBindingResult()
                                    .getAllErrors()
                                    .stream().map(error -> error.getDefaultMessage())
                                    .collect(Collectors.toList());
        return new ApiErros(messageError);
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValid(MethodArgumentNotValidException ex){
        List<String> messageError = ex.getBindingResult()
                                    .getAllErrors().stream()
                                    .map(error -> error.getDefaultMessage())
                                    .collect(Collectors.toList());
        ApiErros apiErros = new ApiErros(messageError);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErros);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgument (IllegalArgumentException ex){
        String messageError = ex.getMessage(); // mensagem em inglês
        ApiErros apiErros = new ApiErros("O id não pode ser nulo");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErros);
    }


}
