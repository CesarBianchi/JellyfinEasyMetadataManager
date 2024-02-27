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

import com.lariflix.jemm.core.LoadFolders;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReport {
    
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private ArrayList<JellyfimReportItem> items = new ArrayList();
    
    
    public JellyfinReport() {
    }

    public JellyfinReport(JellyfinInstanceDetails instanceData) {
        JellyfinReport.instanceData = instanceData;
    }

    public void paintReport() throws IOException, MalformedURLException, ParseException{
        this.loadItems();
    }
    
    private void loadItems() throws IOException, MalformedURLException, ParseException{
        
        LoadFolders loadItems = new LoadFolders();
        loadItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadItems.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinFolders folders = loadItems.requestFolders();
        
        
        for(int nI = 0; nI < folders.getTotalRecordCount();nI++){            
            JellyfimReportItem item = new JellyfimReportItem();
            item.setItem( folders.getItems().get(nI) );
            items.add(item);
            
            items.get(1).getName();
        }
        
        System.out.println("breakpoint");
    }

    private void loadSubItems(){
        
    }
}
