package com.example.tp_spring_ghobrini.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
