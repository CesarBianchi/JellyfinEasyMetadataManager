package com.lariflix.jemm.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadFolderMetadataTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadFolderMetadata loadFolderMetadata = new LoadFolderMetadata();
        loadFolderMetadata.setJellyfinInstanceUrl("http://localhost:8096");
        assertEquals("http://localhost:8096", loadFolderMetadata.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadFolderMetadata loadFolderMetadata = new LoadFolderMetadata();
        loadFolderMetadata.setApiToken("1234567890");
        assertEquals("1234567890", loadFolderMetadata.getApiToken());
    }

    @Test
    public void testGetSetcUserAdminID() {
        LoadFolderMetadata loadFolderMetadata = new LoadFolderMetadata();
        loadFolderMetadata.setcUserAdminID("admin");
        assertEquals("admin", loadFolderMetadata.getcUserAdminID());
    }

    @Test
    public void testGetSetcFolderID() {
        LoadFolderMetadata loadFolderMetadata = new LoadFolderMetadata();
        loadFolderMetadata.setcFolderID("folder1");
        assertEquals("folder1", loadFolderMetadata.getcFolderID());
    }
}