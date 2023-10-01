/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinGenreItem;
import com.lariflix.jemm.dtos.JellyfinPeopleItem;
import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author cesarbianchi
 */
public class AddGenreWindow {
    JDialog dialog = null; 
    AddGenrePanel panel = new AddGenrePanel(); 
    
    public AddGenreWindow(ConnectJellyfinAPI lData) {
        
        panel.setLoadedData(lData);
        
        if (dialog == null) {
            Window win = SwingUtilities.getWindowAncestor(panel);
            
            dialog = new JDialog(win, "JEMM - Add Genre",Dialog.ModalityType.APPLICATION_MODAL );
            dialog.setSize(1050,600);
            dialog.getContentPane().add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            
        }
    }
    
    public JellyfinGenreItem showDialog(){
        
        //Show dialog to user define the new People (From existing or New)
        dialog.setVisible(true);
        
        //Return the New Genre Defined
        JellyfinGenreItem newGenre = new JellyfinGenreItem();
        newGenre.setId(panel.getjTextField1().getText());
        newGenre.setName(panel.getjTextField2().getText());
           
        return newGenre;
    }
}
