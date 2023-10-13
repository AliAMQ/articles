package com.ali.news.api.v1.dto;

import java.util.Objects;

public class SourceResponseDto {

    private String name;
    private String url;

    public SourceResponseDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public SourceResponseDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceResponseDto that = (SourceResponseDto) o;
        return Objects.equals(name, that.name) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "SourceResponseDto{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
