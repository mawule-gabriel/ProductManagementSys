package com.example.productmanagementsys.repository;

import com.example.productmanagementsys.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // You can add custom queries here, for example:
    Category findByName(String name);
}
