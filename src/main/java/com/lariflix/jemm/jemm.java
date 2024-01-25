package com.lariflix.jemm;

import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.forms.LoginWindow;

/**
 * Main class of the application.
 * 
 * This class is responsible for starting the application.
 * 
 * It creates an instance of JellyfinInstanceDetails and passes it to the LoginWindow.
 * @author Cesar Bianchi
 * @version 1.0.0
 * @since 1.0.0
 * @see com.lariflix.jemm.dtos.JellyfinInstanceDetails
 * @see com.lariflix.jemm.forms.LoginWindow
 * 
 */
public class Jemm {

    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();
    
    public static void main(String[] args) {
        
        LoginWindow loginFrame = new LoginWindow(instanceData);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        
    }
}
