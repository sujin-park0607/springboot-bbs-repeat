package com.mustache.bbsrepeat.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
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

    @Override
    public String toString(){
        return "Article{" + "id=" + id + ", title='" + title + '\'' + ", contents='" + contents + '\'' + '}';
    }
}
