package com.example.ecommerce_api.dto.User;

public record UserResponse(
        Long id,
        String username,
        String email
) {}
