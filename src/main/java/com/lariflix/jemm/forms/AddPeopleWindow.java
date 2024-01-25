
package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinPeopleItem;
import java.awt.Dialog.ModalityType;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 * Represents a window for adding people in the JEMM application.
 * @author Cesar Bianchi
 */
public class AddPeopleWindow {
    JDialog dialog = null; 
    AddPeoplePanel panel = new AddPeoplePanel(); 
    
    /**
     * Constructs a new AddPeopleWindow object with the specified ConnectJellyfinAPI data.
     * 
     * @param lData the ConnectJellyfinAPI data to be used in the window
     * @author Cesar Bianchi
     */
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
    
    /**
     * Displays the dialog window and allows the user to define a new person.
     * 
     * @return the newly defined JellyfinPeopleItem object
     * @author Cesar Bianchi
     */
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

    /**
     * Returns the dialog associated with this AddPeopleWindow.
     * 
     * @return the JDialog object representing the dialog
     * @author Cesar Bianchi
     */
    public JDialog getDialog() {
        return dialog;
    }

    /**
     * Sets the dialog associated with this AddPeopleWindow.
     * 
     * @param dialog the JDialog object representing the dialog
     * @author Cesar Bianchi
     */
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    /**
     * Returns the panel associated with this AddPeopleWindow.
     * 
     * @return the AddPeoplePanel object representing the panel
     * @author Cesar Bianchi
     */
    public AddPeoplePanel getPanel() {
        return panel;
    }

    /**
     * Sets the panel associated with this AddPeopleWindow.
     * 
     * @param panel the AddPeoplePanel object representing the panel
     * @author Cesar Bianchi
     */
    public void setPanel(AddPeoplePanel panel) {
        this.panel = panel;
    }
}
