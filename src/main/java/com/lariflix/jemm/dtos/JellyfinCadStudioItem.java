
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a studio item in the Jellyfin catalog.
 * It is used to store and manage information related to a specific studio item.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinCadStudioItem {
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("ServerId") 
    public String serverId;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("ChannelId") 
    public Object channelId;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("LocationType") 
    public String locationType;

    /**
     * Constructs a new JellyfinCadStudioItem object.
     */
    public JellyfinCadStudioItem() {
    }
    
    /**
     * Gets the name of the Jellyfin Cad Studio item.
     * 
     * @return the name of the item
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Jellyfin Cad Studio item.
     * 
     * @param name the name of the item
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the server ID of the Jellyfin Cad Studio item.
     * 
     * @return the server ID of the item
     * @since 1.0
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the server ID of the Jellyfin Cad Studio item.
     * 
     * @param serverId the server ID of the item
     * @since 1.0
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * Gets the ID of the Jellyfin Cad Studio item.
     * 
     * @return the ID of the item
     * @since 1.0
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the Jellyfin Cad Studio item.
     * 
     * @param id the ID of the item
     * @since 1.0
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the channel ID of the Jellyfin Cad Studio item.
     * 
     * @return the channel ID of the item
     * @since 1.0
     */
    public Object getChannelId() {
        return channelId;
    }

    /**
     * Sets the channel ID of the Jellyfin Cad Studio item.
     * 
     * @param channelId the channel ID of the item
     * @since 1.0
     */
    public void setChannelId(Object channelId) {
        this.channelId = channelId;
    }

    /**
     * Gets the type of the Jellyfin Cad Studio item.
     * 
     * @return the type of the item
     * @since 1.0
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the Jellyfin Cad Studio item.
     * 
     * @param type the type of the item
     * @since 1.0
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the location type of the Jellyfin Cad Studio item.
     * 
     * @return the location type of the item
     * @since 1.0
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Sets the location type of the Jellyfin Cad Studio item.
     * 
     * @param locationType the location type of the item
     * @since 1.0
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}
