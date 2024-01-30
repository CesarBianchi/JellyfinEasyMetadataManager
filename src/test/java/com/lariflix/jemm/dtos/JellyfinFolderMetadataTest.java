package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinFolderMetadataTest {

    @Test
    public void JellyfinFolderMetadataTest() {
        JellyfinFolderMetadata metadata = new JellyfinFolderMetadata();

        String name = "TestMetadata";
        metadata.setName(name);
        assertEquals(name, metadata.getName());

        String overview = "Overview";
        metadata.setOverview(overview);
        assertEquals(overview, metadata.getOverview());




        String type = "Type";
        metadata.setType(type);
        assertEquals(type, metadata.getType());


    }
}