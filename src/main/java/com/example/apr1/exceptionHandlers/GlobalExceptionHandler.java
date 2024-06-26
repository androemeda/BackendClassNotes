package com.example.apr1.exceptionHandlers;

import com.example.apr1.dtos.ExceptionDto;
import com.example.apr1.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setResolution("arithmetic exception");
        dto.setMessage("something went wrong");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto , HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayOutOfBoundsException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setResolution("arrayOutOfBounds exception");
        dto.setMessage("something went wrong");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto , HttpStatus.BAD_REQUEST);
        return response;
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDto> handleGeneralException(){
//        ExceptionDto dto = new ExceptionDto();
//        dto.setResolution("general  exception");
//        dto.setMessage("something went wrong");
//        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto , HttpStatus.BAD_REQUEST);
//        return response;
//    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto dto = new ExceptionDto();
        dto.setResolution("invalid product id " + productNotFoundException.getId() +" passed ");
        dto.setMessage("ProductNotFoundException caught");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto , HttpStatus.BAD_REQUEST);
        return response;
    }

}
