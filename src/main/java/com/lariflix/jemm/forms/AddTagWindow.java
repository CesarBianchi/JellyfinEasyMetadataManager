
package com.lariflix.jemm.forms;

/**
 * This class represents a window for adding tags in the application.
 * It provides the necessary interface and methods to handle user interactions for adding new tags.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 
 */
public class AddTagWindow {

    /**
     * Constructs a new AddTagWindow.
     * This constructor initializes the components of the window.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public AddTagWindow() {
    }
    
    /**
     * Displays a dialog to the user to define a new tag and returns the new tag defined by the user.
     * This method makes the dialog visible and retrieves the name of the new tag from the input dialog.
     * 
     * @return The new tag defined by the user.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public String showDialog(){
        
        String cNewTag = javax.swing.JOptionPane.showInputDialog("Tag Name ?");

        return cNewTag;
       
    }
}
