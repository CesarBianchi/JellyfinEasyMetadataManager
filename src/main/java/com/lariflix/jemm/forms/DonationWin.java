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

import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author cesarbianchi
 */
public class DonationWin {
    private JDialog dialog = null; 
    
    public DonationWin(){
        
    }
    
    public void show(){
     
        DonationPanel panel = new DonationPanel();
        
        if (dialog == null) {
           Window win = SwingUtilities.getWindowAncestor(panel);

           dialog = new JDialog(win, "Buy me a coffee!!!",Dialog.ModalityType.APPLICATION_MODAL );
           //dialog.setSize(500,500);
           dialog.setResizable(false);
           dialog.getContentPane().add(panel);
           dialog.pack();
           dialog.setLocationRelativeTo(null);
           dialog.setVisible(true);

       }
    }        
}
