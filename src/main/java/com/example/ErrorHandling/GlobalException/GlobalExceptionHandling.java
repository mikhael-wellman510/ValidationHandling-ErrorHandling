package com.example.ErrorHandling.GlobalException;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandling {

    // Todo -> Validator Exceotion
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex){
        Map<String , String> errMsg = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) ->{
            // Todo -> Nama attribute nya : Jenis Error nya
            errMsg.put(((FieldError) error).getField() , error.getDefaultMessage());
        });
        return new ResponseEntity<>(errMsg, HttpStatus.BAD_REQUEST);
    }
}
