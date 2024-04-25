//models are the entities of our system which we store in our database
package com.example.apr1.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //can also write at attribute level instead of class level
@Setter
@AllArgsConstructor //Product(Long id , String title , String description ,...) --> create this "all arguments constructor" using lombok
@NoArgsConstructor //default constructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    @ManyToOne //(fetch = FetchType.LAZY) //lazy --> join operation wont be peroformed . eager --> join operation would be performed.
    @JoinColumn
    private Category category;
    private String image;
}
