package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.Category.CategoryRequest;
import com.example.ecommerce_api.dto.Category.CategoryResponse;
import com.example.ecommerce_api.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/api/categories")
    public ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest categoryRequest) {

        CategoryResponse newCategoryResponse = categoryService.addCategory(categoryRequest);
        return new ResponseEntity<>(newCategoryResponse, HttpStatus.CREATED);

    }

    @GetMapping("/api/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {

        return new ResponseEntity<>(categoryService.readCategories(), HttpStatus.OK);

    }

    @PutMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable long id,
            @Valid @RequestBody CategoryRequest request
    ) {

        try { categoryService.updateCategory(id, request); } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } return  new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable long id) {

        try { categoryService.deleteCategory(id); } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } return new ResponseEntity<>(HttpStatus.OK);

    }

}