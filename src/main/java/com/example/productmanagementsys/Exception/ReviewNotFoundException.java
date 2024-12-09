package com.example.productmanagementsys.Exception;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(String reviewId){
        super("Review not found with id: " + reviewId);
    }
}
