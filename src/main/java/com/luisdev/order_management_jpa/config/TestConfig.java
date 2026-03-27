package com.luisdev.order_management_jpa.config;

import com.luisdev.order_management_jpa.entities.Order;
import com.luisdev.order_management_jpa.entities.User;
import com.luisdev.order_management_jpa.entities.enuns.OrderStatus;
import com.luisdev.order_management_jpa.repositories.OrderRepository;
import com.luisdev.order_management_jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
@Autowired
    private OrderRepository orderRepository;
@Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
// =========================
        // USERS
        // =========================
        User u1 = new User("Luis Fernandes", "luis@email.com", "Senha@123", "12345678901");
        User u2 = new User("Maria Silva", "maria@email.com", "Senha@123", "98765432100");
        User u3 = new User("João Souza", "joao@email.com", "Senha@123", "11122233344");

        userRepository.saveAll(List.of(u1, u2, u3));


        // =========================
        // ORDERS (usando construtor)
        // =========================
        Order o1 = new Order(150.0);
        o1.setUser(u1);

        Order o2 = new Order(200.0);
        o2.setUser(u1);
        o2.setOrderStatus(OrderStatus.CONFIRMED); // alterando fluxo

        Order o3 = new Order(99.99);
        o3.setUser(u2);
        o3.setOrderStatus(OrderStatus.SHIPPED);

        Order o4 = new Order(350.0);
        o4.setUser(u2);
        o4.setOrderStatus(OrderStatus.DELIVERED);

        orderRepository.saveAll(List.of(o1, o2, o3, o4));

        // =========================
        // RELACIONAMENTO
        // =========================
        u1.getOrders().addAll(List.of(o1, o2));
        u2.getOrders().addAll(List.of(o3, o4));

        userRepository.saveAll(List.of(u1, u2));
    }
    }

