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
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportInventory {
    
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private ArrayList<JellyfimReportInventoryItem> items = new ArrayList();
    
    
    public JellyfinReportInventory() {
    }

    public JellyfinReportInventory(JellyfinInstanceDetails instanceData) {
        JellyfinReportInventory.instanceData = instanceData;
    }

    public void paintReport() throws IOException, MalformedURLException, ParseException{
        this.loadItems();
        this.loadSubItems();
        this.loadSubItemsMetadata();
    }
    
    private void loadItems() throws IOException, MalformedURLException, ParseException{
        
        LoadFolders loadItems = new LoadFolders();
        loadItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadItems.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinFolders folders = loadItems.requestFolders();
        
        for(int nI = 0; nI < folders.getTotalRecordCount();nI++){            
            JellyfimReportInventoryItem item = new JellyfimReportInventoryItem();
            item.setItem( folders.getItems().get(nI) );
            items.add(item);
        }
        
        System.out.println("breakpoint");
    }

    private void loadSubItems(){
        
        LoadItems loadSubItems = new LoadItems();
        loadSubItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadSubItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadSubItems.setcUserAdminID(instanceData.adminUser.getId());
        
        for (int nI = 0; nI < items.size(); nI++){
            
            loadSubItems.setcParentID(items.get(nI).getId());            
            try {
                JellyfinItems subItems = loadSubItems.requestItems();
                
                items.get(nI).setSubItems(subItems);                
                
            } catch (IOException ex) {
                Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        System.out.println("breakpoint");
    }

    private void loadSubItemsMetadata() {
        
        LoadItemMetadata loadSubItemMetadata = new LoadItemMetadata();
        loadSubItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadSubItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadSubItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
        
        for (int nI = 0; nI < items.size(); nI++){            
            for (int nJ = 0; nJ < items.get(nI).getSubItems().size(); nJ++){
                
                String cItemID = items.get(nI).getSubItems().get(nJ).getId();                
                loadSubItemMetadata.setcItemID(cItemID);
                
                JellyfinItemMetadata subItemMetadata;
                try {
                    subItemMetadata = loadSubItemMetadata.requestItemMetadata();
                    items.get(nI).getSubItems().get(nJ).setSubItemMetadata(subItemMetadata);
                    
                } catch (IOException ex) {
                    Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }            
        }
        
        System.out.println("breakpoint");
    }
}
