package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class JellyfinUserConfigurationTest {

    @Test
    public void testPlayDefaultAudioTrack() {
        JellyfinUserConfiguration config = new JellyfinUserConfiguration();
        config.setPlayDefaultAudioTrack(true);
        assertTrue(config.isPlayDefaultAudioTrack());
    }

    @Test
    public void testSubtitleLanguagePreference() {
        JellyfinUserConfiguration config = new JellyfinUserConfiguration();
        config.setSubtitleLanguagePreference("English");
        assertEquals("English", config.getSubtitleLanguagePreference());
    }

    @Test
    public void testDisplayMissingEpisodes() {
        JellyfinUserConfiguration config = new JellyfinUserConfiguration();
        config.setDisplayMissingEpisodes(true);
        assertTrue(config.isDisplayMissingEpisodes());
    }

    @Test
    public void testSubtitleMode() {
        JellyfinUserConfiguration config = new JellyfinUserConfiguration();
        config.setSubtitleMode("Mode1");
        assertEquals("Mode1", config.getSubtitleMode());
    }

    @Test
    public void testDisplayCollectionsView() {
        JellyfinUserConfiguration config = new JellyfinUserConfiguration();
        config.setDisplayCollectionsView(true);
        assertTrue(config.isDisplayCollectionsView());
    }

    @Test
    public void testEnableLocalPassword() {
        JellyfinUserConfiguration config = new JellyfinUserConfiguration();
        config.setEnableLocalPassword(true);
        assertTrue(config.isEnableLocalPassword());
    }

    @Test
    public void testGroupedFolders() {
        JellyfinUserConfiguration config = new JellyfinUserConfiguration();
        ArrayList<Object> folders = new ArrayList<>();
        folders.add("Folder1");
        config.setGroupedFolders(folders);
        assertEquals(folders, config.getGroupedFolders());
    }

    // Add more test cases for other methods in a similar way
}