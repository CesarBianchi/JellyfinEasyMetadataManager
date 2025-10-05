package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a studio involved in a media item in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinStudioItem {

    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Id") 
    public String id;

    /**
     * Default constructor for JellyfinStudioItem.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinStudioItem() {
    }

    /**
     * Returns the name of the studio.
     *
     * @return The name of the studio.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the studio.
     *
     * @param name The new name of the studio.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the studio.
     *
     * @return The ID of the studio.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the studio.
     *
     * @param id The new ID of the studio.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
