package com.example.tp_spring_ghobrini.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean like = false;
    private boolean dislike = false;
    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
    public boolean getLike() {
        return like;
    }

    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }
    public boolean getDislike() {
        return dislike;
    }


    public void setArticle(Article article) {
        this.article = article;
    }
    public Article getArticle() {
        return article;
    }


    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
}
