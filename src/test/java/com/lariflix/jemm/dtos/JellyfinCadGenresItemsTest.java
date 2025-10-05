package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class JellyfinCadGenresItemsTest {

    @Test
    public void testJellyfinCadGenresItems() {
        JellyfinCadGenresItems items = new JellyfinCadGenresItems();

        ArrayList<JellyfinCadGenresItem> itemList = new ArrayList<>();
        items.setItems(itemList);
        assertEquals(itemList, items.getItems());

        int totalRecordCount = 10;
        items.setTotalRecordCount(totalRecordCount);
        assertEquals(totalRecordCount, items.getTotalRecordCount());

        int startIndex = 5;
        items.setStartIndex(startIndex);
        assertEquals(startIndex, items.getStartIndex());
    }

    @Test
    public void testJellyfinCadGenresItemsParameterizedConstructor() {
        ArrayList<JellyfinCadGenresItem> itemList = new ArrayList<>();
        int totalRecordCount = 10;
        int startIndex = 5;

        JellyfinCadGenresItems items = new JellyfinCadGenresItems(itemList, totalRecordCount, startIndex);

        assertEquals(itemList, items.getItems());
        assertEquals(totalRecordCount, items.getTotalRecordCount());
        assertEquals(startIndex, items.getStartIndex());
    }

    @Test
    public void testJellyfinCadGenresItemsDefaultConstructor() {
        JellyfinCadGenresItems items = new JellyfinCadGenresItems();
        assertNotNull(items);
        assertEquals(0, items.getTotalRecordCount());
        assertEquals(0, items.getStartIndex());
        assertEquals(null, items.getItems());
    }
}
