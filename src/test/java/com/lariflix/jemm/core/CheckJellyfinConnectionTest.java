package com.lariflix.jemm.core;

import com.lariflix.jemm.dtos.JellyfinConnectionResult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.HttpURLConnection;
import java.net.URL;

public class CheckJellyfinConnectionTest {

    @Test
    public void testTryConnection() throws Exception {
        // Create a mock HttpURLConnection
        HttpURLConnection mockConnection = mock(HttpURLConnection.class);
        when(mockConnection.getResponseCode()).thenReturn(200);
        when(mockConnection.getResponseMessage()).thenReturn("OK");

        // Create a mock URLStreamHandler that returns the mock HttpURLConnection
        java.net.URLStreamHandler stubUrlHandler = new java.net.URLStreamHandler() {
            @Override
            protected java.net.URLConnection openConnection(java.net.URL u) throws java.io.IOException {
                return mockConnection;
            }
        };

        // Use the URLStreamHandler to create a URL
        URL url = new URL("http", "localhost/", 80, "", stubUrlHandler);

        CheckJellyfinConnection checkConnection = new CheckJellyfinConnection();
        JellyfinConnectionResult result = checkConnection.tryConnection(url.toString(), "0123456789");

        assertFalse(result.isIsConnected());        
        assertEquals(0, result.getResponseCode());
        assertEquals("Instance not found or invalid apiKey.", result.getMessage());
    }
}