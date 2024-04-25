package com.example.apr1.services;

import com.example.apr1.models.Product;

import java.util.List;

public interface ProductService {

    //interface methods are by default public and static
    Product getProductById(Long id); //**returning Product obj because interfaces should be as generalised as possible

    List<Product> getAllProducts();


    //if the input product object has an id then it would be an "update" call. if input product object doesnt have an id, it would be a "create" call.
    Product createProduct(Product product);
}