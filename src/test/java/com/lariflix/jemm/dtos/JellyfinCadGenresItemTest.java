package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class JellyfinCadGenresItemTest {

    @Test
    public void testGetName() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setName("Action");
        assertEquals("Action", item.getName());
    }

    @Test
    public void testSetName() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setName("Action");
        assertEquals("Action", item.name);
    }

    @Test
    public void testGetServerId() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setServerId("server123");
        assertEquals("server123", item.getServerId());
    }

    @Test
    public void testSetServerId() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setServerId("server123");
        assertEquals("server123", item.serverId);
    }

    @Test
    public void testGetId() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setId("id123");
        assertEquals("id123", item.getId());
    }

    @Test
    public void testSetId() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setId("id123");
        assertEquals("id123", item.id);
    }

    @Test
    public void testGetChannelId() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        Object channelId = new Object();
        item.setChannelId(channelId);
        assertEquals(channelId, item.getChannelId());
    }

    @Test
    public void testSetChannelId() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        Object channelId = new Object();
        item.setChannelId(channelId);
        assertEquals(channelId, item.channelId);
    }

    @Test
    public void testGetType() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setType("Movie");
        assertEquals("Movie", item.getType());
    }

    @Test
    public void testSetType() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setType("Movie");
        assertEquals("Movie", item.type);
    }

    @Test
    public void testGetLocationType() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setLocationType("Online");
        assertEquals("Online", item.getLocationType());
    }

    @Test
    public void testSetLocationType() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setLocationType("Online");
        assertEquals("Online", item.locationType);
    }

    @Test
    public void testGetPremiereDate() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        Date date = new Date();
        item.setPremiereDate(date);
        assertEquals(date, item.getPremiereDate());
    }

    @Test
    public void testSetPremiereDate() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        Date date = new Date();
        item.setPremiereDate(date);
        assertEquals(date, item.premiereDate);
    }

    @Test
    public void testGetCriticRating() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setCriticRating(85);
        assertEquals(85, item.getCriticRating());
    }

    @Test
    public void testSetCriticRating() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setCriticRating(85);
        assertEquals(85, item.criticRating);
    }

    @Test
    public void testGetOfficialRating() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setOfficialRating("PG-13");
        assertEquals("PG-13", item.getOfficialRating());
    }

    @Test
    public void testSetOfficialRating() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setOfficialRating("PG-13");
        assertEquals("PG-13", item.officialRating);
    }

    @Test
    public void testGetCommunityRating() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setCommunityRating(90);
        assertEquals(90, item.getCommunityRating());
    }

    @Test
    public void testSetCommunityRating() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();
        item.setCommunityRating(90);
        assertEquals(90, item.communityRating);
    }
}