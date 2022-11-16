package com.mustache.bbsrepeat.controller;

import com.mustache.bbsrepeat.domain.dto.ArticleDto;
import com.mustache.bbsrepeat.domain.entity.Article;
import com.mustache.bbsrepeat.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id){
        ArticleDto articleDto = articleService.getArticleById(id);
        return ResponseEntity.ok().body(articleDto);
    }
}
