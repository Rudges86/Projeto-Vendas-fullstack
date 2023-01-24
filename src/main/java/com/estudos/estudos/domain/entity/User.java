package com.estudos.estudos.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="Tb_user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Column(name = "nome", length = 255)
    private String nome;
    @Email
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    @Column(name = "telefone", length = 11)
    private String phone;
    @NotNull
    @NotBlank
    private String password;

    @Column(name = "Data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    public User(){}

    public User(Long id, String nome, String email, String phone, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @PrePersist
    private void setData(){
        setDate(LocalDate.now());
    }

}
