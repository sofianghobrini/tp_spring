package com.example.tp_spring_ghobrini.article;

public class ArticleNotFoundException extends RuntimeException {

    ArticleNotFoundException(Long id) {
        super("Aucun d'article que vous recherchez n'est pas trouvable" + id);
    }


}
