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
package com.lariflix.jemm.utils;

import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinRatingList {
    private ArrayList<String> ratings = new ArrayList<>();
    
    public void JellyfinRatingList(){
        this.loadRatings();
    }
    
    public void loadRatings() {
        
        ratings.add("");
        ratings.add("Unrated");
        ratings.add("Approved");
        ratings.add("G");
        ratings.add("TV-G");
        ratings.add("TV-Y");
        ratings.add("TV-Y7");
        ratings.add("TV-Y7-FV");
        ratings.add("PG");
        ratings.add("TV-PG");
        ratings.add("TV-PG-D");
        ratings.add("TV-PG-L");
        ratings.add("TV-PG-S");
        ratings.add("TV-PG-V");
        ratings.add("TV-PG-DL");
        ratings.add("TV-PG-DS");
        ratings.add("TV-PG-DV");
        ratings.add("TV-PG-LS");
        ratings.add("TV-PG-LV");
        ratings.add("TV-PG-SV");
        ratings.add("TV-PG-DLS");
        ratings.add("TV-PG-DLV");
        ratings.add("TV-PG-DSV");
        ratings.add("TV-PG-LSV");
        ratings.add("TV-PG-DLSV");
        ratings.add("PG-13");
        ratings.add("TV-14");
        ratings.add("TV-14-D");
        ratings.add("TV-14-L");
        ratings.add("TV-14-S");
        ratings.add("TV-14-V");
        ratings.add("TV-14-DL");
        ratings.add("TV-14-DS");
        ratings.add("TV-14-DV");
        ratings.add("TV-14-LS");
        ratings.add("TV-14-LV");
        ratings.add("TV-14-SV");
        ratings.add("TV-14-DLS");
        ratings.add("TV-14-DLV");
        ratings.add("TV-14-DSV");
        ratings.add("TV-14-LSV");
        ratings.add("TV-14-DLSV");
        ratings.add("R");
        ratings.add("NC-17");
        ratings.add("TV-MA");
        ratings.add("TV-MA-L");
        ratings.add("TV-MA-S");
        ratings.add("TV-MA-V");
        ratings.add("TV-MA-LS");
        ratings.add("TV-MA-LV");
        ratings.add("TV-MA-SV");
        ratings.add("TV-MA-LSV");
        ratings.add("TV-X");
        ratings.add("BR-L");
        ratings.add("TV-AO");
        ratings.add("21");
        ratings.add("XXX");
        ratings.add("Banned");
    }

    public ArrayList<String> getRatings() {
        return ratings;
    }
   
    
    public String[] getItems() {    
        String[] items = this.ratings.toArray(new String[0]);
        return items;
    }
    
}
