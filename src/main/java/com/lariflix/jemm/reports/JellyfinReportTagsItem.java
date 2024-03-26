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

import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportTagsItem {
    private String tagName = new String();
    private int tagMediaItems = 0;
    private ArrayList<JellyfinReportInventorySubItem> tagEpisodes = new ArrayList();

    public JellyfinReportTagsItem() {
        this.tagMediaItems = this.tagEpisodes.size();
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public ArrayList<JellyfinReportInventorySubItem> getTagEpisodes() {
        return tagEpisodes;
    }

    public void setTagEpisodes(ArrayList<JellyfinReportInventorySubItem> tagEpisodes) {
        this.tagEpisodes = tagEpisodes;
        this.tagMediaItems = this.tagEpisodes.size();
    }
    
    public void addTagEpisode(JellyfinReportInventorySubItem episode){
        this.tagEpisodes.add(episode);
        this.tagMediaItems = this.tagEpisodes.size();
    }

    public int getTagMediaItems() {
        return tagMediaItems;
    }

    public void setTagMediaItems() {
        this.tagMediaItems = this.tagEpisodes.size();
    }
    
    
    
}
