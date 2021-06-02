package com.observepoint.urlshortener;

import java.util.Objects;

public class UrlCreationResponse {
    private String url;

    public UrlCreationResponse() {
    }

    public UrlCreationResponse(String url) {
        this.url = url;
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
        UrlCreationResponse that = (UrlCreationResponse) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return "UrlCreationResponse{" +
                "url='" + url + '\'' +
                '}';
    }
}
