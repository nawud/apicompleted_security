package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.Category.CategoryRequest;
import com.example.ecommerce_api.dto.Category.CategoryResponse;
import com.example.ecommerce_api.dto.Product.ProductResponse;
import com.example.ecommerce_api.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/api/categories")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {

        CategoryResponse newCategoryResponse = categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(newCategoryResponse, HttpStatus.CREATED);

    }

    @GetMapping("/api/categories")
    public ResponseEntity<List<CategoryResponse>> readAllCategories() {

        return new ResponseEntity<>(categoryService.readCategories(), HttpStatus.OK);

    }

    @GetMapping("/api/categories/{id}")
    public ResponseEntity<Optional<CategoryResponse>> getCategoryById (@PathVariable long id) {

        Optional<CategoryResponse> categoryResponse = categoryService.findCategoryById(id);

        if (categoryResponse.isPresent()) {

            return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable long id,
            @Valid @RequestBody CategoryRequest categoryRequest
    ) {

        try {

            categoryService.updateCategory(id, categoryRequest);

        } catch (RuntimeException e) {

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