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
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import static com.lariflix.jemm.reports.JellyfinReportInventory.instanceData;
import static com.lariflix.jemm.reports.JellyfinReportTypes.INVENTORY_BASIC;
import static com.lariflix.jemm.reports.JellyfinReportTypes.INVENTORY_FULL;
import java.io.IOException;
import java.net.MalformedURLException;
import net.sf.jasperreports.engine.JRException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportGenres {
    
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportInventoryStructure items = new JellyfinReportInventoryStructure();
    private int totalsubItems = 0;
    private JellyfinReportTypes reportType = null;  
    
    public JellyfinReportGenres(JellyfinReportTypes rpType) {
        this.reportType = rpType;
    }

    public JellyfinReportGenres(JellyfinInstanceDetails instanceData, JellyfinReportTypes rpType) {
        JellyfinReportInventory.instanceData = instanceData;
        this.reportType = rpType;
    }
    
    public void  loadReportItems() throws IOException, MalformedURLException, ParseException, JRException{
        
        switch(reportType) {
            case GENRES_BASIC:
                this.loadItems();
                //this.loadSubItems();
                break;
            case GENRES_FULL:
                this.loadItems();
                //this.loadSubItems();
                //this.loadSubItemsMetadata();
                break;
        }
    }
    
    private void loadItems() throws IOException, MalformedURLException, ParseException{
        
        /* TO DO TO DO
        LoadFolders loadItems = new LoadFolders();
        loadItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadItems.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinFolders folders = loadItems.requestFolders();
        
        for(int nI = 0; nI < folders.getTotalRecordCount();nI++){            
            JellyfinReportInventoryItem item = new JellyfinReportInventoryItem();
            item.setItem( folders.getItems().get(nI) );
            
            //set itemMetadata
            LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
            loadItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            loadItemMetadata.setcItemID(item.getId());            
            JellyfinItemMetadata itemMetadata = loadItemMetadata.requestItemMetadata();            
            item.setItemMetadata(itemMetadata);
            
            items.add(item);
        }
        
        items.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
     */   
    }
    
}
