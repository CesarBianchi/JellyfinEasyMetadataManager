package com.lariflix.jemm.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadStudiosTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadStudios loadStudios = new LoadStudios();
        loadStudios.setJellyfinInstanceUrl("http://localhost:8096");
        assertEquals("http://localhost:8096", loadStudios.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadStudios loadStudios = new LoadStudios();
        loadStudios.setApiToken("1234567890");
        assertEquals("1234567890", loadStudios.getApiToken());
    }

    @Test
    public void testGetSetcUserAdminID() {
        LoadStudios loadStudios = new LoadStudios();
        loadStudios.setcUserAdminID("admin");
        assertEquals("admin", loadStudios.getcUserAdminID());
    }

    @Test
    public void testGetFullURL() {
        LoadStudios loadStudios = new LoadStudios();
        loadStudios.setJellyfinInstanceUrl("http://localhost:8096/");
        loadStudios.setApiToken("1234567890");
        assertEquals("http://localhost:8096/Studios?ApiKey=1234567890", loadStudios.getFullURL());
    }
}