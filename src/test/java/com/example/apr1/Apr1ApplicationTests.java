package com.example.apr1;

import com.example.apr1.models.Category;
import com.example.apr1.models.Product;
import com.example.apr1.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Apr1ApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testEagerVsLazyFetch(){
        Optional<Category> optionalCategory = categoryRepository.findById(1L);

        Category category = optionalCategory.get();

        System.out.println("fetching list of products for the above catrgory.");
//        List<Product> products = category.getProducts();
//        System.out.println(products.get(0).getTitle());

        System.out.println("DEBUG");
    }

}
