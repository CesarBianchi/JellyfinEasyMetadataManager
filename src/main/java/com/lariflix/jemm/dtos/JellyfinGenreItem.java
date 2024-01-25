package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the JellyfinGenreItem.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinItems
 * @see JellyfinGenre
 * @see JellyfinGenreItem
 * @see JellyfinGenreItems
 * @see JellyfinGenreResponse
 */
public class JellyfinGenreItem {

    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Id") 
    public String id;

    /**
     * Default constructor for JellyfinGenreItem.
     *
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinGenreItem() {
    }

    /**
     * Gets the name.
     *
     * @return A string representing the name.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name A string containing the new name.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the id.
     *
     * @return A string representing the id.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id A string containing the new id.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
