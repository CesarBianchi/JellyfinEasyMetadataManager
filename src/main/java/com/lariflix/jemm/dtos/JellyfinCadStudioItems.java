package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinCadStudioItems {
    
    @JsonProperty("Items") 
    public ArrayList<JellyfinCadStudioItem> items;
    @JsonProperty("TotalRecordCount") 
    public int totalRecordCount;
    @JsonProperty("StartIndex") 
    public int startIndex;

    public JellyfinCadStudioItems() {
    }

    public ArrayList<JellyfinCadStudioItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<JellyfinCadStudioItem> items) {
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
