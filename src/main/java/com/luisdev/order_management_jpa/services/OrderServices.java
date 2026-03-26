package com.luisdev.order_management_jpa.services;

import com.luisdev.order_management_jpa.entities.Order;
import com.luisdev.order_management_jpa.entities.dtos.OrderRequestDTO;
import com.luisdev.order_management_jpa.entities.dtos.OrderResponseDTO;
import com.luisdev.order_management_jpa.repositories.OrderRepository;
import com.luisdev.order_management_jpa.services.exceptions.DatabaseException;
import com.luisdev.order_management_jpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;
    public List<OrderResponseDTO> findall(){
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(order -> OrderResponseDTO.fromEntity(order)).toList();
    }
    public OrderResponseDTO findById(Integer id){
        Order order = orderRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
        return OrderResponseDTO.fromEntity(order);
    }
    public OrderResponseDTO insert(OrderRequestDTO orderRequestDTO) {
       Order order = new Order(orderRequestDTO.TotalPrice());
       orderRepository.save(order);
       return OrderResponseDTO.fromEntity(order);
    }
    public OrderResponseDTO update(Integer id,OrderRequestDTO orderRequestDTO) {
        Order entity = orderRepository.getReferenceById(id);
        updateData(entity,orderRequestDTO);
        orderRepository.save(entity);
        return OrderResponseDTO.fromEntity(entity);
    }
    private void updateData(Order entity, OrderRequestDTO orderRequestDTO) {
        entity.setTotalPrice(orderRequestDTO.TotalPrice());
    }
    public void deleteById(Integer id){
        if(!orderRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }try{
            orderRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }

    }
}
