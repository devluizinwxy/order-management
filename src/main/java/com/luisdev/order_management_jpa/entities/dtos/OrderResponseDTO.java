package com.luisdev.order_management_jpa.entities.dtos;

import com.luisdev.order_management_jpa.entities.Order;
import com.luisdev.order_management_jpa.entities.enuns.OrderStatus;

import java.time.Instant;

public record OrderResponseDTO(Instant dataOrder, Double TotalPrice, OrderStatus orderStatus ) {
    public static OrderResponseDTO fromEntity(Order order) {
       return new OrderResponseDTO(order.getOrderDate(), order.getTotalPrice(), order.getOrderStatus());
    }
}
