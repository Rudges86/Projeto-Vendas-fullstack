package com.estudos.estudos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Produto")
@Data
@AllArgsConstructor
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

    public Produto() {
    }


}
