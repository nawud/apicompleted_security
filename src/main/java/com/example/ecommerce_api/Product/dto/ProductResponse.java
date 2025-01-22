package com.example.ecommerce_api.Product.dto;

public record ProductResponse (

        long id,
        double price,
        String name,
        String imageURL

) {}
