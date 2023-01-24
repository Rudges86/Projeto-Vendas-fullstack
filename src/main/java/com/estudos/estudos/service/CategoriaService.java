package com.estudos.estudos.service;

import com.estudos.estudos.domain.entity.Categoria;
import com.estudos.estudos.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }

    //Se ela existir não posso deixar salvar uma nova, se ela não existir pode salvar
    public void save(Categoria categoria) {
        boolean cat = findByNome(categoria.getNome());

        if(cat){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria já existe");
        }else {
            categoriaRepository.save(categoria);
        }
    }

    public boolean findByNome(String nome){
        Categoria cat = categoriaRepository.findByNome(nome);
        if(cat != null){
            return true;
        }
        return false;
    };
}
