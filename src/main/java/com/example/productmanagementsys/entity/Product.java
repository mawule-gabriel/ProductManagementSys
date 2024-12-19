package com.example.productmanagementsys.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * The type Product.
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;

    @JsonBackReference  // Prevent circular reference in JSON serialization
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;  // Category reference
}
