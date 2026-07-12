/*
 * Copyright (C) 2025 cesarbianchi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.lariflix.jemm.forms;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cesarbianchi
 */
public class BackdropGeneratorWizard {

    //JDialog frame = new JDialog(null, "Backdrop Image Generator",Dialog.ModalityType.APPLICATION_MODAL );
    JFrame frame = new JFrame("Backdrop Image Generator");
    JPanel mainPanel = new JPanel();
    JPanel dinamicPanel = new JPanel();
    JPanel footPanel = new BackdropWizardPanel_Footer();
    JButton buttonNext = new JButton("Next");
    JButton buttonCancel = new JButton("Cancel");
    
    public BackdropGeneratorWizard() {
        this.paintStep01();
    }
    
    public void show(){
        // Make the frame visible
        frame.pack(); // Adjusts frame size to fit its contents
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);       
    }

    public void paintStep01(){
        //Define the actions for Cancel and Next Button
        buttonCancel.addActionListener(e -> cancelButtonPressed());
        buttonNext.addActionListener(e -> nextButtonPressed());
        
        //Create the Main JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 400);
        
         // Create the Main Botton JPanel
        mainPanel.setLayout(new BorderLayout()); 
        
        // Create the dinamic Panel
        dinamicPanel = new BackdropWizardPanel_01();
           
        // Add the dinamic JPanel to the mainBotton JPanel
        mainPanel.add(dinamicPanel, BorderLayout.CENTER);
        
        // Add the footer Panel
        buttonCancel.setBounds(260, 15, 120, 30);
        buttonNext.setBounds(400, 15, 120, 30);        
        footPanel.add(buttonNext,BorderLayout.SOUTH);
        footPanel.add(buttonCancel,BorderLayout.SOUTH);
        mainPanel.add(footPanel,BorderLayout.SOUTH);
        
        // Add the parent JPanel to the JFrame
        frame.add(mainPanel);   
    }
    
    private void cancelButtonPressed() {
        frame.dispose();
    }

    private void nextButtonPressed() {
        frame.dispose();
        
        //WORKING IN PROGRESS - TO DO!
        //this.paintStep02();
        
        this.paintWIP();
    }

    private void paintStep02() {
        
        //Create the Main JFrame
        frame = new JFrame("Backdrop Image Generator");
        mainPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 400);
        
         // Create the Main Botton JPanel
        mainPanel.setLayout(new BorderLayout()); 
        
        // Create the dinamic Panel
        dinamicPanel = new BackdropWizardPanel_02();
           
        // Add the dinamic JPanel to the mainBotton JPanel
        mainPanel.add(dinamicPanel, BorderLayout.CENTER);
        
        // Add the footer Panel
        /*
        buttonCancel.setBounds(260, 15, 120, 30);
        buttonNext.setBounds(400, 15, 120, 30);        
        footPanel.add(buttonNext,BorderLayout.SOUTH);
        footPanel.add(buttonCancel,BorderLayout.SOUTH);
        mainPanel.add(footPanel,BorderLayout.SOUTH);*/
        
        // Add the parent JPanel to the JFrame
        frame.add(mainPanel);   
        frame.pack(); // Adjusts frame size to fit its contents
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
    
    private void paintWIP() {
        
        //Create the Main JFrame
        frame = new JFrame("Under development");
        mainPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 400);
        
         // Create the Main Botton JPanel
        mainPanel.setLayout(new BorderLayout()); 
        
        JLabel label = new JLabel("Feature under development... wait for the next versions!");        
        mainPanel.add(label, BorderLayout.CENTER);
        
        // Add the parent JPanel to the JFrame
        frame.add(mainPanel);   
        frame.pack(); // Adjusts frame size to fit its contents
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
    
}
