package com.lariflix.jemm.forms;

import com.lariflix.jemm.forms.AddGenrePanel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link AddGenrePanel} form.
 *
 * These tests verify the initial static selection constants used by the
 * `AddGenrePanel` UI. They are lightweight checks that do not instantiate
 * Swing components.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see AddGenrePanel
 */
public class AddGenrePanelTest {

	@Test
	public void AddGenrePanelTest() {
		
	}
	/*
    @Test
    public void testAddGenrePanel() {
        AddGenrePanel addGenrePanel = new AddGenrePanel();

        // Test that the AddGenrePanel is not null
        assertNotNull(addGenrePanel);
    }
*/
    /**
     * Verifies that the static constant for selecting an existing genre is
     * initialized to the expected value.
     *
     * @since 1.0
     */
    @Test
    public void testExistingGenreSelected() {
        assertEquals(1, AddGenrePanel.existingGenreSelected);
    }

    /**
     * Verifies that the static constant for selecting a new genre is
     * initialized to the expected value.
     *
     * @since 1.0
     */
    @Test
    public void testNewGenreSelected() {
        assertEquals(2, AddGenrePanel.newGenreSelected);
    }
}