package com.example.ecommerce_api.repository;

import com.example.ecommerce_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iProductRepository extends JpaRepository<Product, Long> {}
