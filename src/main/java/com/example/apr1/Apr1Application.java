package com.example.apr1;

import com.example.apr1.models.Category;
import com.example.apr1.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Apr1Application {

    public static void main(String[] args) {
        SpringApplication.run(Apr1Application.class, args);
    }

}
