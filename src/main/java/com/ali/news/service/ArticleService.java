package com.ali.news.service;

import com.ali.news.api.v1.dto.ArticleResponseDto;
import com.ali.news.api.v1.mapper.ArticleResponseMapper;
import com.ali.news.filter.ArticleFilter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    ArticleResponseMapper articleResponseMapper;
    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

    public ArticleService(ArticleResponseMapper articleResponseMapper) {
        this.articleResponseMapper = articleResponseMapper;
    }

    @Cacheable("articles")
    public List<ArticleResponseDto> getArticles(ArticleFilter articleFilter) throws Exception {

        StringBuilder stringBuilder = new StringBuilder("https://gnews.io/api/v4/search?");
        if (articleFilter != null) {
            if (articleFilter.getApikey() == null) {
                throw new Exception("Apikey has to be provided");
            } else {
                stringBuilder.append("apikey=").append(articleFilter.getApikey());
            }
            if (articleFilter.getKeyword() == null) {
                throw new Exception("Keyword has to be provided");
            } else {
                stringBuilder.append("&q=").append(articleFilter.getKeyword());
            }
            if (articleFilter.getMax() != null && articleFilter.getMax() > 0) {
                stringBuilder.append("&max=").append(articleFilter.getMax());
            }
        }

        WebClient webClient = WebClient.create();

        List<ArticleResponseDto> articleResponseDtoList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonResponse = webClient.get()
                .uri(stringBuilder.toString())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JsonNode articlesJsonNode = objectMapper.readTree(jsonResponse).get("articles");

        for (JsonNode article : articlesJsonNode) {
            articleResponseDtoList.add(articleResponseMapper.toArticleResponseDto(article));
        }
        logger.info("{} articles retrieved.", articleResponseDtoList.size());
        return articleResponseDtoList;
    }
}
