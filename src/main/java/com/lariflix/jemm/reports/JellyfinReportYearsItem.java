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
public class JellyfinReportYearsItem {
    
    private String year = new String();
    private int yearMediaItems = 0;
    private ArrayList<JellyfinReportInventorySubItem> yearEpisodes = new ArrayList();
    
    public JellyfinReportYearsItem() {
        this.yearMediaItems = this.yearEpisodes.size();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String yearName) {
        this.year = yearName;
    }

    public ArrayList<JellyfinReportInventorySubItem> getYearEpisodes() {
        return yearEpisodes;
    }

    public void setYearEpisodes(ArrayList<JellyfinReportInventorySubItem> yearEpisodes) {
        this.yearEpisodes = yearEpisodes;
        this.yearMediaItems = this.yearEpisodes.size();
    }
    
    public void addYearEpisode(JellyfinReportInventorySubItem episode){
        this.yearEpisodes.add(episode);
        this.yearMediaItems = this.yearEpisodes.size();
    }

    public int getYearMediaItems() {
        return yearMediaItems;
    }

    public void setYearMediaItems() {
        this.yearMediaItems = this.yearEpisodes.size();
    }
    
}
