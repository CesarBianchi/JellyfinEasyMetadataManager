package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import java.util.ArrayList;

public class JellyfinFolderTest {

    @Test
    public void testJellyfinFolder() {
        JellyfinFolder folder = new JellyfinFolder();

        String name = "TestFolder";
        folder.setName(name);
        assertEquals(name, folder.getName());

        String serverId = "Server1";
        folder.setServerId(serverId);
        assertEquals(serverId, folder.getServerId());

        String id = "ID1";
        folder.setId(id);
        assertEquals(id, folder.getId());

        Date premiereDate = new Date();
        folder.setPremiereDate(premiereDate);
        assertEquals(premiereDate, folder.getPremiereDate());

        int criticRating = 5;
        folder.setCriticRating(criticRating);
        assertEquals(criticRating, folder.getCriticRating());

        String officialRating = "Official";
        folder.setOfficialRating(officialRating);
        assertEquals(officialRating, folder.getOfficialRating());

        Object channelId = new Object();
        folder.setChannelId(channelId);
        assertEquals(channelId, folder.getChannelId());

        int communityRating = 4;
        folder.setCommunityRating(communityRating);
        assertEquals(communityRating, folder.getCommunityRating());

        int productionYear = 2020;
        folder.setProductionYear(productionYear);
        assertEquals(productionYear, folder.getProductionYear());

        boolean isFolder = true;
        folder.setIsFolder(isFolder);
        assertEquals(isFolder, folder.isIsFolder());

        String type = "Type1";
        folder.setType(type);
        assertEquals(type, folder.getType());

        String collectionType = "Collection1";
        folder.setCollectionType(collectionType);
        assertEquals(collectionType, folder.getCollectionType());

        String locationType = "Location1";
        folder.setLocationType(locationType);
        assertEquals(locationType, folder.getLocationType());

        JellyfinFolderMetadata metadata = new JellyfinFolderMetadata();
        folder.setMetadata(metadata);
        assertEquals(metadata, folder.getMetadata());

        JellyfinItems folderContent = new JellyfinItems();
        folder.setFolderContent(folderContent);
        assertEquals(folderContent, folder.getFolderContent());
    }
}