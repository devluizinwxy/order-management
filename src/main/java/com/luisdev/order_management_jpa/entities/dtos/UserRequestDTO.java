package com.luisdev.order_management_jpa.entities.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record  UserRequestDTO(
        @NotNull(message = "Name not null")
        @NotBlank(message = "Name is required")
        String name,
        @NotNull(message = "Email not null")
        @Email(message = "Email inválid")
         String email,
        @NotNull(message = "Password not null")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$", message = "Password invalid")
        String password,
        @NotNull(message = "CPF not null")
        @CPF(message = "CPF invalid")
        String cpf) {
}
