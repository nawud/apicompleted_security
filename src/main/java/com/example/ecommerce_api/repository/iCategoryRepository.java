package com.example.ecommerce_api.repository;

import com.example.ecommerce_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface iCategoryRepository extends JpaRepository<Category, Long> {}
