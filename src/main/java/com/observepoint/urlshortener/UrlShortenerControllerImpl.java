package com.observepoint.urlshortener;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UrlShortenerControllerImpl implements UrlShortenerController {

    @Override
    @PostMapping(path = "/")
    public ResponseEntity<UrlCreationResponse> createShortUrl(@RequestBody UrlCreationRequest longUrl) {

        // TODO: implement creating short url and saving long url
        String shortUrl = "";

        return ResponseEntity.ok(new UrlCreationResponse(shortUrl));
    }

    @Override
    @GetMapping(path = "/{shortUrlId}")
    public ResponseEntity<Void> getLongUrl(@PathVariable String shortUrlId) throws URISyntaxException {

        // TODO: implement retrieving long url by short one
        String longUrl = "";

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(longUrl));
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }
}
