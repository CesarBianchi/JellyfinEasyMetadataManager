
package com.lariflix.jemm.forms;

import java.awt.Dialog;
import java.awt.Window;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 * This class represents a window that is displayed while the application is waiting for a process to complete.
 * It extends the JFrame class from the javax.swing package.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 * @see javax.swing.JFrame
 */
public class WaitingWindow {
    JDialog dialog = null; 
    WaitingPanel panel = null;
    private final int DOWNLOADING_DATA = 1;
    private final int UPLOADING_DATA = 2;
    
    /**
     * Constructs a new WaitingWindow with the specified base URL and option.
     * This constructor initializes the panel with the base URL and option, and creates a new dialog with the panel as its content pane.
     * 
     * @param cURL The base URL to be set in the panel.
     * @param nOption The option to be set in the panel. It can be either DOWNLOADING_DATA or UPLOADING_DATA.
     * @author Cesar Bianchi
     * @since 1.0
     * @see WaitingPanel
     * @see javax.swing.JDialog
     */
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
    
    /**
     * Displays the dialog to the user and automatically closes it after 2 seconds.
     * This method uses a ScheduledExecutorService to schedule a task that closes the dialog after 2 seconds. The dialog is then made visible to the user.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     * @see java.util.concurrent.ScheduledExecutorService
     * @see java.util.concurrent.Executors
     * @see java.util.concurrent.TimeUnit
     */
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
