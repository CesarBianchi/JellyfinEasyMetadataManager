
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author cesarbianchi
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

    public JellyfinCadStudioItem() {
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

    public Object getChannelId() {
        return channelId;
    }

    public void setChannelId(Object channelId) {
        this.channelId = channelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
    
    
}
