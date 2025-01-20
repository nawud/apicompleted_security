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

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        Category category = categoryService.addCategory(CategoryMapper.DTOToEntity(request));
        return new ResponseEntity<>(CategoryMapper.EntityToDTO(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.readCategories()
                .stream()
                .map(CategoryMapper::EntityToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable long id) {
        return categoryService.findCategoryById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.EntityToDTO(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable long id,
            @Valid @RequestBody CategoryRequest request) {
        try {
            Category category = categoryService.updateCategory(id, CategoryMapper.DTOToEntity(request));
            return ResponseEntity.ok(CategoryMapper.EntityToDTO(category));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}