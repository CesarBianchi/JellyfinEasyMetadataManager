package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class JellyfinCadGenresItemTest {

    @Test
    public void testJellyfinCadGenresItem() {
        JellyfinCadGenresItem item = new JellyfinCadGenresItem();

        String name = "Genre Name";
        item.setName(name);
        assertEquals(name, item.getName());

        String serverId = "Server ID";
        item.setServerId(serverId);
        assertEquals(serverId, item.getServerId());

        String id = "ID";
        item.setId(id);
        assertEquals(id, item.getId());

        Object channelId = new Object();
        item.setChannelId(channelId);
        assertEquals(channelId, item.getChannelId());

        String type = "Type";
        item.setType(type);
        assertEquals(type, item.getType());

        String locationType = "Location Type";
        item.setLocationType(locationType);
        assertEquals(locationType, item.getLocationType());

        Date premiereDate = new Date();
        item.setPremiereDate(premiereDate);
        assertEquals(premiereDate, item.getPremiereDate());

        int criticRating = 5;
        item.setCriticRating(criticRating);
        assertEquals(criticRating, item.getCriticRating());

        String officialRating = "Official Rating";
        item.setOfficialRating(officialRating);
        assertEquals(officialRating, item.getOfficialRating());

        int communityRating = 4;
        item.setCommunityRating(communityRating);
        assertEquals(communityRating, item.getCommunityRating());
    }
}