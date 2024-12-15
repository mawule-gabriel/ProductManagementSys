package com.example.productmanagementsys.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product_reviews")
public class ProductReview {

    @Id
    private String id;

    private String productId;   // The product being reviewed
    private String username;     // The user who wrote the review
    private String content;      // Review content
    private int rating;          // Rating for the product (1-5)
    private LocalDateTime timestamp; // Timestamp of when the review was created
}
