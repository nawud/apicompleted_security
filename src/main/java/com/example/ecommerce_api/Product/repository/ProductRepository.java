package com.example.ecommerce_api.Product.repository;

import com.example.ecommerce_api.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
