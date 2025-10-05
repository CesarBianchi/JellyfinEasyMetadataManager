
package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinGenreItem;
import com.lariflix.jemm.dtos.JellyfinStudioItem;
import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 * This class represents a window for adding studios in the application.
 * It provides the necessary interface and methods to handle user interactions for adding new studios.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 
 */
public class AddStudioWindow {
    JDialog dialog = null; 
    AddStudioPanel panel = new AddStudioPanel(); 
    
   /**
     * Constructs a new AddStudioWindow.
     * This constructor initializes the components of the window, sets the instance of ConnectJellyfinAPI to be used by the AddStudioWindow, and creates a new dialog.
     * If the dialog has not been created yet, it creates a new dialog with the title "JEMM - Add Studio", sets its size to 1050x600, adds the panel to the dialog, packs the dialog, and centers the dialog on the screen.
     * 
     * @param lData The instance of ConnectJellyfinAPI to be used.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public AddStudioWindow(ConnectJellyfinAPI lData) {
        
        panel.setLoadedData(lData);
        
        if (dialog == null) {
            Window win = SwingUtilities.getWindowAncestor(panel);
            
            dialog = new JDialog(win, "JEMM - Add Studio",Dialog.ModalityType.APPLICATION_MODAL );
            dialog.setSize(1050,600);
            dialog.getContentPane().add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            
        }
    }
    
    /**
     * Displays the dialog to the user to define a new studio and returns the new studio defined by the user.
     * This method makes the dialog visible, retrieves the id and name of the new studio from the text fields, and creates a new JellyfinStudioItem with the retrieved id and name.
     * 
     * @return The new JellyfinStudioItem defined by the user.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public JellyfinStudioItem showDialog(){
        
        //Show dialog to user define the new People (From existing or New)
        dialog.setVisible(true);
        
        //Return the New Studio Defined
        JellyfinStudioItem newStudio = new JellyfinStudioItem();
        newStudio.setId(panel.getjTextField1().getText());
        newStudio.setName(panel.getjTextField2().getText());
           
        return newStudio;
    }
}
