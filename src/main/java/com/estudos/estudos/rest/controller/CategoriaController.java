package com.estudos.estudos.rest.controller;

import com.estudos.estudos.domain.entity.Categoria;
import com.estudos.estudos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getAll());
    }


    @PostMapping
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria){
        categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{categoria}")
    public boolean finByNome(@PathVariable String categoria){
        boolean cat = categoriaService.findByNome(categoria);
        if(cat){
            return true;
        }
        return false;
    }
}
