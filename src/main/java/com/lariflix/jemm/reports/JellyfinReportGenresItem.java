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

import com.lariflix.jemm.dtos.JellyfinCadGenresItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportGenresItem extends JellyfinCadGenresItem{

    private JellyfinItemMetadata genreMetadata = new JellyfinItemMetadata();
    
    public JellyfinReportGenresItem() {
    }
    
    public void setItem(JellyfinCadGenresItem it){
        this.name = it.getName();
        this.serverId = it.getServerId();
        this.id = it.getId();        
        this.channelId = it.getChannelId();
        this.type = it.getType();
        this.locationType = it.getLocationType();
        this.premiereDate = it.getPremiereDate();
        this.criticRating = it.getCriticRating();
        this.officialRating = it.getOfficialRating();
        this.communityRating = it.getCommunityRating();        
    }

    public JellyfinItemMetadata getGenreMetadata() {
        return genreMetadata;
    }

    public void setGenreMetadata(JellyfinItemMetadata genreMetadata) {
        this.genreMetadata = genreMetadata;
    }
    
    
    
}
