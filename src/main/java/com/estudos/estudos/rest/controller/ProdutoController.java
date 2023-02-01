package com.estudos.estudos.rest.controller;

import com.estudos.estudos.domain.entity.DTO.JsonResponseDto;
import com.estudos.estudos.domain.entity.DTO.ProdutoDTO;
import com.estudos.estudos.domain.entity.Produto;
import com.estudos.estudos.service.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
   //Alterado para a implementação funcionar temporáriamente
    /*@GetMapping
    public ResponseEntity<List<ProdutoDTO>> pegaTodos(){
        List<ProdutoDTO> produtos = produtoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }*/
    @GetMapping
    public ResponseEntity<List<Produto>> pegaTodos() {
        List<Produto> produtos = produtoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getId(@PathVariable Long id){
        ProdutoDTO produtoDTO = produtoService.getId(id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getId(id));
    }

    @PostMapping
    public ResponseEntity<JsonResponseDto> saveProduto(@RequestBody Produto produto){
        produtoService.saveProduto(produto);
        JsonResponseDto jsonResponseDto = new JsonResponseDto(HttpStatus.CREATED.toString(), "Cadastrado");
        return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDTO> delete(@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //Criar atualizar e deletar


    //Paginação
    @GetMapping("/paginado")
    public ResponseEntity<Page<Produto>> produtosPaginados(Pageable pageable){

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.paginado(pageable));
    }

    //Fazer o metodo de atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProdutos(@PathVariable Long id, @RequestBody Produto produto){

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizaProduto(id,produto));
    }

}
