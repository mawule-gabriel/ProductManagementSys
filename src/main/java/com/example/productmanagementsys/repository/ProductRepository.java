package com.example.productmanagementsys.repository;

import com.example.productmanagementsys.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Find by category id list.
     *
     * @param categoryId the category id
     * @return the list
     */
// Find products by category (optional)
    List<Product> findByCategoryId(Long categoryId);
}
