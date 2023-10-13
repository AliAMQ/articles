package com.ali.news.api.v1.mapper;

import com.ali.news.api.v1.dto.ArticleResponseDto;
import com.ali.news.api.v1.dto.SourceResponseDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleResponseMapper {

    ObjectMapper objectMapper;

    public ArticleResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ArticleResponseDto toArticleResponseDto(JsonNode jsonArticle) {
        ArticleResponseDto articleResponseDto = new ArticleResponseDto();

        articleResponseDto.setContent(String.valueOf(jsonArticle.get("content")));
        articleResponseDto.setDescription(String.valueOf(jsonArticle.get("description")));
        articleResponseDto.setImage(String.valueOf(jsonArticle.get("image")));
        articleResponseDto.setTitle(String.valueOf(jsonArticle.get("title")));
        articleResponseDto.setPublishedAt(String.valueOf(jsonArticle.get("publishedAt")));
        articleResponseDto.setUrl(String.valueOf(jsonArticle.get("url")));
        articleResponseDto.setSource(toSourceResponseDto(jsonArticle.get("source")));

        return articleResponseDto;
    }

    private SourceResponseDto toSourceResponseDto(JsonNode jsonSource) {
        SourceResponseDto sourceResponseDto = new SourceResponseDto();
        sourceResponseDto.setName(String.valueOf(jsonSource.get("name")));
        sourceResponseDto.setUrl(String.valueOf(jsonSource.get("url")));
        return sourceResponseDto;
    }

}
