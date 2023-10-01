package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinItems {
    @JsonProperty("Items") 
    public ArrayList<JellyfinItem> items;
    @JsonProperty("TotalRecordCount") 
    public int totalRecordCount;
    @JsonProperty("StartIndex") 
    public int startIndex;

    public JellyfinItems() {
    }

    public ArrayList<JellyfinItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<JellyfinItem> items) {
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
