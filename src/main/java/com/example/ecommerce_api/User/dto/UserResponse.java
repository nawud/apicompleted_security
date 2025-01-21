package com.example.ecommerce_api.User.dto;

public record UserResponse(
        Long id,
        String username,
        String email
) {}
