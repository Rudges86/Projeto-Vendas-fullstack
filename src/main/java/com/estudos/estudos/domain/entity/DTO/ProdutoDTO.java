package com.estudos.estudos.domain.entity.DTO;

import com.estudos.estudos.domain.entity.Categoria;
import com.estudos.estudos.domain.entity.Produto;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class ProdutoDTO {
    @NotBlank
    @Column(name = "nome", length = 40)
    private String nome;
    @NotBlank
    @Column(name="descricao", length = 255)
    private String descricao;
    @NotNull
    private Double preco;
    @NotBlank
    private Categoria categoria;

    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
    }
}
