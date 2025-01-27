package com.example.ecommerce_api.dto.Category;

import com.example.ecommerce_api.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CategoryRequest (

        @NotNull
        @NotBlank(message = "Name is required!")
        @Size(min = 5, max = 30, message = "Category name must be between 5 and 30 characters.")
        String name,

        @NotNull
        List<Product> products

) {}