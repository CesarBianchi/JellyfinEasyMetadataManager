package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a person involved in a media item in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinPeopleItem {

    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("Role") 
    public String role;
    @JsonProperty("Type") 
    public String type;

    /**
     * Default constructor for JellyfinPeopleItem.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinPeopleItem() {
    }

    /**
     * Returns the name of the person.
     *
     * @return The name of the person.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name of the person.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the person.
     *
     * @return The ID of the person.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the person.
     *
     * @param id The new ID of the person.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the role of the person.
     *
     * @return The role of the person.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the person.
     *
     * @param role The new role of the person.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns the type of the person.
     *
     * @return The type of the person.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the person.
     *
     * @param type The new type of the person.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setType(String type) {
        this.type = type;
    }
    
}
