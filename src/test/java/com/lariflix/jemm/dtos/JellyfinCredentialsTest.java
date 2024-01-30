package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinCredentialsTest {

    @Test
    public void testJellyfinCredentials() {
        JellyfinCredentials credentials = new JellyfinCredentials();

        String baseURL = "http://localhost:8096";
        credentials.setBaseURL(baseURL);
        assertEquals(baseURL, credentials.getBaseURL());

        String tokenAPI = "token";
        credentials.setTokenAPI(tokenAPI);
        assertEquals(tokenAPI, credentials.getTokenAPI());
    }

    @Test
    public void testJellyfinCredentialsWithParameters() {
        String baseURL = "http://localhost:8096";
        String tokenAPI = "token";

        JellyfinCredentials credentials = new JellyfinCredentials(baseURL, tokenAPI);
        assertEquals(baseURL, credentials.getBaseURL());
        assertEquals(tokenAPI, credentials.getTokenAPI());
    }
}