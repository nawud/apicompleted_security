package com.example.ecommerce_api.Category.repository;

import com.example.ecommerce_api.Category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iCategoryRepository extends JpaRepository<Category, Long> {}
