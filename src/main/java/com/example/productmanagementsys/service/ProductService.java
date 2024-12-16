package com.example.productmanagementsys.service;

import com.example.productmanagementsys.entity.Product;
import com.example.productmanagementsys.entity.ProductReview;
import com.example.productmanagementsys.repository.ProductRepository;
import com.example.productmanagementsys.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;  // JPA (PostgreSQL)
    private final ProductReviewRepository productReviewRepository;  // MongoDB

    @Autowired
    public ProductService(ProductRepository productRepository, ProductReviewRepository productReviewRepository) {
        this.productRepository = productRepository;
        this.productReviewRepository = productReviewRepository;
    }

    // Product CRUD operations

    // Create or Update a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get a product by its ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get products by category ID
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    // Delete a product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Product Review CRUD operations

    // Add a product review
    public ProductReview addReview(ProductReview review) {
        return productReviewRepository.save(review);
    }

    // Get reviews by product ID
    public List<ProductReview> getReviewsByProductId(String productId) {
        return productReviewRepository.findByProductId(productId);
    }

    // Delete a product review
    public void deleteReview(String reviewId) {
        productReviewRepository.deleteById(reviewId);
    }
}
