package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinGenreItem;
import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 * This class represents a window for adding genres in the application.
 * It provides the necessary interface and methods to handle user interactions for adding new genres.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 
 */
public class AddGenreWindow {
    JDialog dialog = null; 
    AddGenrePanel panel = new AddGenrePanel(); 
    
    /**
     * Constructs a new AddGenreWindow.
     * This constructor sets the instance of ConnectJellyfinAPI used by the AddGenrePanel and initializes the dialog.
     * If the dialog has not been initialized yet, it creates a new JDialog with the title "JEMM - Add Genre", sets its size, adds the panel to it, packs it, and centers it on the screen.
     * 
     * @param connData The instance of ConnectJellyfinAPI to be used.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public AddGenreWindow(ConnectJellyfinAPI connData) {
        
        panel.setLoadedData(connData);
        
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
     * Displays the dialog to the user and returns the new genre defined by the user.
     * This method makes the dialog visible to the user and waits for the user to define a new genre.
     * After the user has defined a new genre, it creates a new JellyfinGenreItem, sets its id and name based on the text in the text fields, and returns it.
     * 
     * @return The new genre defined by the user.
     * @author Cesar Bianchi
     * @since 1.0
     
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
    
    /**
     * Load the classes but down show the window.
     * This method was created just to perform Test Case. Please don't apply in other cases.
     * After the test has defined a new genre, it creates a new JellyfinGenreItem, sets its id and name based on the text in the text fields, and returns it.
     * 
     * @return The new genre defined by the user.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public JellyfinGenreItem justLoadWithoutShow(){
         //Return the New Genre Defined
        JellyfinGenreItem newGenre = new JellyfinGenreItem();
        newGenre.setId(panel.getjTextField1().getText());
        newGenre.setName(panel.getjTextField2().getText());
           
        return newGenre;
    }
    
}
