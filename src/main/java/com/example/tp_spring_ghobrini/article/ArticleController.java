package com.example.tp_spring_ghobrini.article;

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

    public ArticleController(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @PostMapping()
    public Article creerArticle(@RequestBody Article article) {
        User author = userRepository.findById(article.getAuthor().getId())
                .orElseThrow(() -> new UserNotFoundException(article.getAuthor().getId()));
        article.setAuthor(author);
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
