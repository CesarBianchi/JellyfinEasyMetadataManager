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

import com.lariflix.jemm.dtos.JellyfinCadPeopleItem;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportPeopleItem extends JellyfinCadPeopleItem {

    private ArrayList<JellyfinReportInventorySubItem> peopleEpisodes = new ArrayList();
    private JellyfinItemMetadata peopleMetadata = new JellyfinItemMetadata();
    private String peoplePlace = new String();
    
    public JellyfinReportPeopleItem() {
    }

    public void setItem(JellyfinCadPeopleItem people){        
        this.setName(people.getName());
        this.setServerId(people.getServerId());
        this.setId(people.getId());
        this.setPremiereDate(people.getPremiereDate());
        this.setCriticRating(people.getCriticRating());
        this.setOfficialRating(people.getOfficialRating());
        this.setChannelId(people.getChannelId());
        this.setCommunityRating(people.getCommunityRating());
        this.setProductionYear(people.getProductionYear());
        this.setType(people.getType());
        this.setLocationType(people.getLocationType());        
    }

    public JellyfinItemMetadata getPeopleMetadata() {
        return peopleMetadata;
    }

    public void setPeopleMetadata(JellyfinItemMetadata peopleMetadata) {
        this.peopleMetadata = peopleMetadata;
        
        if ((peopleMetadata.getProductionlocations() != null) && (peopleMetadata.getProductionlocations().size() > 0)){
            this.peoplePlace = peopleMetadata.getProductionlocations().get(0);
        }
        
    }
    
    public void addPeopleEpisode(JellyfinItem episode, JellyfinItemMetadata episodeMetadata){
        
        JellyfinReportInventorySubItem eps = new JellyfinReportInventorySubItem();
        eps.setSubItem(episode);
        eps.setSubItemMetadata(episodeMetadata);
        
        this.peopleEpisodes.add(eps);        
    }

    public ArrayList<JellyfinReportInventorySubItem> getPeopleEpisodes() {
        return peopleEpisodes;
    }

    public void setPeopleEpisodes(ArrayList<JellyfinReportInventorySubItem> peopleEpisodes) {
        this.peopleEpisodes = peopleEpisodes;
    }

    public String getPeoplePlace() {
        return peoplePlace;
    }

    public void setPeoplePlace(String peoplePlace) {
        this.peoplePlace = peoplePlace;
    }
    
    
    
}

