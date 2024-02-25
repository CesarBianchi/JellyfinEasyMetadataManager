package com.lariflix.jemm.forms;

import com.lariflix.jemm.forms.AddGenrePanel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddGenrePanelTest {
/*
    @Test
    public void testAddGenrePanel() {
        AddGenrePanel addGenrePanel = new AddGenrePanel();

        // Test that the AddGenrePanel is not null
        assertNotNull(addGenrePanel);
    }
*/
    @Test
    public void testExistingGenreSelected() {
        // Test that the existingGenreSelected static variable is correctly initialized
        assertEquals(1, AddGenrePanel.existingGenreSelected);
    }

    @Test
    public void testNewGenreSelected() {
        // Test that the newGenreSelected static variable is correctly initialized
        assertEquals(2, AddGenrePanel.newGenreSelected);
    }
}