package com.example.apr1.services;

import com.example.apr1.exceptions.CategoryNotFoundException;
import com.example.apr1.exceptions.ProductNotFoundException;
import com.example.apr1.models.Category;
import com.example.apr1.models.Product;
import com.example.apr1.repositories.CategoryRepository;
import com.example.apr1.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository , CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id , "product not found");
        }

        Product product = optionalProduct.get();

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {

        Category category = product.getCategory();

        if(category.getId() == null){ //save the category
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if(optionalCategory.isEmpty()){
            //the category that is passes in the input product is invalid.
            throw new CategoryNotFoundException("invalid category passes.");
        }
        product1.setCategory(optionalCategory.get());

        return product1;
    }
}
