package com.estudos.estudos.domain.entity.DTO;

import com.estudos.estudos.domain.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private String nome;
    private String email;
    private String phone;

    public UserDto(User user){
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }
}
