package com.example.productmanagementsys.Exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String productId){
        super("Product not found with id: " + productId);
    }

}
