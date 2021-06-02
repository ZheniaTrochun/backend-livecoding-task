package com.observepoint.urlshortener;

import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

public interface UrlShortenerController {

    ResponseEntity<UrlCreationResponse> createShortUrl(UrlCreationRequest longUrl);

    ResponseEntity<Void> getLongUrl(String shortUrlId) throws URISyntaxException;
}
