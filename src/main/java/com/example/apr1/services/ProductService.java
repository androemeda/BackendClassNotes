package com.example.apr1.services;

import com.example.apr1.models.Product;

import java.util.List;

public interface ProductService {

    //interface methods are by default public and static
    Product getProductById(Long id); //**returning Product obj because interfaces should be as generalised as possible

    List<Product> getAllProducts();
}