package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinCadGenresItems {
    @JsonProperty("Items") 
    public ArrayList<JellyfinCadGenresItem> items;
    @JsonProperty("TotalRecordCount") 
    public int totalRecordCount;
    @JsonProperty("StartIndex") 
    public int startIndex;

    public JellyfinCadGenresItems() {
    }

    public ArrayList<JellyfinCadGenresItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<JellyfinCadGenresItem> items) {
        this.items = items;
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

   
    
}
