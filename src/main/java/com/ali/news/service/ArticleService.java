package com.ali.news.service;

import com.ali.news.api.v1.dto.ArticleResponseDto;
import com.ali.news.api.v1.mapper.ArticleResponseMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    ArticleResponseMapper articleResponseMapper;
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    WebClient webClient;

    public NewsService(ArticleResponseMapper articleResponseMapper) {
        this.articleResponseMapper = articleResponseMapper;
    }

    public List<ArticleResponseDto> getNews() throws IOException {

        webClient = WebClient.create();

        List<ArticleResponseDto> articleResponseDtoList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

            String jsonResponse = webClient.get()
                    .uri("https://gnews.io/api/v4/search?q=example&apikey=fbf24b5c0ef48b8841d6555d0fe08be4")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            JsonNode articlesJsonNode = objectMapper.readTree(jsonResponse).get("articles");

            for (JsonNode article : articlesJsonNode) {
                articleResponseDtoList.add(articleResponseMapper.toArticleResponseDto(article));
            }
            return articleResponseDtoList;
        }
    }
