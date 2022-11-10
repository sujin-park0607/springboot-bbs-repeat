package com.mustache.bbsrepeat.controller;

import com.mustache.bbsrepeat.domain.entity.Article;
import com.mustache.bbsrepeat.domain.dto.ArticleDto;
import com.mustache.bbsrepeat.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value="/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles",articles);
        return "articles/list";
    }

    @GetMapping("")
    public String index(){
        return "redirect:/articles/list";
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model){
        Optional<Article> optArticle = articleRepository.findById(id);

        if(!optArticle.isEmpty()){
            model.addAttribute("article",optArticle.get());
            return "articles/show";
        }else{
            return "articles/error";
        }
    }



    @PostMapping(value="/posts")
    public String createArticle(ArticleDto form){
        log.info(form.toString());

        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        Article saved = articleRepository.save(articleEntity);
        log.info(saved.toString());
        return "redirect:/articles/"+saved.getId();
    }
}
