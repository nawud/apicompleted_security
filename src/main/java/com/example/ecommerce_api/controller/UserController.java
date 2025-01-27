package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.User.UserRequest;
import com.example.ecommerce_api.dto.User.UserResponse;
import com.example.ecommerce_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {

        UserResponse newUserResponse = userService.createUser(userRequest);
        return new ResponseEntity<>(newUserResponse, HttpStatus.CREATED);

    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> readAllUsers() {

        return new ResponseEntity<>(userService.readUsers(), HttpStatus.OK);

    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<Optional<UserResponse>> getUserById (@PathVariable long id) {

        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);

    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable long id,
            @Valid @RequestBody UserRequest userRequest
    ) {

        try {

            userService.updateUser(id, userRequest);

        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable long id) {

        try { userService.deleteUser(id); } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } return new ResponseEntity<>(HttpStatus.OK);

    }

}