package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * This class represents a collection of studio items in the Jellyfin catalog.
 * It is used to store and manage a list of JellyfinCadStudioItem objects.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinCadStudioItem
 */
public class JellyfinCadStudioItems {
    
    @JsonProperty("Items") 
    public ArrayList<JellyfinCadStudioItem> items;
    @JsonProperty("TotalRecordCount") 
    public int totalRecordCount;
    @JsonProperty("StartIndex") 
    public int startIndex;

    /**
     * Default constructor for JellyfinCadStudioItems.
     */
    public JellyfinCadStudioItems() {
    }

    /**
     * Retrieves the list of JellyfinCadStudioItem objects.
     * 
     * @return The list of JellyfinCadStudioItem objects.
     * @author Cesar Bianchi
     * @since 1.0
     * 
     */
    public ArrayList<JellyfinCadStudioItem> getItems() {
        return items;
    }

    /**
     * Sets the list of JellyfinCadStudioItem objects.
     * 
     * @param items The list of JellyfinCadStudioItem objects.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setItems(ArrayList<JellyfinCadStudioItem> items) {
        this.items = items;
    }

    /**
     * Retrieves the total record count.
     * 
     * @return The total record count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     * Sets the total record count.
     * 
     * @param totalRecordCount The total record count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    /**
     * Retrieves the start index.
     * 
     * @return The start index.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Sets the start index.
     * 
     * @param startIndex The start index.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
        
}
