package com.example.ecommerce_api.dto.Category;

import com.example.ecommerce_api.model.Product;

import java.util.List;

public record CategoryResponse (long id, String name, List<Product> products) {}