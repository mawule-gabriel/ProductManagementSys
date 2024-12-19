package com.example.productmanagementsys.Exception;

/**
 * The type Product not found exception.
 */
public class ProductNotFoundException extends RuntimeException{
    /**
     * Instantiates a new Product not found exception.
     *
     * @param productId the product id
     */
    public ProductNotFoundException(String productId){
        super("Product not found with id: " + productId);
    }

}
