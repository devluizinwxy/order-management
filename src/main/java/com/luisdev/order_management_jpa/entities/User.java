package com.luisdev.order_management_jpa.entities;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)

    private String email;
    @Column(nullable = false,  length = 20)
    private String password;
    @Column(unique = true, nullable = false,  length = 11)
    private String cpf;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Order> orders = new ArrayList<>();
    public User() {
    }

    public User( String name, String email, String password, String cpf) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Order> getOrders() {
        return orders;
    }


    public void addOrder(Order order) {
         this.orders.add(order);
        order.setUser(this);
    }
    public void removeOrder(Order order) {
        this.orders.remove(order);
        order.setUser(null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
