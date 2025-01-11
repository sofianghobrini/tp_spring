package com.example.tp_spring_ghobrini.exception;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(Long id) {
        super("Aucun d'article que vous recherchez n'est pas trouvable" + id);
    }


}
