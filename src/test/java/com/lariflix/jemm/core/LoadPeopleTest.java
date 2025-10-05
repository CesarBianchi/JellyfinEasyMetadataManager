package com.lariflix.jemm.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadPeopleTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadPeople loadPeople = new LoadPeople();
        loadPeople.setJellyfinInstanceUrl("http://localhost:8096");
        assertEquals("http://localhost:8096", loadPeople.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadPeople loadPeople = new LoadPeople();
        loadPeople.setApiToken("1234567890");
        assertEquals("1234567890", loadPeople.getApiToken());
    }

    @Test
    public void testGetSetcUserAdminID() {
        LoadPeople loadPeople = new LoadPeople();
        loadPeople.setcUserAdminID("admin");
        assertEquals("admin", loadPeople.getcUserAdminID());
    }

    @Test
    public void testGetSetcParentID() {
        LoadPeople loadPeople = new LoadPeople();
        loadPeople.setcParentID("parent1");
        assertEquals("parent1", loadPeople.getcParentID());
    }

    @Test
    public void testGetFullURL() {
        LoadPeople loadPeople = new LoadPeople();
        loadPeople.setJellyfinInstanceUrl("http://localhost:8096/");
        loadPeople.setApiToken("1234567890");
        assertEquals("http://localhost:8096/Persons?ApiKey=1234567890", loadPeople.getFullURL());
    }
}