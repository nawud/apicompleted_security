package com.example.ecommerce_api.repository;

import com.example.ecommerce_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iCategoryRepository extends JpaRepository<Category, Long> {}
