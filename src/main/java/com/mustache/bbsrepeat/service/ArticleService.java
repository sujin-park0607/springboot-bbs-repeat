package com.mustache.bbsrepeat.service;

import com.mustache.bbsrepeat.domain.dto.ArticleDto;
import com.mustache.bbsrepeat.domain.entity.Article;
import com.mustache.bbsrepeat.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public ArticleDto getArticleById(Long id){
        Optional<Article> optionalArticle = articleRepository.findById(id);
        ArticleDto articleDto = Article.of(optionalArticle.get());
        return  articleDto;

    }
}
