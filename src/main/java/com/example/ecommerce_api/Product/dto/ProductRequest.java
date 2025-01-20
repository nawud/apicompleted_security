package com.example.ecommerce_api.Product.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record ProductRequest(

    double price,

    @NotBlank(message = "Name is required!")
    String name,

    @URL(protocol = "https", message = "Image (URL) is required!")
    String imageURL

) {}
