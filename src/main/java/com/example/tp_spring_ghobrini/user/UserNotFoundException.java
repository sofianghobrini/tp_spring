package com.example.tp_spring_ghobrini.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("L'utilisateur " + id + " n'existe pas ou introuvable");
    }
}
