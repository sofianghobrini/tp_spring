package com.example.tp_spring_ghobrini.like;

import com.example.tp_spring_ghobrini.article.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;


    public Like addLike(Article article, boolean isLike) {
        Like like = likeRepository.findByArticle(article)
                .orElse(new Like());
        like.setArticle(article);
        like.setLike(isLike);
        return likeRepository.save(like);
    }

    public Like addDislike(Article article, boolean isDisLike) {
        Like like = likeRepository.findByArticle(article)
                .orElse(new Like());
        like.setArticle(article);
        like.setDislike(isDisLike);
        return likeRepository.save(like);
    }

    public void removeLikeOrDislike(Article article) {
        likeRepository.findByArticle(article)
                .ifPresent(likeRepository::delete);
    }


}
