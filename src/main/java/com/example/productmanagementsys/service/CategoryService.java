package com.example.productmanagementsys.service;

import com.example.productmanagementsys.entity.Category;
import com.example.productmanagementsys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create or Update a category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get a category by its ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get a category by its name
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    // Delete a category
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
