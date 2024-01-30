package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinItemMetadataTest {

    @Test
    public void testJellyfinItemMetadata() {
        JellyfinItemMetadata itemMetadata = new JellyfinItemMetadata();

        String name = "TestMetadata";
        itemMetadata.setName(name);
        assertEquals(name, itemMetadata.getName());

        String overview = "Overview";
        itemMetadata.setOverview(overview);
        assertEquals(overview, itemMetadata.getOverview());


        String type = "Type";
        itemMetadata.setType(type);
        assertEquals(type, itemMetadata.getType());


    }
}