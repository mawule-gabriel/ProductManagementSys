package com.example.productmanagementsys.controller;

import com.example.productmanagementsys.entity.Product;
import com.example.productmanagementsys.entity.ProductReview;
import com.example.productmanagementsys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get products by category ID
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    // Create or update a product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> existingProduct = productService.getProductById(id);
        if (existingProduct.isPresent()) {
            product.setId(id);
            Product updatedProduct = productService.saveProduct(product);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Product Review CRUD operations

    @PostMapping("/{productId}/reviews")
    public ResponseEntity<ProductReview> addReview(@PathVariable String productId, @RequestBody ProductReview review) {
        // Associate the review with the correct productId
        review.setProductId(productId);
        review.setTimestamp(LocalDateTime.now());  // Set the timestamp for when the review is created

        // Save the review in the database (MongoDB in this case)
        ProductReview savedReview = productService.addReview(review);

        // Return the saved review
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }


    // Get reviews by product ID
    @GetMapping("/{productId}/reviews")
    public List<ProductReview> getReviewsByProductId(@PathVariable String productId) {
        return productService.getReviewsByProductId(productId);
    }

    // Delete a product review
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable String reviewId) {
        productService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    // Update a review
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<ProductReview> updateReview(@PathVariable String reviewId, @RequestBody ProductReview updatedReview) {
        ProductReview updated = productService.updateReview(reviewId, updatedReview);
        return ResponseEntity.ok(updated);
    }
}