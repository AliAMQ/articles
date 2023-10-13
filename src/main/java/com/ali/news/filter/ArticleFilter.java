package com.ali.news.filter;

import java.util.Objects;

public class ArticleFilter {
    private Integer max;

    private String apikey;

    private String keyword;

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleFilter that = (ArticleFilter) o;
        return Objects.equals(max, that.max) && Objects.equals(apikey, that.apikey) && Objects.equals(keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, apikey, keyword);
    }

    @Override
    public String toString() {
        return "ArticleFilter{" +
                "max=" + max +
                ", apikey='" + apikey + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
