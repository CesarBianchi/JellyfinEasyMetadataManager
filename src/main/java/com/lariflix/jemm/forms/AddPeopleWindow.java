
package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinPeopleItem;
import java.awt.Dialog.ModalityType;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author cesarbianchi
 */
public class AddPeopleWindow {
    JDialog dialog = null; 
    AddPeoplePanel panel = new AddPeoplePanel(); 
    
    public AddPeopleWindow(ConnectJellyfinAPI lData) {
        
        panel.setLoadedData(lData);
        
        if (dialog == null) {
            Window win = SwingUtilities.getWindowAncestor(panel);
            
            dialog = new JDialog(win, "JEMM - Add People",ModalityType.APPLICATION_MODAL );
            dialog.setSize(1050,600);
            dialog.getContentPane().add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            
        }
    }
    
    public JellyfinPeopleItem showDialog(){
        
        //Show dialog to user define the new People (From existing or New)
        dialog.setVisible(true);
        
        //Return the New People Defined
        JellyfinPeopleItem newPeople = new JellyfinPeopleItem();
        newPeople.setId(panel.getjTextField1().getText());
        newPeople.setName(panel.getjTextField2().getText());
        newPeople.setType(panel.getjComboBox1().getSelectedItem().toString());
        newPeople.setRole(panel.getjTextField3().getText());
           
        return newPeople;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    public AddPeoplePanel getPanel() {
        return panel;
    }

    public void setPanel(AddPeoplePanel panel) {
        this.panel = panel;
    }

    
    
}
