package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * This class represents a people item in the Jellyfin catalog.
 * It is used to store and manage information related to a specific people item.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinCadPeopleItems {
    @JsonProperty("Items") 
    public ArrayList<JellyfinCadPeopleItem> items;
    @JsonProperty("TotalRecordCount") 
    public int totalRecordCount;
    @JsonProperty("StartIndex") 
    public int startIndex;

    public JellyfinCadPeopleItems() {
    }

    /**
     * Returns the items.
     *
     * @return the items
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinCadPeopleItem> getItems() {
        return items;
    }

    /**
     * Sets the items.
     *
     * @param items the new items
     * @author Cesar Bianchi
     */
    public void setItems(ArrayList<JellyfinCadPeopleItem> items) {
        this.items = items;
    }

    /**
     * Returns the total record count.
     *
     * @return the total record count
     * @author Cesar Bianchi
     */
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     * Sets the total record count.
     *
     * @param totalRecordCount the new total record count
     * @author Cesar Bianchi
     */
    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    /**
     * Returns the start index.
     *
     * @return the start index
     * @author Cesar Bianchi
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Sets the start index.
     *
     * @param startIndex the new start index
     * @author Cesar Bianchi
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    
    
}
