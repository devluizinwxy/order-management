package com.luisdev.order_management_jpa.services;

import com.luisdev.order_management_jpa.entities.User;
import com.luisdev.order_management_jpa.entities.dtos.UserRequestDTO;
import com.luisdev.order_management_jpa.entities.dtos.UserResponseDTO;
import com.luisdev.order_management_jpa.repositories.OrderRepository;
import com.luisdev.order_management_jpa.repositories.UserRepository;
import com.luisdev.order_management_jpa.services.exceptions.DatabaseException;
import com.luisdev.order_management_jpa.services.exceptions.ResourceNotFoundException;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public List<UserResponseDTO> findAll(){
      List<User> userList = userRepository.findAll();
      return userList.stream().map(UserResponseDTO::fromEntity).toList();
    }
    public UserResponseDTO findById(int id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return UserResponseDTO.fromEntity(user);
    }
    public UserResponseDTO insert(UserRequestDTO userRequestDTO){
        User user = userRequestDTO.toUserEntity();
        userRepository.save(user);
        return UserResponseDTO.fromEntity(user);
    }
    public UserResponseDTO update(int id, UserRequestDTO userRequestDTO){
        User entity = userRepository.getReferenceById(id);
        updateData(entity,userRequestDTO);
       return UserResponseDTO.fromEntity(entity);
    }

    private void updateData(User entity, UserRequestDTO userRequestDTO) {
        entity.setName(userRequestDTO.name());
        entity.setEmail(userRequestDTO.email());
        entity.setCpf(userRequestDTO.cpf());
    }
    public  void deleteById(int id){
        if (!userRepository.existsById(id)) {
           throw new ResourceNotFoundException(id);
        }
        try{
            userRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }


}
