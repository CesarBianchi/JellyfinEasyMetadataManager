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
package com.lariflix.jemm.forms;

import static com.lariflix.jemm.forms.MainWindow.instanceData;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarbianchi
 */
public class WaitingWindowShow extends Thread {
    
    private final int DOWNLOADING_DATA = 1;
    private final int UPLOADING_DATA = 2;
    
    public WaitingWindowShow(){
        
    }
    
    @Override
    public void run(){
        synchronized(this){
            WaitingWindow waitWin = new WaitingWindow(instanceData.getCredentials().getBaseURL(),UPLOADING_DATA);
            waitWin.showDialog();  
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitingWindowShow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
