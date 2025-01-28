package com.example.ecommerce_api.dto.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record ProductRequest (

        @Positive
        double price,

        @NotBlank(message = "Name is required!")
        @Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters!")
        String name,

        @URL(message = "Image URL is required!")
        String imageURL,

        long categoryId

) {}
