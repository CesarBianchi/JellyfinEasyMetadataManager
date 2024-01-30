package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinGenreItemTest {

    @Test
    public void testJellyfinGenreItem() {
        JellyfinGenreItem genreItem = new JellyfinGenreItem();

        String name = "GenreName";
        genreItem.setName(name);
        assertEquals(name, genreItem.getName());

        String id = "ID1";
        genreItem.setId(id);
        assertEquals(id, genreItem.getId());
    }
}