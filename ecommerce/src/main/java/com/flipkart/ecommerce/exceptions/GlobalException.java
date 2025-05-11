package com.flipkart.ecommerce.exceptions;


import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalException {

@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleGlobalException(Exception ex) {
    return new ResponseEntity<>("Exception occurs: " + ex.getMessage(), HttpStatus.valueOf(397));
}
}

