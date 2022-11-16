package com.mustache.bbsrepeat.domain.dto;

import com.mustache.bbsrepeat.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleAddRequest {
    private String title;
    private String content;

    public Article toEntity(){
        Article article = Article.builder()
                .title(this.title)
                .contents(this.content)
                .build();
        return article;
    }
}
