package com.ali.news.api.v1.mapper;

import com.ali.news.api.v1.dto.ArticleResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    ObjectMapper objectMapper;

    public ArticleMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ArticleResponseDto toArticleResponseDto(String jsonArticle) {

    }

}
