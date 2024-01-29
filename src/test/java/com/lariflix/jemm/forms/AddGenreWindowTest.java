package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinGenreItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddGenreWindowTest {

    @Test
    public void testShowDialog() {
        ConnectJellyfinAPI connAPI = new ConnectJellyfinAPI();
        
        //connAPI.setcBaseURL(testCredentials.getcURL());
        //connAPI.setcTokenApi(testCredentials.getcTokenAPI());
        
        AddGenreWindow window = new AddGenreWindow(connAPI);        
        window.panel.jTextField1.setText("123");
        window.panel.jTextField2.setText("GenreName");

        // Test the showDialog method        
        JellyfinGenreItem newGenre = window.justLoadWithoutShow();
        
        assertEquals("123", newGenre.getId());
        assertEquals("GenreName", newGenre.getName());  

    }
}