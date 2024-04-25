package com.example.apr1.services;

import com.example.apr1.dtos.FakeStoreProductDto;
import com.example.apr1.exceptions.ProductNotFoundException;
import com.example.apr1.models.Category;
import com.example.apr1.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {

//        throw new RuntimeException("something went wrong in service.");

//        int x = 1/0; //throwing arithmatic exception.

//        throw new RuntimeException(); //throw general exception

        RestTemplate restTemplate = new RestTemplate(); //resttemplate is class
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id , FakeStoreProductDto.class);

        //we have got the fakestoredto now. we have to convert it into product object.

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException(id , "please pass a valid product id");
//            return null;
        }

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        //in our dto category is string where as in product it is Category
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);

        return product;
    }

//    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();

        //**DOUBT** PAGE WAS NOT LOADING IF WE TAKE LIST<> INSTEAD OF ARRAY

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products" , FakeStoreProductDto[].class);

        //now we have fakestoreproductdtos which we need to convert to products

        List<Product> products = new ArrayList<>();
        for(int i=0 ; i<fakeStoreProductDtos.length ; i++){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDtos[i]));
        }

        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

}
