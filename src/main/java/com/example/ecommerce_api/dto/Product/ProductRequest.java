package com.example.ecommerce_api.dto.Product;

import com.example.ecommerce_api.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record ProductRequest (

        @NotNull
        double price,

        @NotNull
        @NotBlank(message = "Name is required!")
        @Size(min = 5, max = 50, message = "Title is required, and must be between 5 and 50 characters!")
        String name,

        @URL(protocol = "https", message = "Image (URL) is required!")
        String imageURL,

        @NotNull
        Category category

) {}
