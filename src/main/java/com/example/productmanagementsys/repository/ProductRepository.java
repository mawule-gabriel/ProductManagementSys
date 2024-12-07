package com.example.productmanagementsys.repository;

import com.example.productmanagementsys.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find products by category (optional)
    List<Product> findByCategoryId(Long categoryId);
}
