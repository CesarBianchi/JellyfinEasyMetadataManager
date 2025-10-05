package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinStudioItemTest {

    @Test
    public void testJellyfinStudioItem() {
        JellyfinStudioItem studioItem = new JellyfinStudioItem();

        String name = "TestName";
        studioItem.setName(name);
        assertEquals(name, studioItem.getName());

        String id = "TestID";
        studioItem.setId(id);
        assertEquals(id, studioItem.getId());
    }
}