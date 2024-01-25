
package com.lariflix.jemm.forms;

/**
 * A window for adding tags.
 * 
 * @author Cesar Bianchi
 */
public class AddTagWindow {

    /**
     * Constructs a new AddTagWindow.
     * 
     * @author Cesar Bianchi
     */
    public AddTagWindow() {
    }
    
    /**
     * Displays a dialog to prompt the user for a tag name.
     * 
     * @return the tag name entered by the user
     * @author Cesar Bianchi
     */
    public String showDialog(){
        
        String cNewTag = javax.swing.JOptionPane.showInputDialog("Tag Name ?");

        return cNewTag;
       
    }
}
