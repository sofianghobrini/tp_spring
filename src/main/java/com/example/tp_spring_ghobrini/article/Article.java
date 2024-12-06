package com.example.tp_spring_ghobrini.article;

import java.time.LocalDate;

import com.example.tp_spring_ghobrini.user.User;
import com.example.tp_spring_ghobrini.like.Like;
import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String auteur; //(relier auteur à User)
    private String title;
    private String contenu;
    private LocalDate datePublication;
    @ManyToOne(fetch = FetchType.EAGER) // Relation avec l'utilisateur (auteur)
    // Les clés étrangères
    @JoinColumn(name = "author_id", nullable = false)
    @JoinColumn(name = "like_id", nullable = false)
    private User author;

    //GETTER et SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
