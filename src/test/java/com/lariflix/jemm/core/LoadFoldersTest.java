package com.lariflix.jemm.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadFoldersTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadFolders loadFolders = new LoadFolders();
        loadFolders.setJellyfinInstanceUrl("http://localhost:8096/");
        assertEquals("http://localhost:8096/", loadFolders.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadFolders loadFolders = new LoadFolders();
        loadFolders.setApiToken("1234567890");
        assertEquals("1234567890", loadFolders.getApiToken());
    }

    @Test
    public void testGetSetcUserAdminID() {
        LoadFolders loadFolders = new LoadFolders();
        loadFolders.setcUserAdminID("admin");
        assertEquals("admin", loadFolders.getcUserAdminID());
    }

    @Test
    public void testGetSetFullURL() {
        LoadFolders loadFolders = new LoadFolders();
        
        loadFolders.setJellyfinInstanceUrl("http://localhost:8096/");
        loadFolders.setApiToken("1234567890");
        loadFolders.setcUserAdminID("admin");
         
        assertEquals("http://localhost:8096/Items?ApiKey=1234567890&userId=admin", loadFolders.getFullURL());
    }
}