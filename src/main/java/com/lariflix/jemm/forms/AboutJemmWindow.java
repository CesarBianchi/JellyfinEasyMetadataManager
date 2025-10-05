package com.lariflix.jemm.forms;

import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 * The AboutJemmWindow class provides a window that displays information about the Jemm application.
 * This includes the version number, author, and other relevant details.
 *
 * @author Cesar Bianchi
 */
public class AboutJemmWindow {

    private JDialog dialog = null; 
    
    /**
     * Constructor for the AboutJemmWindow class.
     *
     * This constructor initializes the AboutJemmWindow. Additional setup should be done as needed.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public AboutJemmWindow() {
    }
    
    /**
     * Displays the About JEMM dialog.
     *
     * This method creates a new AboutJemmPanel and displays it in a modal JDialog. If the dialog has already been created, this method does nothing.
     *
     * @since 1.0
     * @author Cesar Bianchi
    */
    public void show(){
        AboutJemmPanel panel = new AboutJemmPanel();
        
         if (dialog == null) {
            Window win = SwingUtilities.getWindowAncestor(panel);
            
            dialog = new JDialog(win, "About JEMM",Dialog.ModalityType.APPLICATION_MODAL );
            dialog.setSize(500,500);
            dialog.setResizable(false);
            dialog.getContentPane().add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            
        }
    }
}
