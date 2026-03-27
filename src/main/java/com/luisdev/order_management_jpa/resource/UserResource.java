package com.luisdev.order_management_jpa.resource;

import com.luisdev.order_management_jpa.entities.dtos.UserRequestDTO;
import com.luisdev.order_management_jpa.entities.dtos.UserResponseDTO;
import com.luisdev.order_management_jpa.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    UserServices userServices;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> users = userServices.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Integer id) {
        UserResponseDTO user = userServices.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        UserResponseDTO user = userServices.insert(userRequestDTO);
        return ResponseEntity.ok().body(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Integer id,@RequestBody @Valid UserRequestDTO userRequestDTO) {
        UserResponseDTO user = userServices.update(id, userRequestDTO);
        return ResponseEntity.ok().body(user);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> delete(@PathVariable Integer id) {
        userServices.deleteById(id);
        return ResponseEntity.notFound().build();
    }


}
