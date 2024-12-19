package com.example.productmanagementsys.repository;

import com.example.productmanagementsys.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Product review repository.
 */
@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, String> {
    /**
     * Find by product id list.
     *
     * @param productId the product id
     * @return the list
     */
    List<ProductReview> findByProductId(String productId);
}
