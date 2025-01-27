package com.example.ecommerce_api.repository;

import com.example.ecommerce_api.model.Category;
import com.example.ecommerce_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface iProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Optional<Category> category);

}
