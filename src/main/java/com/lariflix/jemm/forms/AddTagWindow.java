
package com.lariflix.jemm.forms;

/**
 *
 * @author cesarbianchi
 */
public class AddTagWindow {

    public AddTagWindow() {
    }
    
    public String showDialog(){
        
        String cNewTag = javax.swing.JOptionPane.showInputDialog("Tag Name ?");

        return cNewTag;
       
    }
}
