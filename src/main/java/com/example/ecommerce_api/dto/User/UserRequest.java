package com.example.ecommerce_api.dto.User;

import jakarta.validation.constraints.*;

public record UserRequest (

        @NotBlank(message = "Username is required!")
        @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters.")
        String username,

        @NotBlank(message = "Email is required!")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Password is required!")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password

) {}
