package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class JellyfinCadPeopleItemsTest {

    @Test
    public void testJellyfinCadPeopleItems() {
        JellyfinCadPeopleItems items = new JellyfinCadPeopleItems();

        ArrayList<JellyfinCadPeopleItem> itemList = new ArrayList<>();
        items.setItems(itemList);
        assertEquals(itemList, items.getItems());

        int totalRecordCount = 10;
        items.setTotalRecordCount(totalRecordCount);
        assertEquals(totalRecordCount, items.getTotalRecordCount());

        int startIndex = 5;
        items.setStartIndex(startIndex);
        assertEquals(startIndex, items.getStartIndex());
    }
}