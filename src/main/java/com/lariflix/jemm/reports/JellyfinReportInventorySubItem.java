package com.lariflix.jemm.reports;
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


import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportInventorySubItem extends JellyfinItem{
    
    private JellyfinItemMetadata subItemMetadata = new JellyfinItemMetadata();
 
    public void setSubItem(JellyfinItem subIt){
        this.setAspectRatio(subIt.getAspectRatio());
        this.setCommunityRating(subIt.getCommunityRating());
        this.setContainer(subIt.getContainer());
        this.setCriticRating(subIt.getCriticRating());
        this.setId(subIt.getId());
        this.setIsFolder(subIt.IsFolder());
        this.setItemMetadata(subIt.getItemMetadata());
        this.setLocationType(subIt.getLocationType());
        this.setMediaType(subIt.getMediaType());
        this.setName(subIt.getName());
        this.setOfficialRating(subIt.getOfficialRating());
        this.setPremiereDate(subIt.getPremiereDate());
        this.setProductionYear(subIt.getProductionYear());
        this.setServerId(subIt.getServerId());
        this.setType(subIt.getType());
        this.setVideoType(subIt.getVideoType());
    }

    public void setSubItemMetadata(JellyfinItemMetadata subItemMetadata) {
        this.subItemMetadata = subItemMetadata;
    }

    public JellyfinItemMetadata getSubItemMetadata() {
        return subItemMetadata;
    }
    
    
    
}
