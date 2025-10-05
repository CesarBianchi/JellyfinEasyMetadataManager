package com.lariflix.jemm.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadUsersTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadUsers loadUsers = new LoadUsers();
        loadUsers.setJellyfinInstanceUrl("http://localhost:8096");
        assertEquals("http://localhost:8096", loadUsers.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadUsers loadUsers = new LoadUsers();
        loadUsers.setApiToken("1234567890");
        assertEquals("1234567890", loadUsers.getApiToken());
    }

    @Test
    public void testGetFullURL() {
        LoadUsers loadUsers = new LoadUsers();
        loadUsers.setJellyfinInstanceUrl("http://localhost:8096/");
        loadUsers.setApiToken("1234567890");
        assertEquals("http://localhost:8096/Users?ApiKey=1234567890", loadUsers.getFullURL());
    }
}