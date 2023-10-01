/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinUser {
    @JsonProperty("PrimaryImageTag") 
    public String PrimaryImageTag;
    
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("ServerId") 
    public String serverId;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("HasPassword") 
    public boolean hasPassword;
    @JsonProperty("HasConfiguredPassword") 
    public boolean hasConfiguredPassword;
    @JsonProperty("HasConfiguredEasyPassword") 
    public boolean hasConfiguredEasyPassword;
    @JsonProperty("EnableAutoLogin") 
    public boolean enableAutoLogin;
    @JsonProperty("LastLoginDate") 
    public Date lastLoginDate;
    @JsonProperty("LastActivityDate") 
    public Date lastActivityDate;
    @JsonProperty("Configuration") 
    public JellyfinUserConfiguration configuration = new JellyfinUserConfiguration();
    @JsonProperty("Policy") 
    public JellyfinUserPolicy policy = new JellyfinUserPolicy();

    public JellyfinUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public boolean isHasConfiguredPassword() {
        return hasConfiguredPassword;
    }

    public void setHasConfiguredPassword(boolean hasConfiguredPassword) {
        this.hasConfiguredPassword = hasConfiguredPassword;
    }

    public boolean isHasConfiguredEasyPassword() {
        return hasConfiguredEasyPassword;
    }

    public void setHasConfiguredEasyPassword(boolean hasConfiguredEasyPassword) {
        this.hasConfiguredEasyPassword = hasConfiguredEasyPassword;
    }

    public boolean isEnableAutoLogin() {
        return enableAutoLogin;
    }

    public void setEnableAutoLogin(boolean enableAutoLogin) {
        this.enableAutoLogin = enableAutoLogin;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public JellyfinUserConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(JellyfinUserConfiguration configuration) {
        this.configuration = configuration;
    }

    public JellyfinUserPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(JellyfinUserPolicy policy) {
        this.policy = policy;
    }

    public String getPrimaryImageTag() {
        return PrimaryImageTag;
    }

    public void setPrimaryImageTag(String PrimaryImageTag) {
        this.PrimaryImageTag = PrimaryImageTag;
    }
    
    
    
}
