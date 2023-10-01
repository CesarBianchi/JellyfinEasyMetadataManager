package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author cesarbianchi
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
    //@JsonProperty("PrimaryImageTag") 
    //public String primaryImageTag;

    public JellyfinPeopleItem() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
/*
    public String getPrimaryImageTag() {
        return primaryImageTag;
    }

    public void setPrimaryImageTag(String primaryImageTag) {
        this.primaryImageTag = primaryImageTag;
    }
*/
    
}
