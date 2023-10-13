package com.ali.news.api.v1.controller;

import com.ali.news.api.v1.dto.ArticleResponseDto;
import com.ali.news.api.v1.interfaces.ArticleApi;
import com.ali.news.filter.ArticleFilter;
import com.ali.news.service.ArticleService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public List<ArticleResponseDto> getArticles(ArticleFilter body) throws Exception {
        return articleService.getArticles(body);
    }
}
