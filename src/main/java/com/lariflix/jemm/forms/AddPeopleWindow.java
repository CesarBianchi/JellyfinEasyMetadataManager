
package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinPeopleItem;
import java.awt.Dialog.ModalityType;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 * This class represents a window for adding people in the application.
 * It provides the necessary interface and methods to handle user interactions for adding new people.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 * @createdate 2022-02-01
 */
public class AddPeopleWindow {
    JDialog dialog = null; 
    AddPeoplePanel panel = new AddPeoplePanel(); 
    
    /**
     * Constructs a new AddPeopleWindow.
     * This constructor sets the instance of ConnectJellyfinAPI used by the AddPeoplePanel and initializes the dialog.
     * If the dialog has not been initialized yet, it creates a new JDialog with the title "JEMM - Add People", sets its size, adds the panel to it, packs it, and centers it on the screen.
     * 
     * @param lData The instance of ConnectJellyfinAPI to be used.
     * @author Cesar Bianchi
     * @since 1.0
     * @createdate 2022-02-01
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
     * Displays the dialog to the user and returns the new person defined by the user.
     * This method makes the dialog visible to the user and waits for the user to define a new person.
     * After the user has defined a new person, it creates a new JellyfinPeopleItem, sets its id, name, type, and role based on the text in the text fields and the selected item in the combo box, and returns it.
     * 
     * @return The new person defined by the user.
     * @author Cesar Bianchi
     * @since 1.0
     * @createdate 2022-02-01
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
     * @return the JDialog object representing the dialog associated with this AddPeopleWindow object
     * @see JDialog
     * @author Cesar Bianchi
     * @since 1.0
     * @createdate 2022-02-01
     */
    public JDialog getDialog() {
        return dialog;
    }

    /**
     * Sets the dialog associated with this AddPeopleWindow.
     * 
     * @param dialog the JDialog object representing the dialog associated with this AddPeopleWindow object
     * @see JDialog
     * @author Cesar Bianchi
     * @since 1.0
     * @createdate 2022-02-01
     */
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    /**
     * Retrieves the instance of AddPeoplePanel used by the AddPeopleWindow.
     * 
     * @return The instance of AddPeoplePanel used by the AddPeopleWindow.
     * @author Cesar Bianchi
     * @since 1.0
     * @createdate 2022-02-01
     */
    public AddPeoplePanel getPanel() {
        return panel;
    }

    /**
     * Sets the instance of AddPeoplePanel used by the AddPeopleWindow.
     * 
     * @param panel The instance of AddPeoplePanel to be used by the AddPeopleWindow.
     * @author Cesar Bianchi
     * @see AddPeoplePanel
     * @see ConnectJellyfinAPI
     * @see JellyfinPeopleItem
     * @see JDialog
     * @see Window
     * @see SwingUtilities
     */
    public void setPanel(AddPeoplePanel panel) {
        this.panel = panel;
    }
}
