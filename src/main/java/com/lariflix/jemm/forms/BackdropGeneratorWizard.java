/*
 * Copyright (C) 2025 cesarbianchi
 *
 */
package com.lariflix.jemm.forms;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Simple wizard that guides the user through backdrop image generation.
 *
 * <p>This class constructs a small Swing-based wizard window composed of a
 * dynamic content panel and a footer panel containing navigation buttons.
 * It currently implements the first step and a placeholder "work in
 * progress" view for subsequent steps.
 *
 * <p>Example usage:
 * <pre>
 * BackdropGeneratorWizard wiz = new BackdropGeneratorWizard();
 * wiz.show();
 * </pre>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see BackdropWizardPanel_01
 * @see BackdropWizardPanel_Footer
 */
public class BackdropGeneratorWizard {

    //JDialog frame = new JDialog(null, "Backdrop Image Generator",Dialog.ModalityType.APPLICATION_MODAL );
    JFrame frame = new JFrame("Backdrop Image Generator");
    JPanel mainPanel = new JPanel();
    JPanel dinamicPanel = new JPanel();
    JPanel footPanel = new BackdropWizardPanel_Footer();
    JButton buttonNext = new JButton("Next");
    JButton buttonCancel = new JButton("Cancel");
    
    /**
     * Constructs the wizard and prepares the first step UI.
     *
     * @since 1.0
     */
    public BackdropGeneratorWizard() {
        this.paintStep01();
    }
    
    /**
     * Shows the wizard window.
     */
    public void show(){
        // Make the frame visible
        frame.pack(); // Adjusts frame size to fit its contents
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);       
    }

    /**
     * Prepares and paints the first step of the wizard.
     */
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
    
    /**
     * Handler for the Cancel button; closes the wizard.
     */
    private void cancelButtonPressed() {
        frame.dispose();
    }

    /**
     * Handler for the Next button; currently closes this window and shows a
     * work-in-progress view for the next steps.
     */
    private void nextButtonPressed() {
        frame.dispose();
        
        //WORKING IN PROGRESS - TO DO!
        //this.paintStep02();
        
        this.paintWIP();
    }

    /**
     * Paints the second step of the wizard. Currently unused; reserved for
     * future implementation.
     */
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
    
    /**
     * Shows a placeholder "work in progress" dialog for unimplemented steps.
     */
    private void paintWIP() {
        
        //Create the Main JFrame
        frame = new JFrame("Under development");
        mainPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 400);
        
         // Create the Main Botton JPanel
        mainPanel.setLayout(new BorderLayout()); 
        
        JLabel label = new JLabel("\n \n \n    Feature under development... wait for the next versions!    \n \n \n");        
        mainPanel.add(label, BorderLayout.CENTER);
        
        // Add the parent JPanel to the JFrame
        frame.add(mainPanel);   
        frame.pack(); // Adjusts frame size to fit its contents
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
    
}
