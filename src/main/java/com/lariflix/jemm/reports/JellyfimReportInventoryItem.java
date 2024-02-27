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

import com.lariflix.jemm.dtos.JellyfinFolder;
import com.lariflix.jemm.dtos.JellyfinItems;
import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfimReportInventoryItem extends JellyfinFolder{
    
    private ArrayList<JellyfinReportInventorySubItem> subItems = new ArrayList();

    public JellyfimReportInventoryItem() {
    }

    public ArrayList<JellyfinReportInventorySubItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(ArrayList<JellyfinReportInventorySubItem> subItems) {
        this.subItems = subItems;
    }
    
    public void setItem(JellyfinFolder it){
        this.setChannelId(it.getChannelId());
        this.setCollectionType(it.getCollectionType());
        this.setCommunityRating(it.getCommunityRating());
        this.setCriticRating(it.getCriticRating());
        this.setFolderContent(it.getFolderContent());
        this.setId(it.getId());
        this.setIsFolder(it.IsFolder());
        this.setLocationType(it.getLocationType());
        this.setMetadata(it.getMetadata());
        this.setName(it.getName());
        this.setOfficialRating(it.getOfficialRating());
        this.setPremiereDate(it.getPremiereDate());
        this.setProductionYear(it.getProductionYear());
        this.setServerId(it.getServerId());
        this.setType(it.getType());
    }
    
    public void setSubItems(JellyfinItems subItems){
        
        ArrayList<JellyfinReportInventorySubItem> reportSubItems = new ArrayList();
        
        for (int nI = 0; nI < subItems.items.size(); nI++){
            
            JellyfinReportInventorySubItem reportSubItem = new JellyfinReportInventorySubItem();            
            reportSubItem.setSubItem(subItems.getItems().get(nI));
            
            reportSubItems.add(reportSubItem);
        }
        
        this.subItems = reportSubItems;
    }
    
}
