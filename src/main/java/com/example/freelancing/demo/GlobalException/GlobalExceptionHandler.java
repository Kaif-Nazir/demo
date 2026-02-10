package com.example.freelancing.demo.GlobalException;

import com.example.freelancing.demo.GlobalException.Exception.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ItemNotFoundException.class)
    public ResponseEntity<?> handleResponseStatusException(ItemNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
