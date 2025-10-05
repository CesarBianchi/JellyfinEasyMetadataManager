package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinConnectionResultTest {

    @Test
    public void testJellyfinConnectionResult() {
        JellyfinConnectionResult result = new JellyfinConnectionResult();

        String message = "Connection successful";
        result.setMessage(message);
        assertEquals(message, result.getMessage());

        int responseCode = 200;
        result.setResponseCode(responseCode);
        assertEquals(responseCode, result.getResponseCode());

        boolean isConnected = true;
        result.setIsConnected(isConnected);
        assertEquals(isConnected, result.isIsConnected());
    }
}