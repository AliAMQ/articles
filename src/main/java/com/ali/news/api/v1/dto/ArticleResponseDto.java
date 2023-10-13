package com.ali.news.api.v1.dto;

import java.util.Objects;

public class NewsResponseDto {
    private String title;
    private String description;
    private String content;
    private String url;
    private String image;
    private String publishedAt;
    private SourceResponseDto source;

    public NewsResponseDto(String title, String description, String content, String url, String image, String publishedAt, SourceResponseDto source) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.url = url;
        this.image = image;
        this.publishedAt = publishedAt;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public SourceResponseDto getSource() {
        return source;
    }

    public void setSource(SourceResponseDto source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsResponseDto that = (NewsResponseDto) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(content, that.content) && Objects.equals(url, that.url) && Objects.equals(image, that.image) && Objects.equals(publishedAt, that.publishedAt) && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, content, url, image, publishedAt, source);
    }

    @Override
    public String toString() {
        return "NewsResponseDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source=" + source +
                '}';
    }
}
