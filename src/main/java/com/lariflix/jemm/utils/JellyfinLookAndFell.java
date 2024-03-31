
package com.lariflix.jemm.utils;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;

/**
 * The JellyfinLookAndFell class is used to manage the look and feel of the Jellyfin application.
 *
 * This class provides methods to set and retrieve the look and feel of the application. 
 * It also provides methods to load and save the look and feel settings.
 *
 * @author Cesar Bianchi
 */
public class JellyfinLookAndFell {

    /**
     * Constructor for the JellyfinLookAndFell class.
     *
     * This is a no-argument constructor that initializes a new instance of the JellyfinLookAndFell class. It doesn't perform any specific actions.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinLookAndFell(){
        // constructor body
    }

    /**
     * Sets the "Nimbus" Look and Feel Theme for the Jellyfin application.
     *
     * This method iterates over the installed look and feels in the UIManager and sets the look and feel to "Nimbus" if it is found. 
     * If an exception is thrown during this process, it is caught and the error message is printed to the console.
     *
     * This method does not return a value.
     *
     * @throws UnsupportedLookAndFeelException If the look and feel is not supported.
     * @throws ClassNotFoundException If the look and feel class could not be found.
     * @throws InstantiationException If the look and feel class could not be instantiated.
     * @throws IllegalAccessException If the look and feel class or its nullary constructor is not accessible.
     * @since January/2021
     * @author Cesar Bianchi
     */
    public static void setLookAndFeelNimbus() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {

            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();

        } catch (ClassNotFoundException e) {

                System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();

        } catch (InstantiationException e) {

                System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();

        } catch (IllegalAccessException e) {

                System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
    /**
     * Sets the "FlatLightLaf" Look and Feel Theme for the Jellyfin application.
     *
     * This method sets the look and feel to "FlatLightLaf" using the UIManager. 
     * If an exception is thrown during this process, it is caught and the error message "Failed to initialize LaF" is printed to the console.
     *
     * This method does not return a value.
     *
     * @throws UnsupportedLookAndFeelException If the look and feel is not supported.
     * @throws ClassNotFoundException If the look and feel class could not be found.
     * @throws InstantiationException If the look and feel class could not be instantiated.
     * @throws IllegalAccessException If the look and feel class or its nullary constructor is not accessible.
     * @since January/2021
     * @author Cesar Bianchi
     */
    public static void setLookAndFeelFlatLightLaf() {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets the "FlatDarkLaf" Look and Feel Theme for the Jellyfin application.
     *
     * This method sets the look and feel to "FlatDarkLaf" using the UIManager. 
     * If an exception is thrown during this process, it is caught and the error message "Failed to initialize LaF" is printed to the console.
     *
     * This method does not return a value.
     *
     * @throws UnsupportedLookAndFeelException If the look and feel is not supported.
     * @throws ClassNotFoundException If the look and feel class could not be found.
     * @throws InstantiationException If the look and feel class could not be instantiated.
     * @throws IllegalAccessException If the look and feel class or its nullary constructor is not accessible.
     * @since January/2021
     * @author Cesar Bianchi
     */
    public static void setLookAndFeelFlatDarkLaf() {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets the "FlatIntelijLaf" Look and Feel Theme for the Jellyfin application.
     *
     * This method sets the look and feel to "FlatIntelijLaf" using the UIManager. 
     * If an exception is thrown during this process, it is caught and the error message "Failed to initialize LaF" is printed to the console.
     *
     * This method does not return a value.
     *
     * @throws UnsupportedLookAndFeelException If the look and feel is not supported.
     * @throws ClassNotFoundException If the look and feel class could not be found.
     * @throws InstantiationException If the look and feel class could not be instantiated.
     * @throws IllegalAccessException If the look and feel class or its nullary constructor is not accessible.
     * @since January/2021
     * @author Cesar Bianchi
     */
    public static void setLookAndFeelFlatIntelijLaf() {
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf() );

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets the "FlatDarculaLaf" Look and Feel Theme for the Jellyfin application.
     *
     * This method sets the look and feel to "FlatDarculaLaf" using the UIManager. 
     * If an exception is thrown during this process, it is caught and the error message "Failed to initialize LaF" is printed to the console.
     *
     * This method does not return a value.
     *
     * @throws UnsupportedLookAndFeelException If the look and feel is not supported.
     * @throws ClassNotFoundException If the look and feel class could not be found.
     * @throws InstantiationException If the look and feel class could not be instantiated.
     * @throws IllegalAccessException If the look and feel class or its nullary constructor is not accessible.
     * @since January/2021
     * @author Cesar Bianchi
     */
    public static void setLookAndFeelFlatDarculaLaf() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets the "ArcOrange" Look and Feel Theme for the Jellyfin application.
     *
     * This method sets the look and feel to "ArcOrange" using the FlatArcOrangeIJTheme. 
     * If an exception is thrown during this process, it is caught and the error message "Failed to initialize LaF" is printed to the console.
     *
     * This method does not return a value.
     *
     * @throws Exception If there is a problem with setting the look and feel.
     * @since January/2021
     * @author Cesar Bianchi
     */
    public static void setLookAndFeelArcOrange() {
        try {
            FlatArcOrangeIJTheme lookF = new FlatArcOrangeIJTheme();
            lookF.install(lookF);

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets the "DarkPurpleIJTheme" Look and Feel Theme for the Jellyfin application.
     *
     * This method sets the look and feel to "DarkPurpleIJTheme" using the FlatDarkPurpleIJTheme. 
     * If an exception is thrown during this process, it is caught and the error message "Failed to initialize LaF" is printed to the console.
     *
     * This method does not return a value.
     *
     * @throws Exception If there is a problem with setting the look and feel.
     * @since January/2021
     * @author Cesar Bianchi
     */
    public static void setLookAndFeelFlatDarkPurpleIJTheme() {
        try {
            FlatDarkPurpleIJTheme lookF = new FlatDarkPurpleIJTheme();
            lookF.install(lookF);


        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets the "FlatNordTheme" Look and Feel Theme for the Jellyfin application.
     *
     * This method sets the look and feel to "FlatNordTheme" using the FlatNordIJTheme. 
     * If an exception is thrown during this process, it is caught and the error message "Failed to initialize LaF" is printed to the console.
     *
     * This method does not return a value.
     *
     * @throws Exception If there is a problem with setting the look and feel.
     * @since January/2021
     * @author Cesar Bianchi
     */
    public static void setLookAndFeelFlatFlatNordTheme() {
        try {
            FlatNordIJTheme lookF = new FlatNordIJTheme();
            lookF.install(lookF);
            
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
    
}
