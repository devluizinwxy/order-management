package com.luisdev.order_management_jpa.resource;


import com.luisdev.order_management_jpa.entities.dtos.OrderRequestDTO;
import com.luisdev.order_management_jpa.entities.dtos.OrderResponseDTO;
import com.luisdev.order_management_jpa.entities.dtos.UserRequestDTO;
import com.luisdev.order_management_jpa.entities.dtos.UserResponseDTO;
import com.luisdev.order_management_jpa.services.OrderServices;
import com.luisdev.order_management_jpa.services.UserServices;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")

public class OrderResource {
   @Autowired
    private OrderServices orderServices;

   @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll(){
       List<OrderResponseDTO> orderResponseDTOS = orderServices.findall();
        return ResponseEntity.ok(orderResponseDTOS);
   }

   @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> findById(@PathVariable Integer id){
       OrderResponseDTO orderResponseDTO = orderServices.findById(id);
       return ResponseEntity.ok(orderResponseDTO);
   }
   @PostMapping
    public ResponseEntity<OrderResponseDTO> save(@Valid @RequestBody OrderRequestDTO orderRequestDTO){
        OrderResponseDTO orderResponseDTO = orderServices.insert(orderRequestDTO);
       return ResponseEntity.ok(orderResponseDTO);
   }
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody OrderRequestDTO orderRequestDTO){
       OrderResponseDTO orderResponseDTO = orderServices.update(id, orderRequestDTO);
       return ResponseEntity.ok(orderResponseDTO);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> delete(@PathVariable Integer id){
       orderServices.deleteById(id);
       return ResponseEntity.ok().build();
   }



}
