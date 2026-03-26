package com.luisdev.order_management_jpa.entities.dtos;



import com.luisdev.order_management_jpa.entities.Order;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record OrderRequestDTO(
        @NotNull
        @Min(0)
        Integer userId,
        @NotNull
        @Min(0)
        Double TotalPrice ) {

}
