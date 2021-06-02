package com.observepoint.urlshortener;

import java.util.Objects;

public class UrlCreationRequest {
    private String longUrl;

    public UrlCreationRequest() {
    }

    public UrlCreationRequest(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlCreationRequest that = (UrlCreationRequest) o;
        return Objects.equals(longUrl, that.longUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longUrl);
    }

    @Override
    public String toString() {
        return "UrlCreationRequest{" +
                "longUrl='" + longUrl + '\'' +
                '}';
    }
}
