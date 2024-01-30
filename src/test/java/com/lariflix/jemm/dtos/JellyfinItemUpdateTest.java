package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class JellyfinItemUpdateTest {

    @Test
    public void testJellyfinItemUpdate() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();

        String id = "TestID";
        itemUpdate.setId(id);
        assertEquals(id, itemUpdate.getId());

    }
}