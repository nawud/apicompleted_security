package com.example.ecommerce_api.Category.service;

import com.example.ecommerce_api.Category.model.Category;
import com.example.ecommerce_api.Category.repository.iCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final iCategoryRepository iCategoryRepository;

    public CategoryService(iCategoryRepository iCategoryRepository) { this.iCategoryRepository = iCategoryRepository; }

    // CREATE
    public Category addCategory(Category newCategory) { return iCategoryRepository.save(newCategory); }

    // READ
    public List<Category> readCategories() { return iCategoryRepository.findAll(); }

    // UPDATE
    public Category updateCategory(long id, Category updatingCategory) {

        Optional<Category> foundCategory = iCategoryRepository.findById(id);

        if (foundCategory.isPresent()) {

            Category existingCategory = foundCategory.get();

            existingCategory.setName(updatingCategory.getName());

            return iCategoryRepository.save(existingCategory);

        } throw new RuntimeException("Category with id: " + id + " not found.");

    }

    // DELETE
    public void deleteCategory(long id) { iCategoryRepository.deleteById(id); }

    /* FILTERS */

    // Id
    public Optional<Category> findCategoryById(long id) { return iCategoryRepository.findById(id); }

}