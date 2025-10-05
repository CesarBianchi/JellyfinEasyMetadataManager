package com.lariflix.jemm.forms;

import com.lariflix.jemm.forms.AddPeoplePanel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddPeoplePanelTest {

    @Test
    public void testAddPeoplePanel() {
        AddPeoplePanel addPeoplePanel = new AddPeoplePanel();

        // Test that the AddPeoplePanel is not null
        assertNotNull(addPeoplePanel);
    }
    
}