package com.lariflix.jemm.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadGenresTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadGenres loadGenres = new LoadGenres();
        loadGenres.setJellyfinInstanceUrl("http://localhost:8096");
        assertEquals("http://localhost:8096", loadGenres.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadGenres loadGenres = new LoadGenres();
        loadGenres.setApiToken("1234567890");
        assertEquals("1234567890", loadGenres.getApiToken());
    }

    @Test
    public void testGetSetcUserAdminID() {
        LoadGenres loadGenres = new LoadGenres();
        loadGenres.setcUserAdminID("admin");
        assertEquals("admin", loadGenres.getcUserAdminID());
    }

    @Test
    public void testGetFullURL() {
        LoadGenres loadGenres = new LoadGenres();
        loadGenres.setJellyfinInstanceUrl("http://localhost:8096/");
        loadGenres.setApiToken("1234567890");
        loadGenres.setcUserAdminID("admin");
        assertEquals("http://localhost:8096/Genres?ApiKey=1234567890&userId=admin", loadGenres.getFullURL());
    }
}