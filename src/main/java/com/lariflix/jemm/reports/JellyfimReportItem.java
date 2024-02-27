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
import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfimReportItem extends JellyfinFolder{
    
    private ArrayList<JellyfinReportSubItem> subItems = new ArrayList();

    public JellyfimReportItem() {
    }

    public ArrayList<JellyfinReportSubItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(ArrayList<JellyfinReportSubItem> subItems) {
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
    
}
