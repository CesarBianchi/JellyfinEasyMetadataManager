package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinCadStudioItemTest {

    @Test
    public void testJellyfinCadStudioItem() {
        JellyfinCadStudioItem item = new JellyfinCadStudioItem();

        String name = "Studio Name";
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
    }
}