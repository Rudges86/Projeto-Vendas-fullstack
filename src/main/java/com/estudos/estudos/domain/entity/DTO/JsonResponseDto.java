package com.estudos.estudos.domain.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class JsonResponseDto {
    private String status;
    private List<String> message;

    public JsonResponseDto(String status, String message) {
        this.status = status;
        this.message = List.of(message);

    }
}
