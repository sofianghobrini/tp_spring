package com.example.tp_spring_ghobrini.repository;

import com.example.tp_spring_ghobrini.modele.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
