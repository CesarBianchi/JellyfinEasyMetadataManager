/*
 * Copyright (C) 2024 cesarbianchi
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

public class JellyfinLookAndFell {

    public JellyfinLookAndFell() {
    }

    /**
     * Sets "Nimbus" Look and Feel Theme
     * @author CesarBianchi
     * @since January/2021
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
     * Sets "FlatLightLaf" Look and Feel Theme
     * @author CesarBianchi
     * @since January/2021
    */
    public static void setLookAndFeelFlatLightLaf() {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets "FlatDarkLaf" Look and Feel Theme
     * @author CesarBianchi
     * @since January/2021
    */
    public static void setLookAndFeelFlatDarkLaf() {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets "FlatIntelijLaf" Look and Feel Theme
     * @author CesarBianchi
     * @since January/2021
    */
    public static void setLookAndFeelFlatIntelijLaf() {
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf() );

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets "FlatDarculaLaf" Look and Feel Theme
     * @author CesarBianchi
     * @since January/2021
    */
    public static void setLookAndFeelFlatDarculaLaf() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
	
    /**
     * Sets "ArcOrange" Look and Feel Theme
     * @author CesarBianchi
     * @since January/2021
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
     * Sets "DarkPurpleIJTheme" Look and Feel Theme
     * @author CesarBianchi
     * @since January/2021
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
     * Sets "FlatNordTheme(" Look and Feel Theme
     * @author CesarBianchi
     * @since January/2021
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
