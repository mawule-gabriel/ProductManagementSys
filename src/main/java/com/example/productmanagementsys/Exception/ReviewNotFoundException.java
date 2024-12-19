package com.example.productmanagementsys.Exception;

/**
 * The type Review not found exception.
 */
public class ReviewNotFoundException extends RuntimeException{

    /**
     * Instantiates a new Review not found exception.
     *
     * @param reviewId the review id
     */
    public ReviewNotFoundException(String reviewId){
        super("Review not found with id: " + reviewId);
    }
}
