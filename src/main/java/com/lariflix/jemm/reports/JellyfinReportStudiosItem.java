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

import com.lariflix.jemm.dtos.JellyfinCadStudioItem;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportStudiosItem extends JellyfinCadStudioItem{
    
    private JellyfinItemMetadata studioMetadata = new JellyfinItemMetadata();
    private ArrayList<JellyfinReportInventorySubItem> studioEpisodes = new ArrayList();
    private int totalsubItems = 0;

    public JellyfinReportStudiosItem() {
    }
    
    public void setItem(JellyfinCadStudioItem it){
        this.name = it.getName();
        this.serverId = it.getServerId();
        this.id = it.getId();        
        this.channelId = it.getChannelId();
        this.type = it.getType();
        this.locationType = it.getLocationType();   
    }

    public JellyfinItemMetadata getStudioMetadata() {
        return studioMetadata;
    }

    public void setStudioMetadata(JellyfinItemMetadata studiosMetadata) {
        this.studioMetadata = studiosMetadata;
    }
    
    public void setTotalsubItems(int totalsubItems) {
        this.totalsubItems = totalsubItems;
    }
    
    public void addStudioEpisode(JellyfinItem episode, JellyfinItemMetadata episodeMetadata){
        
        JellyfinReportInventorySubItem eps = new JellyfinReportInventorySubItem();
        eps.setSubItem(episode);
        eps.setSubItemMetadata(episodeMetadata);
        
        this.studioEpisodes.add(eps);        
    }

    public ArrayList<JellyfinReportInventorySubItem> getStudioEpisodes() {
        return studioEpisodes;
    }

    public void setStudioEpisodes(ArrayList<JellyfinReportInventorySubItem> studiosEpisodes) {
        this.studioEpisodes = studiosEpisodes;
    }
}
