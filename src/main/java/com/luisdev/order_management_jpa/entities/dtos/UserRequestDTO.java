package com.luisdev.order_management_jpa.entities.dtos;


import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public record  UserRequestDTO(

        String name,
        @Email
         String email,

        String password,
        @CPF
        String cpf) {
}
