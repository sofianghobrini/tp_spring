package com.example.tp_spring_ghobrini;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping
    public Article creerArticle(@RequestBody Article article, @RequestBody String contenu) {
        article.setContenu(contenu);
        article.setAuthor(article.getAuthor());
        article.setDatePublication(LocalDate.now());
        return articleRepository.save(article);
    }

    @GetMapping
    public List<Article> lireArticles() {
        return articleRepository.findAll();
    }

    @PutMapping("/{id}")
    public Article modifierArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        return articleRepository.findById(id)
                .map(article -> {
                    article.setContenu(updatedArticle.getContenu());
                    return articleRepository.save(article);
                })
                .orElseThrow(() -> new RuntimeException("Article introuvable"));
    }

    @DeleteMapping("/{id}")
    public void supprimerArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }
}
