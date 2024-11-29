package com.example.tp_spring_ghobrini;

import java.time.LocalDate;

import jakarta.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String auteur;
    private String contenu;
    private LocalDate datePublication;

    //GETTER et SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuteur(String auteur) {
        this.auteur=auteur;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }
}
