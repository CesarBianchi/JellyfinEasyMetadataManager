/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * This class represents a user in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinUserConfiguration
 * @see JellyfinUserPolicy
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

    /**
     * Default constructor for JellyfinUser.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinUser() {
    }

    /**
     * Returns the name of the user.
     *
     * @return The name of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The new name of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the server ID of the user.
     *
     * @return The server ID of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the server ID of the user.
     *
     * @param serverId The new server ID of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * Returns the ID of the user.
     *
     * @return The ID of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id The new ID of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns whether the user has a password.
     *
     * @return True if the user has a password, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isHasPassword() {
        return hasPassword;
    }

    /**
     * Sets whether the user has a password.
     *
     * @param hasPassword True if the user has a password, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    /**
     * Returns whether the user has a configured password.
     *
     * @return True if the user has a configured password, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isHasConfiguredPassword() {
        return hasConfiguredPassword;
    }

    /**
     * Sets whether the user has a configured password.
     *
     * @param hasConfiguredPassword True if the user has a configured password, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setHasConfiguredPassword(boolean hasConfiguredPassword) {
        this.hasConfiguredPassword = hasConfiguredPassword;
    }

    /**
     * Returns whether the user has a configured easy password.
     *
     * @return True if the user has a configured easy password, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isHasConfiguredEasyPassword() {
        return hasConfiguredEasyPassword;
    }

    /**
     * Sets whether the user has a configured easy password.
     *
     * @param hasConfiguredEasyPassword True if the user has a configured easy password, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setHasConfiguredEasyPassword(boolean hasConfiguredEasyPassword) {
        this.hasConfiguredEasyPassword = hasConfiguredEasyPassword;
    }

    /**
     * Returns whether auto login is enabled for the user.
     *
     * @return True if auto login is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableAutoLogin() {
        return enableAutoLogin;
    }

    /**
     * Sets whether auto login is enabled for the user.
     *
     * @param enableAutoLogin True to enable auto login, false to disable it.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableAutoLogin(boolean enableAutoLogin) {
        this.enableAutoLogin = enableAutoLogin;
    }
    /**
     * Returns the last login date of the user.
     *
     * @return The last login date of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * Sets the last login date of the user.
     *
     * @param lastLoginDate The new last login date of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * Returns the last activity date of the user.
     *
     * @return The last activity date of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     * Sets the last activity date of the user.
     *
     * @param lastActivityDate The new last activity date of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    /**
     * Returns the configuration of the user.
     *
     * @return The configuration of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinUserConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the configuration of the user.
     *
     * @param configuration The new configuration of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setConfiguration(JellyfinUserConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Returns the policy of the user.
     *
     * @return The policy of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinUserPolicy getPolicy() {
        return policy;
    }
    /**
     * Sets the policy of the user.
     *
     * @param policy The new policy of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPolicy(JellyfinUserPolicy policy) {
        this.policy = policy;
    }

    /**
     * Returns the primary image tag of the user.
     *
     * @return The primary image tag of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getPrimaryImageTag() {
        return PrimaryImageTag;
    }

    /**
     * Sets the primary image tag of the user.
     *
     * @param PrimaryImageTag The new primary image tag of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPrimaryImageTag(String PrimaryImageTag) {
        this.PrimaryImageTag = PrimaryImageTag;
    }
    
    
}
