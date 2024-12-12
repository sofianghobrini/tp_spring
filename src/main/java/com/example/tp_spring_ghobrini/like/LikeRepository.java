package com.example.tp_spring_ghobrini.like;

import com.example.tp_spring_ghobrini.article.Article;
import com.example.tp_spring_ghobrini.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByArticleAndUser(Article article, User user);
}
