package com.example.ecommerce_api.dto.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryRequest (

        long id,

        @NotNull @NotBlank(message = "Category is required!")
        @Size(min = 5, max = 30, message = "Name must be between 5 and 30 characters.")
        String name

) {}