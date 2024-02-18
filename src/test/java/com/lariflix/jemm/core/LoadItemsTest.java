package com.lariflix.jemm.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadItemsTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadItems loadItems = new LoadItems();
        loadItems.setJellyfinInstanceUrl("http://localhost:8096");
        assertEquals("http://localhost:8096", loadItems.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadItems loadItems = new LoadItems();
        loadItems.setApiToken("1234567890");
        assertEquals("1234567890", loadItems.getApiToken());
    }

    @Test
    public void testGetSetcUserAdminID() {
        LoadItems loadItems = new LoadItems();
        loadItems.setcUserAdminID("admin");
        assertEquals("admin", loadItems.getcUserAdminID());
    }

    @Test
    public void testGetSetcParentID() {
        LoadItems loadItems = new LoadItems();
        loadItems.setcParentID("parent1");
        assertEquals("parent1", loadItems.getcParentID());
    }

    @Test
    public void testGetFullURL() {
        LoadItems loadItems = new LoadItems();
        loadItems.setJellyfinInstanceUrl("http://localhost:8096/");
        loadItems.setApiToken("1234567890");
        loadItems.setcUserAdminID("admin");
        loadItems.setcParentID("parent1");
        assertEquals("http://localhost:8096/Users/admin/Items?parentId=parent1&userId=admin&ApiKey=1234567890", loadItems.getFullURL());
    }
}