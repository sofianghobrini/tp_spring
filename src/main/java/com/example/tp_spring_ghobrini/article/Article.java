package com.example.tp_spring_ghobrini.article;

import java.time.LocalDate;

import com.example.tp_spring_ghobrini.user.User;
import jakarta.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String auteur; //(relier auteur à User)
    private String contenu;
    private LocalDate datePublication;

    //GETTER et SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY) // Relation avec l'utilisateur (auteur)
    @JoinColumn(name = "author_id", nullable = false) // La clé étrangère sera "author_id"
    private User author;

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
