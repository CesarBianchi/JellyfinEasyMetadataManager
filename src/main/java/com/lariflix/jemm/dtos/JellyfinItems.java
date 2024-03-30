package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * This class represents the items in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinPeopleItem
 * @see JellyfinStudioItem
 * @see JellyfinGenreItem
 */
public class JellyfinItems {

    @JsonProperty("Items") 
    public ArrayList<JellyfinItem> items;
    @JsonProperty("TotalRecordCount") 
    public int totalRecordCount;
    @JsonProperty("StartIndex") 
    public int startIndex;
    

    /**
     * Default constructor for JellyfinItems.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinItems() {
    }

    /**
     * Returns the items in Jellyfin.
     *
     * @return The items in Jellyfin.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinItem> getItems() {
        return items;
    }

    /**
     * Sets the items in Jellyfin.
     *
     * @param items The new items in Jellyfin.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setItems(ArrayList<JellyfinItem> items) {
        this.items = items;
        totalRecordCount = items.size();        
    }

    /**
     * Returns the total record count.
     *
     * @return The total record count.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getTotalRecordCount() {
        totalRecordCount = items.size();
        return totalRecordCount;
    }

    /**
     * Sets the total record count.
     *
     * @param totalRecordCount The new total record count.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    /**
     * Returns the start index.
     *
     * @return The start index.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Sets the start index.
     *
     * @param startIndex The new start index.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    
}
