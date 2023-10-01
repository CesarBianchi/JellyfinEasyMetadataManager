
package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinGenreItem;
import com.lariflix.jemm.dtos.JellyfinStudioItem;
import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author cesarbianchi
 */
public class AddStudioWindow {
    JDialog dialog = null; 
    AddStudioPanel panel = new AddStudioPanel(); 
    
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
