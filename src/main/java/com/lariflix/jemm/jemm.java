/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lariflix.jemm;

import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.forms.LoginWindow;

/**
 *
 * @author cesarbianchi
 */
public class jemm {

    static JellyfinInstanceDetails InstanceData = new JellyfinInstanceDetails();
    
    public static void main(String[] args) {
        
        LoginWindow loginFrame = new LoginWindow(InstanceData);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.show();
        
    }
}
