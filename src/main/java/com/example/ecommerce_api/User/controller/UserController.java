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
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
       UserResponse newUserResponse = userService.addUser(request);
        return new ResponseEntity<>(newUserResponse, HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> getUsers() {

        return new ResponseEntity<>(userService.readUsers(), HttpStatus.OK);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable long id,
            @Valid @RequestBody UserRequest request) {
        try {
          userService.updateUser(id, request);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable long id) {
       try {userService.deleteUser(id);}

       catch (RuntimeException e) { return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<>(HttpStatus.OK);
    }
}