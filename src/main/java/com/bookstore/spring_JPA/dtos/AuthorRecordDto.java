package com.bookstore.spring_JPA.dtos;

//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;

public record AuthorRecordDto(//@NotBlank(message = "O nome não pode estar em branco")
    //@Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    String name) {
}
