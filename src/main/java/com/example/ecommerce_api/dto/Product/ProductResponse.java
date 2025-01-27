package com.example.ecommerce_api.dto.Product;

import com.example.ecommerce_api.model.Category;

public record ProductResponse (long id, double price, String name, String imageURL, Category category) {}
