package com.example.productmanagementsys.service;

import com.example.productmanagementsys.Exception.ProductNotFoundException;
import com.example.productmanagementsys.Exception.ReviewNotFoundException;
import com.example.productmanagementsys.entity.Product;
import com.example.productmanagementsys.entity.ProductReview;
import com.example.productmanagementsys.repository.ProductRepository;
import com.example.productmanagementsys.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        // Ensure the product exists before adding the review
        Optional<Product> product = productRepository.findById(Long.parseLong(review.getProductId()));
        if (!product.isPresent()) {
            throw new ProductNotFoundException(review.getProductId());
        }

        // Set the timestamp when the review is created
        review.setTimestamp(LocalDateTime.now());
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

    // Update a review
    public ProductReview updateReview(String reviewId, ProductReview updatedReview) {
        ProductReview existingReview = productReviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        existingReview.setContent(updatedReview.getContent());
        existingReview.setRating(updatedReview.getRating());
        existingReview.setTimestamp(LocalDateTime.now());  // Update timestamp on update

        return productReviewRepository.save(existingReview);
    }
}
