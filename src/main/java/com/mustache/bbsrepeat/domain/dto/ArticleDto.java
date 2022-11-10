package com.mustache.bbsrepeat.domain.dto;

import com.mustache.bbsrepeat.domain.entity.Article;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ArticleDto {

    private Long id;
    private String title;
    private String contents;

    public ArticleDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public Article toEntity() {
        return  new Article(title, contents);
    }
}
