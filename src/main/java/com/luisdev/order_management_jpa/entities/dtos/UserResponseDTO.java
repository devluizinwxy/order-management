package com.luisdev.order_management_jpa.entities.dtos;

import com.luisdev.order_management_jpa.entities.User;

public record UserResponseDTO(Integer id, String name, String email, String cpf) {
     public static UserResponseDTO fromEntity(User user){
            return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getCpf());
     }
}
