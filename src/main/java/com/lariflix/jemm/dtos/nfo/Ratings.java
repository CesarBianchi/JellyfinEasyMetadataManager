/*
 * Copyright (C) 2026 cesarbianchi
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
package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesarbianchi
 */
@JacksonXmlRootElement(localName = "ratings")
public class Ratings { 
    
    
    @JacksonXmlProperty(localName = "rating")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Rating> rating;
    

    public Ratings() {
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(ArrayList<Rating> ratings) {
        this.rating = ratings;
    }
    
    public void addRating(Rating rating){
        this.rating.add(rating);
    }
}
