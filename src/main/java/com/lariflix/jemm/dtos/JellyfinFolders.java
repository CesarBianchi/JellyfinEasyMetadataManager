package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;


/**
 * This class represents the JellyfinFolders.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinFolders {
    @JsonProperty("Items") 
    public ArrayList<JellyfinFolder> items;
    @JsonProperty("TotalRecordCount") 
    public int totalRecordCount;
    @JsonProperty("StartIndex") 
    public int startIndex;

    /**
     * Default constructor for JellyfinFolders.
     *
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinFolders() {
    }

    /**
     * Gets the items.
     *
     * @return An ArrayList of JellyfinFolder objects representing the items.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<JellyfinFolder> getItems() {
        return items;
    }

    /**
     * Sets the items.
     *
     * @param items An ArrayList of JellyfinFolder objects containing the new items.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setItems(ArrayList<JellyfinFolder> items) {
        this.items = items;
    }

    /**
     * Gets the total record count.
     *
     * @return An integer representing the total record count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     * Sets the total record count.
     *
     * @param totalRecordCount An integer containing the new total record count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    /**
     * Gets the start index.
     *
     * @return An integer representing the start index.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Sets the start index.
     *
     * @param startIndex An integer containing the new start index.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    
    
}
