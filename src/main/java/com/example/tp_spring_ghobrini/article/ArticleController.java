package com.example.tp_spring_ghobrini.article;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @PostMapping
    public Article creerArticle(@RequestBody Article article) {
        article.setDatePublication(LocalDate.now());
        return articleRepository.save(article);
    }


    @GetMapping
    public List<Article> lireArticles() {
        return articleRepository.findAll();
    }

    @PutMapping("/articles/{id}")
    public Article modifierArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        return articleRepository.findById(id)
                .map(article -> {
                    article.setContenu(updatedArticle.getContenu());
                    return articleRepository.save(article);
                })
                .orElseThrow(() -> new ArticleNotFoundException(id));
    }

    @DeleteMapping("/articles/{id}")
    public void supprimerArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }
}
