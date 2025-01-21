package com.example.ecommerce_api.User.controller;

import com.example.ecommerce_api.User.dto.UserMapper;
import com.example.ecommerce_api.User.dto.UserRequest;
import com.example.ecommerce_api.User.dto.UserResponse;
import com.example.ecommerce_api.User.model.User;
import com.example.ecommerce_api.User.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        User user = userService.addUser(UserMapper.DTOToEntity(request));
        return new ResponseEntity<>(UserMapper.EntityToDTO(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.readUsers()
                .stream()
                .map(UserMapper::EntityToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable long id) {
        return userService.findUserById(id)
                .map(user -> ResponseEntity.ok(UserMapper.EntityToDTO(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable long id,
            @Valid @RequestBody UserRequest request) {
        try {
            User user = userService.updateUser(id, UserMapper.DTOToEntity(request));
            return ResponseEntity.ok(UserMapper.EntityToDTO(user));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}