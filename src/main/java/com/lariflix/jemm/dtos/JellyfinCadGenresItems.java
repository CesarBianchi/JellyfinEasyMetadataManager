package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * Represents a collection of JellyfinCadGenresItem objects.
 * 
 * @version 1.0.0
 * @since 1.0.0
 * @see JellyfinCadGenresItem
 * @author Cesar Bianchi
 */
public class JellyfinCadGenresItems {
    @JsonProperty("Items") 
    public ArrayList<JellyfinCadGenresItem> items;
    @JsonProperty("TotalRecordCount") 
    public int totalRecordCount;
    @JsonProperty("StartIndex") 
    public int startIndex;

    /**
     * Constructs a new JellyfinCadGenresItems object with the specified items, total record count, and start index.
     * 
     * @param items The list of JellyfinCadGenresItem objects.
     * @param totalRecordCount The total number of records.
     * @param startIndex The start index of the records.
     * @author Cesar Bianchi
     */
    public JellyfinCadGenresItems(ArrayList<JellyfinCadGenresItem> items, int totalRecordCount, int startIndex) {
        this.items = items;
        this.totalRecordCount = totalRecordCount;
        this.startIndex = startIndex;
    }

    /**
     * Constructs a new empty JellyfinCadGenresItems object.
     * @author Cesar Bianchi
     */
    public JellyfinCadGenresItems() {
    }

    /**
     * Gets the list of JellyfinCadGenresItem objects.
     * 
     * @return The list of JellyfinCadGenresItem objects.
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinCadGenresItem> getItems() {
        return items;
    }

    /**
     * Sets the list of JellyfinCadGenresItem objects.
     * 
     * @param items The list of JellyfinCadGenresItem objects.
     * @author Cesar Bianchi
     */
    public void setItems(ArrayList<JellyfinCadGenresItem> items) {
        this.items = items;
    }

    /**
     * Gets the total number of records.
     * 
     * @return The total number of records.
     * @author Cesar Bianchi
     */
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     * Sets the total number of records.
     * 
     * @param totalRecordCount The total number of records.
     * @author Cesar Bianchi
     */
    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    /**
     * Gets the start index of the records.
     * 
     * @return The start index of the records.
     * @author Cesar Bianchi
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Sets the start index of the records.
     * 
     * @param startIndex The start index of the records.
     * @author Cesar Bianchi
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
