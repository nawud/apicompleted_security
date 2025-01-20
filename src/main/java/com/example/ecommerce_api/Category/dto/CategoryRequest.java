package com.example.ecommerce_api.Category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryRequest(

        @NotNull @NotBlank(message = "Title is required!")
        @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters.")
        String username

) {}
