package com.example.apr1.exceptions;

//if we extend Exception , it becomes checked exception. but lets say if we extend runtimeexception it will be an unchecked exception. (watch bits classes)

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends RuntimeException{

    private Long id;
    public ProductNotFoundException(Long id , String message){
        super(message);
        this.id = id;
    }
}
/**
 * checked and unchecked exception is not clear.
 */