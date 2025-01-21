package com.example.ecommerce_api.Category.controller;

import com.example.ecommerce_api.Category.dto.CategoryMapper;
import com.example.ecommerce_api.Category.dto.CategoryRequest;
import com.example.ecommerce_api.Category.dto.CategoryResponse;
import com.example.ecommerce_api.Category.model.Category;
import com.example.ecommerce_api.Category.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
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

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable long id,
            @Valid @RequestBody CategoryRequest request) {
        try {
            categoryService.updateCategory(id, request);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable long id) {
        try { categoryService.deleteCategory(id); }
        catch (RuntimeException e) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}