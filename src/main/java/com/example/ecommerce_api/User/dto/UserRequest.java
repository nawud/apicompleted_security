package com.example.ecommerce_api.User.dto;

import jakarta.validation.constraints.*;

public record UserRequest(

        @NotNull @NotBlank(message = "Title is required!")
        @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters.")
        String username,

        @NotNull @NotBlank(message = "Title is required!")
        String email,

        @NotNull @NotBlank(message = "Title is required!")
        String password

) {}
