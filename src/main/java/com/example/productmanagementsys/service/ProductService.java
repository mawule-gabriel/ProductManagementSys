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

/**
 * The type Product service.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;  // JPA (PostgreSQL)
    private final ProductReviewRepository productReviewRepository;  // MongoDB

    /**
     * Instantiates a new Product service.
     *
     * @param productRepository       the product repository
     * @param productReviewRepository the product review repository
     */
    @Autowired
    public ProductService(ProductRepository productRepository, ProductReviewRepository productReviewRepository) {
        this.productRepository = productRepository;
        this.productReviewRepository = productReviewRepository;
    }

    // Product CRUD operations

    /**
     * Save product product.
     *
     * @param product the product
     * @return the product
     */
// Create or Update a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
// Get a product by its ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Gets all products.
     *
     * @return the all products
     */
// Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Gets products by category.
     *
     * @param categoryId the category id
     * @return the products by category
     */
// Get products by category ID
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    /**
     * Delete product.
     *
     * @param id the id
     */
// Delete a product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Product Review CRUD operations

    /**
     * Add review product review.
     *
     * @param review the review
     * @return the product review
     */
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

    /**
     * Gets reviews by product id.
     *
     * @param productId the product id
     * @return the reviews by product id
     */
// Get reviews by product ID
    public List<ProductReview> getReviewsByProductId(String productId) {
        return productReviewRepository.findByProductId(productId);
    }

    /**
     * Delete review.
     *
     * @param reviewId the review id
     */
// Delete a product review
    public void deleteReview(String reviewId) {
        productReviewRepository.deleteById(reviewId);
    }

    /**
     * Update review product review.
     *
     * @param reviewId      the review id
     * @param updatedReview the updated review
     * @return the product review
     */
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
