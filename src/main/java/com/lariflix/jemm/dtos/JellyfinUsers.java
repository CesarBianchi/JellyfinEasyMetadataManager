package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the users in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinUser
 */
public class JellyfinUsers {

    @JsonProperty("Users") 
    List<JellyfinUser> Users = new ArrayList<>();

    /**
     * Constructor for the JellyfinUsers class.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinUsers() {
    }

    /**
     * Returns the list of Jellyfin users.
     *
     * @return The list of Jellyfin users.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public List<JellyfinUser> getUsers() {
        return Users;
    }

    /**
     * Sets the list of Jellyfin users.
     *
     * @param Users The new list of Jellyfin users.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setUsers(List<JellyfinUser> Users) {
        this.Users = Users;
    }
    
    
}
