
package com.lariflix.jemm.forms;

import java.awt.Dialog;
import java.awt.Window;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author cesarbianchi
 */
public class WaitingWindow {
    JDialog dialog = null; 
    WaitingPanel panel = null;
    private final int DOWNLOADING_DATA = 1;
    private final int UPLOADING_DATA = 2;
    
    public WaitingWindow(String cURL, int nOption) {
        
        panel = new WaitingPanel(cURL, nOption); 
        
         if (dialog == null) {
            Window win = SwingUtilities.getWindowAncestor(panel);
            
            dialog = new JDialog(win, "Waiting...",Dialog.ModalityType.APPLICATION_MODAL );
            dialog.setSize(900,200);
            dialog.setResizable(false);
            dialog.getContentPane().add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            
        }
        
    }
    
    public void showDialog(){
        
        //Show dialog to user define the new People (From existing or New)
        ScheduledExecutorService sch = Executors.newSingleThreadScheduledExecutor();     
        sch.schedule(new Runnable() {
            public void run() {
                dialog.setVisible(false);
                dialog.dispose();
            }
        }, 2, TimeUnit.SECONDS);
        
        
        dialog.setVisible(true);

    }
    
    public void closeDialog(){
        /*
        Window win = SwingUtilities.getWindowAncestor(null);
        if (win != null) {
            win.dispose();
        }*/

    }


}
