package com.luisdev.order_management_jpa.repositories;

import com.luisdev.order_management_jpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
