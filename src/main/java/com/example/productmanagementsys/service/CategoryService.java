package com.example.productmanagementsys.service;

import com.example.productmanagementsys.entity.Category;
import com.example.productmanagementsys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Category service.
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepository the category repository
     */
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Save category category.
     *
     * @param category the category
     * @return the category
     */
// Create or Update a category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Gets category by id.
     *
     * @param id the id
     * @return the category by id
     */
// Get a category by its ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Gets all categories.
     *
     * @return the all categories
     */
// Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Gets category by name.
     *
     * @param name the name
     * @return the category by name
     */
// Get a category by its name
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    /**
     * Delete category.
     *
     * @param id the id
     */
// Delete a category
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
