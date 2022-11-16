package com.mustache.bbsrepeat.domain.entity;

import com.mustache.bbsrepeat.domain.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue
    private Long id;


    @Column
    private String title;

    @Column
    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public static ArticleDto of(Article article){
        return new ArticleDto(article.getId(), article.getTitle(), article.getContents());
    }

    @Override
    public String toString(){
        return "Article{" + "id=" + id + ", title='" + title + '\'' + ", contents='" + contents + '\'' + '}';
    }
}
