package com.example.ecommerce_api.service;

import ch.qos.logback.core.model.Model;
import com.example.ecommerce_api.dto.User.UserMapper;
import com.example.ecommerce_api.dto.User.UserRequest;
import com.example.ecommerce_api.dto.User.UserResponse;
import com.example.ecommerce_api.exceptions.EmptyException;
import com.example.ecommerce_api.exceptions.ObjectNotFoundException;
import com.example.ecommerce_api.model.User;
import com.example.ecommerce_api.repository.iUserRepository;
import jakarta.persistence.metamodel.Metamodel;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final iUserRepository iUserRepository;

    public UserService(iUserRepository iUserRepository) {

        this.iUserRepository = iUserRepository;

    }

    public UserResponse createUser(UserRequest userRequest) {

        User newUser = UserMapper.DTOToEntity(userRequest);
        User savedUser = iUserRepository.save(newUser);

        return UserMapper.EntityToDTO(savedUser);

    }

    public List<UserResponse> readUsers() {

        List<User> users = iUserRepository.findAll();

        if (users.isEmpty()) throw new EmptyException();

        return users.stream().map(UserMapper::EntityToDTO).toList();

    }

    public User updateUser (long id, UserRequest userRequest) {

        Optional<User> foundUser = iUserRepository.findById(id);

        if (foundUser.isPresent()) {

            User existingUser = foundUser.get();

            existingUser.setUsername(userRequest.username());
            existingUser.setEmail(userRequest.email());
            existingUser.setPassword(userRequest.password());

            return iUserRepository.save(existingUser);

        } throw new ObjectNotFoundException(userRequest.username(), id);

    }

    public void deleteUser (long id) { iUserRepository.deleteById(id); }

}
