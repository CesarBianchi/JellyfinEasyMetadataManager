package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinProviderIdsTest {

    @Test
    public void testJellyfinProviderIds() {
        JellyfinProviderIds providerIds = new JellyfinProviderIds();

        String imdb = "TestImdb";
        providerIds.setImdb(imdb);
        assertEquals(imdb, providerIds.getImdb());

        String tmdb = "TestTmdb";
        providerIds.setTmdb(tmdb);
        assertEquals(tmdb, providerIds.getTmdb());

        String tmdbCollection = "TestTmdbCollection";
        providerIds.setTmdbCollection(tmdbCollection);
        assertEquals(tmdbCollection, providerIds.getTmdbCollection());
    }
}