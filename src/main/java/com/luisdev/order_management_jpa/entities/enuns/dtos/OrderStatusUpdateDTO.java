package com.luisdev.order_management_jpa.entities.enuns.dtos;

import com.luisdev.order_management_jpa.entities.enuns.OrderStatus;

public record OrderStatusUpdateDTO(
        OrderStatus status
) {}