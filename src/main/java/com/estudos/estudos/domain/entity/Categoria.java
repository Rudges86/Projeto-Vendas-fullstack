package com.estudos.estudos.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tb_categoria")
@Data
public class Categoria implements Serializable {
    private static final long SerialVerisonUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 255)
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

    public Categoria (){}

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
