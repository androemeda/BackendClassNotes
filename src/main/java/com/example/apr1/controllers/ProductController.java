package com.example.apr1.controllers;

import com.example.apr1.dtos.ExceptionDto;
import com.example.apr1.dtos.FakeStoreProductDto;
import com.example.apr1.models.Product;
import com.example.apr1.services.FakeStoreProductService;
import com.example.apr1.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //this controller is capable to host HTTP APIs
@RequestMapping("/products") //localhost:8080/products --> ProductController
public class ProductController {

    private ProductService productService;

    ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){ //use DTO(copy object) to hide things about object from user
        return productService.getProductById(id);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity getProductById(@PathVariable("id") Long id){
//
////        throw new RuntimeException("something went wrong");
//
//        ResponseEntity<Product> responseEntity = null;
//        Product product = null;
//        try{
//            product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product , HttpStatus.OK);
//            System.out.println("hello");
//            return responseEntity;
//        }catch(RuntimeException exception){
//            ExceptionDto dto = new ExceptionDto();
//            dto.setMessage("something went wrong");
//            dto.setResolution("you cant do anything.");
//            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto , HttpStatus.BAD_REQUEST);
//            return response;
//        }
//    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}