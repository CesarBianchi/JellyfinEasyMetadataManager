package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinGenreItem;
import com.lariflix.jemm.dtos.JellyfinPeopleItem;
import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 * Class to create a new Window to Add a new Genre to Jellyfin Server
 * 
 * @version 1.0
 * @since 2020-05-01
 * @author Cesar Bianchi
 */
public class AddGenreWindow {
    JDialog dialog = null; 
    AddGenrePanel panel = new AddGenrePanel(); 
    
    /**
     * Constructs a new AddGenreWindow object.
     * 
     * @param lData the ConnectJellyfinAPI object used to load data
     */
    public AddGenreWindow(ConnectJellyfinAPI lData) {
        
        panel.setLoadedData(lData);
        
        if (dialog == null) {
            Window win = SwingUtilities.getWindowAncestor(panel);
            
            dialog = new JDialog(win, "JEMM - Add Genre",Dialog.ModalityType.APPLICATION_MODAL );
            dialog.setSize(1050,600);
            dialog.getContentPane().add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            
        }
    }
    
    /**
     * Displays the Add Genre dialog to the user and returns the newly defined genre.
     * 
     * @return the JellyfinGenreItem object representing the new genre
     */
    public JellyfinGenreItem showDialog(){
        
        //Show dialog to user define the new People (From existing or New)
        dialog.setVisible(true);
        
        //Return the New Genre Defined
        JellyfinGenreItem newGenre = new JellyfinGenreItem();
        newGenre.setId(panel.getjTextField1().getText());
        newGenre.setName(panel.getjTextField2().getText());
           
        return newGenre;
    }
}
