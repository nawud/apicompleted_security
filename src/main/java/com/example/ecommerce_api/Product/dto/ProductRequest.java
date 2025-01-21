package com.example.ecommerce_api.Product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record ProductRequest(

        @Positive @NotNull @NotBlank(message = "Price is required!")
        double price,

        @NotNull @NotBlank(message = "Name is required!") @Size(min = 5, max = 50, message = "Title is required, and must be between 5 and 50 characters!")
        String name,

        @URL(protocol = "https", message = "Image (URL) is required!")
        String imageURL

) {}
