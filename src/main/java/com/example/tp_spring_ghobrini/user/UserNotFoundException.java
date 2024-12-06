package com.example.tp_spring_ghobrini.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
