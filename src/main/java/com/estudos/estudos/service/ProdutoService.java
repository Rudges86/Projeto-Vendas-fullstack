package com.estudos.estudos.service;

import com.estudos.estudos.domain.entity.Categoria;
import com.estudos.estudos.domain.entity.DTO.ProdutoDTO;
import com.estudos.estudos.domain.entity.Produto;
import com.estudos.estudos.domain.repository.CategoriaRepository;
import com.estudos.estudos.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    /*public List<ProdutoDTO> getAll(){
        List<Produto> produtosLista = produtoRepository.findAll();;
        List<ProdutoDTO> produtos = new ArrayList<>();
        for(Produto p : produtosLista){
            produtos.add(new ProdutoDTO(p));
        }
        return produtos;
    }
*/

    public List<Produto> getAll(){
        List<Produto> produtos= produtoRepository.findAll();
        return produtos;
    }


    public ProdutoDTO getId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));
        ProdutoDTO produtoDTO = new ProdutoDTO(produto);
        return produtoDTO;
    }

    public void saveProduto(Produto produto) {

        categoriaRepository.findById(produto.getCategoria().getId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria não existe, crie uma nova"));

        produtoRepository.save(produto);

    }

    public Produto delete(Long id) {
        return produtoRepository.findById(id).map((existe)->{
            produtoRepository.deleteById(existe.getId());
            return existe;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }
}
