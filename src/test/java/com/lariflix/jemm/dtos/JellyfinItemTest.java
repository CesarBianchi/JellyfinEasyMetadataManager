package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class JellyfinItemTest {

    @Test
    public void testJellyfinItem() {
        JellyfinItem item = new JellyfinItem();

        String name = "Test Name";
        item.setName(name);
        assertEquals(name, item.getName());

        String serverId = "Test ServerId";
        item.setServerId(serverId);
        assertEquals(serverId, item.getServerId());

        String id = "Test Id";
        item.setId(id);
        assertEquals(id, item.getId());

        String container = "Test Container";
        item.setContainer(container);
        assertEquals(container, item.getContainer());

        Date premiereDate = new Date();
        item.setPremiereDate(premiereDate);
        assertEquals(premiereDate, item.getPremiereDate());

        int criticRating = 5;
        item.setCriticRating(criticRating);
        assertEquals(criticRating, item.getCriticRating());

        String officialRating = "Test OfficialRating";
        item.setOfficialRating(officialRating);
        assertEquals(officialRating, item.getOfficialRating());

        int communityRating = 5;
        item.setCommunityRating(communityRating);
        assertEquals(communityRating, item.getCommunityRating());

        String aspectRatio = "Test AspectRatio";
        item.setAspectRatio(aspectRatio);
        assertEquals(aspectRatio, item.getAspectRatio());

        int productionYear = 2020;
        item.setProductionYear(productionYear);
        assertEquals(productionYear, item.getProductionYear());

        boolean isFolder = true;
        item.setIsFolder(isFolder);
        assertEquals(isFolder, item.isIsFolder());

        String type = "Test Type";
        item.setType(type);
        assertEquals(type, item.getType());

        String videoType = "Test VideoType";
        item.setVideoType(videoType);
        assertEquals(videoType, item.getVideoType());

        String locationType = "Test LocationType";
        item.setLocationType(locationType);
        assertEquals(locationType, item.getLocationType());

        String mediaType = "Test MediaType";
        item.setMediaType(mediaType);
        assertEquals(mediaType, item.getMediaType());

        JellyfinItemMetadata itemMetadata = new JellyfinItemMetadata();
        item.setItemMetadata(itemMetadata);
        assertEquals(itemMetadata, item.getItemMetadata());
    }
}