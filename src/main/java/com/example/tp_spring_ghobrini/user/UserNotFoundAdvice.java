package com.example.tp_spring_ghobrini.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class UserNotFoundAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }
}

