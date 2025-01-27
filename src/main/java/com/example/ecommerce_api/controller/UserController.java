package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.User.UserRequest;
import com.example.ecommerce_api.dto.User.UserResponse;
import com.example.ecommerce_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {

        UserResponse newUserResponse = userService.createUser(request);
        return new ResponseEntity<>(newUserResponse, HttpStatus.CREATED);

    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> readAllUsers() {

        return new ResponseEntity<>(userService.readUsers(), HttpStatus.OK);

    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable long id,
            @Valid @RequestBody UserRequest request
    ) {

        try { userService.updateUser(id, request); } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } return  new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable long id) {

        try { userService.deleteUser(id); } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } return new ResponseEntity<>(HttpStatus.OK);

    }

}