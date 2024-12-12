package com.example.tp_spring_ghobrini.article;

import com.example.tp_spring_ghobrini.like.*;
import com.example.tp_spring_ghobrini.user.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private LikeService likeService;

    public ArticleController(ArticleRepository articleRepository, UserRepository userRepository, LikeService likeService) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.likeService = likeService;
    }

    @PostMapping()
    public Article creerArticle(@RequestBody Article article) {
        User author = userRepository.findById(article.getAuthor().getId())
                .orElseThrow(() -> new UserNotFoundException(article.getAuthor().getId()));
        article.setTitle(article.getTitle());
        article.setAuthor(author);
        article.setDatePublication(LocalDate.now());
        return articleRepository.save(article);
    }


    @GetMapping
    public List<Article> lireArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/id")
    public Article getArticleById(@RequestParam (required = false) Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
    }


    @PutMapping("/{id}")
    public Article modifierArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        return articleRepository.findById(id)
                .map(article -> {
                    article.setContenu(updatedArticle.getContenu());
                    return articleRepository.save(article);
                })
                .orElseThrow(() -> new ArticleNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public void supprimerArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }

    @PostMapping("/{id}/user/{id_user}/dislike")
    public void dislikerUnArticle(@PathVariable Long id, @PathVariable Long id_user) {
        // Récupérer l'article par son ID
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new UserNotFoundException(id_user));
        likeService.addDislike(article, user, true);
    }

    @PostMapping("/{id}/user/{id_user}/like")
    public void likerUnArticle(@PathVariable Long id, @PathVariable Long id_user) {
        // Récupérer l'article par son ID
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new UserNotFoundException(id_user));
        likeService.addLike(article, user, true);
    }

    @DeleteMapping("/retirerLikeDislike/{id}")
    public void supprimerLike(@PathVariable Long id, @PathVariable Long id_user) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new UserNotFoundException(id_user));
        likeService.removeLikeOrDislike(article, user);
    }


}
