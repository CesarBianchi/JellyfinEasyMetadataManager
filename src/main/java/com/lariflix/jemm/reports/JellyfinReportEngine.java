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
package com.lariflix.jemm.reports;

import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import static com.lariflix.jemm.reports.JellyfinReportTypes.GENRES_BASIC;
import static com.lariflix.jemm.reports.JellyfinReportTypes.INVENTORY_BASIC;
import static com.lariflix.jemm.reports.JellyfinReportTypes.INVENTORY_FULL;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportEngine extends Thread {
    private JellyfinReportTypes reportType = null;
    private JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();
    private boolean isDone = false;
    
    public JellyfinReportEngine(JellyfinReportTypes rpType, JellyfinInstanceDetails instData){
        this.setReportType(rpType);
        this.setInstanceData(instData);
    }
    
    @Override
    public void run(){
        synchronized(this){
            
            JellyfinReportTypes rpType = this.getReportType();
            
            switch(rpType) {
                case INVENTORY_BASIC:
                    printInventoryReport();
                    isDone = true;
                    break;
                case INVENTORY_FULL:
                    printInventoryReport();                    
                    isDone = true;
                    break;
                case GENRES_BASIC:
                    printGenresReport();                    
                    isDone = true;
                    break;    
                case GENRES_FULL:
                    printGenresReport();                    
                    isDone = true;
                    break;        
            }
            notify();
        }
    }
    
    public JellyfinReportTypes getReportType() {
        return reportType;
    }

    public void setReportType(JellyfinReportTypes reportType) {
        this.reportType = reportType;
    }

    public JellyfinInstanceDetails getInstanceData() {
        return instanceData;
    }

    public void setInstanceData(JellyfinInstanceDetails instanceData) {
        this.instanceData = instanceData;
    }

    public boolean isDone() {
        return isDone;
    }
    
    private void printInventoryReport(){

        JellyfinReportInventory fullReport = new JellyfinReportInventory(this.getInstanceData(),this.getReportType());
        try {
            fullReport.loadReportItems();
            fullReport.printReport();
        } catch (IOException ex) {
            Logger.getLogger(JellyfinReportEngine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinReportEngine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(JellyfinReportEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void printGenresReport(){

        JellyfinReportGenres fullReport = new JellyfinReportGenres(this.getInstanceData(),this.getReportType());
        try {
            fullReport.loadReportItems();
            fullReport.printReport();
        } catch (IOException ex) {
            Logger.getLogger(JellyfinReportEngine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinReportEngine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(JellyfinReportEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
