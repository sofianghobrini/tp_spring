package com.example.tp_spring_ghobrini.service;

import com.example.tp_spring_ghobrini.modele.Article;
import com.example.tp_spring_ghobrini.modele.Like;
import com.example.tp_spring_ghobrini.modele.User;
import com.example.tp_spring_ghobrini.repository.LikeRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;


    public Like addLike(Article article, User user, boolean isLike) {
        Like like = likeRepository.findByArticleAndUser(article, user)
                .orElse(new Like());
        like.setArticle(article);
        like.setLike(isLike);
        return likeRepository.save(like);
    }

    public Like addDislike(Article article, User user, boolean isDisLike) {
        Like like = likeRepository.findByArticleAndUser(article, user)
                .orElse(new Like());
        like.setArticle(article);
        like.setDislike(isDisLike);
        return likeRepository.save(like);
    }

    public void removeLikeOrDislike(Article article, User user) {
        likeRepository.findByArticleAndUser(article, user)
                .ifPresent(likeRepository::delete);
    }


}
