package com.example.ecommerce_api.service;

import com.example.ecommerce_api.dto.Category.CategoryMapper;
import com.example.ecommerce_api.dto.Category.CategoryRequest;
import com.example.ecommerce_api.dto.Category.CategoryResponse;
import com.example.ecommerce_api.model.Category;
import com.example.ecommerce_api.repository.iCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final iCategoryRepository iCategoryRepository;

    public CategoryService(iCategoryRepository iCategoryRepository) { this.iCategoryRepository = iCategoryRepository; }

    // CREATE
    public CategoryResponse addCategory(CategoryRequest newCategoryRequest) {

        Category newCategory = CategoryMapper.DTOToEntity(newCategoryRequest);
        Category savedCategory = iCategoryRepository.save(newCategory);

        return CategoryMapper.EntityToDTO(savedCategory);

    }

    // READ
    public List<CategoryResponse> readCategories() {

        List<Category> categories = iCategoryRepository.findAll();

        if (categories.isEmpty()) throw new RuntimeException("Not found");

        return categories.stream().map(category -> CategoryMapper.EntityToDTO(category)).toList();

    }

    // UPDATE
    public Category updateCategory(long id, CategoryRequest categoryRequest) {

        Optional<Category> foundCategory = iCategoryRepository.findById(id);

        if (foundCategory.isPresent()) {

            Category existingCategory = foundCategory.get();

            existingCategory.setName(categoryRequest.name());

            return iCategoryRepository.save(existingCategory);

        } throw new RuntimeException("User with id: " + id + " not found.");

    }

    // DELETE
    public void deleteCategory(long id) { iCategoryRepository.deleteById(id); }

}