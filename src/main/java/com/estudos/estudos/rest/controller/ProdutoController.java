package com.estudos.estudos.rest.controller;

import com.estudos.estudos.domain.entity.DTO.JsonResponseDto;
import com.estudos.estudos.domain.entity.DTO.ProdutoDTO;
import com.estudos.estudos.domain.entity.Produto;
import com.estudos.estudos.service.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produto")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> pegaTodos(){
        List<ProdutoDTO> produtos = produtoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getId(@PathVariable Long id){
        ProdutoDTO produtoDTO = produtoService.getId(id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoDTO);
    }

    @PostMapping
    public ResponseEntity<JsonResponseDto> saveProduto(@RequestBody Produto produto){
        produtoService.saveProduto(produto);
        JsonResponseDto jsonResponseDto = new JsonResponseDto(HttpStatus.CREATED.toString(), "Cadastrado");
        return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponseDto);
    }

    //Criar atualizar e deletar

}
