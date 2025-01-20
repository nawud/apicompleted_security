package com.example.ecommerce_api.Category.controller;

import com.example.ecommerce_api.Category.model.Category;
import com.example.ecommerce_api.Category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryService CategoryService;

    public CategoryController(CategoryService CategoryService) { this.CategoryService = CategoryService; }

    // CREATE
    @PostMapping("/api/categories")
    public void createCategory(@RequestBody Category newCategory) { CategoryService.addCategory(newCategory); }

    // READ
    @GetMapping("/api/categories")
    public List<Category> readAllCategories() { return CategoryService.readCategories(); }

    // UPDATE
    @PutMapping("/api/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category updatingCategory) {

        try {

            Category Category = CategoryService.updateCategory(id, updatingCategory);
            return new ResponseEntity<>(Category, HttpStatus.ACCEPTED);

        } catch (Exception e) { return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); }

    }

    // DELETE
    @DeleteMapping("/api/categories/{id}")
    public void deleteCategory(@PathVariable long id) { CategoryService.deleteCategory(id); }

    /* FILTERS */

    // ID
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable long id) {

        Optional<Category> foundCategory = CategoryService.findCategoryById(id);

        if (foundCategory.isPresent()) {

            return new ResponseEntity<>(foundCategory.get(), HttpStatus.FOUND);

        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}