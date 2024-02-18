package com.lariflix.jemm.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectJellyfinAPITest {

    @Test
    public void testGetcBaseURL() {
        ConnectJellyfinAPI connectJellyfinAPI = new ConnectJellyfinAPI();
        connectJellyfinAPI.setcBaseURL("http://localhost:8096");
        assertEquals("http://localhost:8096", connectJellyfinAPI.getcBaseURL());
    }

    @Test
    public void testSetcBaseURL() {
        ConnectJellyfinAPI connectJellyfinAPI = new ConnectJellyfinAPI();
        connectJellyfinAPI.setcBaseURL("http://localhost:8096");
        assertEquals("http://localhost:8096", connectJellyfinAPI.getcBaseURL());
    }

    @Test
    public void testGetcTokenApi() {
        ConnectJellyfinAPI connectJellyfinAPI = new ConnectJellyfinAPI();
        connectJellyfinAPI.setcTokenApi("1234567890");
        assertEquals("1234567890", connectJellyfinAPI.getcTokenApi());
    }

    @Test
    public void testSetcTokenApi() {
        ConnectJellyfinAPI connectJellyfinAPI = new ConnectJellyfinAPI();
        connectJellyfinAPI.setcTokenApi("1234567890");
        assertEquals("1234567890", connectJellyfinAPI.getcTokenApi());
    }
}