package com.example.tp_spring_ghobrini;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
