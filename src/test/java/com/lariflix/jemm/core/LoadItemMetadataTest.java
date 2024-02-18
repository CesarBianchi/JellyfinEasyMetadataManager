package com.lariflix.jemm.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadItemMetadataTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
        loadItemMetadata.setJellyfinInstanceUrl("http://localhost:8096");
        assertEquals("http://localhost:8096", loadItemMetadata.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
        loadItemMetadata.setApiToken("1234567890");
        assertEquals("1234567890", loadItemMetadata.getApiToken());
    }

    @Test
    public void testGetSetcUserAdminID() {
        LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
        loadItemMetadata.setcUserAdminID("admin");
        assertEquals("admin", loadItemMetadata.getcUserAdminID());
    }

    @Test
    public void testGetSetcItemID() {
        LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
        loadItemMetadata.setcItemID("item1");
        assertEquals("item1", loadItemMetadata.getcItemID());
    }

    @Test
    public void testGetFullURL() {
        LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
        loadItemMetadata.setJellyfinInstanceUrl("http://localhost:8096/");
        loadItemMetadata.setApiToken("1234567890");
        loadItemMetadata.setcUserAdminID("admin");
        loadItemMetadata.setcItemID("item1");
        assertEquals("http://localhost:8096/Users/admin/Items/item1?ApiKey=1234567890", loadItemMetadata.getFullURL());
    }
}