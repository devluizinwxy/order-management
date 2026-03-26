package com.luisdev.order_management_jpa.repositories;

import com.luisdev.order_management_jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
