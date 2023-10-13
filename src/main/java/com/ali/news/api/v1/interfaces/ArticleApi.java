package com.ali.news.api.v1.interfaces;

import com.ali.news.api.v1.dto.ArticleResponseDto;
import com.ali.news.filter.ArticleFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "articles", description = "Manage Articles")
@RequestMapping(value = "/api/v1/articles",
        produces = {"application/json"},
        consumes = {"application/json"})
public interface ArticleApi {

    @Operation(summary = "Find Articles",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid Input", content = @Content())
            },
            tags = {"articles"}
    )
    @GetMapping
    List<ArticleResponseDto> getArticles(@RequestBody ArticleFilter body) throws Exception;
}
