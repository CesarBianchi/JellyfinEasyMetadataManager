/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class JellyfinUsers {
    @JsonProperty("Users") 
    List<JellyfinUser> Users = new ArrayList<>();

    public JellyfinUsers() {
    }

    public List<JellyfinUser> getUsers() {
        return Users;
    }

    public void setUsers(List<JellyfinUser> Users) {
        this.Users = Users;
    }
    
    
}
