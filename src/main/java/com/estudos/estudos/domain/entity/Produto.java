package com.estudos.estudos.domain.entity;

import com.estudos.estudos.domain.entity.DTO.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Produto")
@Data

public class Produto implements Serializable {
    private static final Long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "nome", length = 40)
    private String nome;
    @NotBlank
    @Column(name="descricao", length = 255)
    private String descricao;
    @NotNull
    private Double preco;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @Column(name = "Data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    public Produto(){};
    public Produto(Long id, String nome, String descricao, Double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    @PrePersist
    public void dataCadastro(){
        setDataCadastro(LocalDate.now());
    }

}
