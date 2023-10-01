package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinGenreItem {
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Id") 
    public String id;

    public JellyfinGenreItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
