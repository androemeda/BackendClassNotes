//models are the entities of our system which we store in our database
package com.example.apr1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //can also write at attribute level instead of class level
@Setter
@AllArgsConstructor //Product(Long id , String title , String description ,...) --> create this "all arguments constructor" using lombok
@NoArgsConstructor //default constructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Category category;
    private String image;
}
