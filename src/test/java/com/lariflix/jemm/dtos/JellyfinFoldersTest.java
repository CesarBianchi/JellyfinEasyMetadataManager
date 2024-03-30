package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class JellyfinFoldersTest {

    @Test
    public void testJellyfinFolders() {
        JellyfinFolders folders = new JellyfinFolders();

        ArrayList<JellyfinFolder> folderList = new ArrayList<>();
        folders.setItems(folderList);
        assertEquals(folderList, folders.getItems());

        int totalRecordCount = 0;
        folders.setTotalRecordCount(totalRecordCount);
        assertEquals(totalRecordCount, folders.getTotalRecordCount());

        int startIndex = 5;
        folders.setStartIndex(startIndex);
        assertEquals(startIndex, folders.getStartIndex());
    }
}