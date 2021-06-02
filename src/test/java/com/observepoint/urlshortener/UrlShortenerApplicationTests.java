package com.observepoint.urlshortener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = UrlShortenerApplication.class)
@AutoConfigureMockMvc
class UrlShortenerApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlShortenerApplicationTests.class);

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

	@Test
	void contextLoads() {
	}

    // TODO: add other tests if needed
	@Test
    void endToEndTest() throws Exception {
	    String longUrl = "https://rozetka.com.ua/fabula_9786170952851/p174120381/";

        LOGGER.info("Original long url: " + longUrl);

	    UrlCreationRequest request = new UrlCreationRequest(longUrl);

	    String responseBodyStr = mvc.perform(
	            post("/")
                        .content(mapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        UrlCreationResponse responseBody = mapper.readValue(responseBodyStr, UrlCreationResponse.class);

        String shortUrl = responseBody.getUrl();

        LOGGER.info("Short url: " + shortUrl);

        String[] splittedUrl = shortUrl.split("\\/");

        String shortUrlId = splittedUrl[splittedUrl.length - 1];
        LOGGER.info("Short url identifier: " + shortUrlId);

        String redirectUrl = mvc.perform(get("/" + shortUrlId)).andExpect(status().isSeeOther()).andReturn().getResponse().getRedirectedUrl();

        LOGGER.info("Redirect url: " + redirectUrl);

        Assertions.assertEquals(redirectUrl, longUrl);
    }
}
