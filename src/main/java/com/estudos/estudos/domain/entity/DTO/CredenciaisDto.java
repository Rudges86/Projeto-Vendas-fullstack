package com.estudos.estudos.domain.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
public class CredenciaisDto {
    @NotBlank(message = "Não pode estar vazio")
    private String email;
    @NotBlank(message = "Não pode estar vazio")
    private String password;

    public CredenciaisDto() {}
    public CredenciaisDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
