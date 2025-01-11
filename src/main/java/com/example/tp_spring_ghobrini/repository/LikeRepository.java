package com.example.tp_spring_ghobrini.repository;

import com.example.tp_spring_ghobrini.modele.Article;
import com.example.tp_spring_ghobrini.modele.Like;
import com.example.tp_spring_ghobrini.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByArticleAndUser(Article article, User user);
}
