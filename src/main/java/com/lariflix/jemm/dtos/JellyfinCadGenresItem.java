package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Represents a genre item in Jellyfin.
 * This class is used to map the JSON response from the Jellyfin API to a Java object.
 * 
 * @since 1.0
 * @author Cesar Bianchi
 * @see com.lariflix.jemm.dtos.JellyfinCadGenresItem
* 
 */
public class JellyfinCadGenresItem {
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
    @JsonProperty("PremiereDate") 
    public Date premiereDate;
    @JsonProperty("CriticRating") 
    public int criticRating;
    @JsonProperty("OfficialRating") 
    public String officialRating;
    @JsonProperty("CommunityRating") 
    public int communityRating;

    /**
     * Constructs a new JellyfinCadGenresItem object.
     * 
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinCadGenresItem() {
    }

    /**
     * Gets the name of the genre.
     * 
     * @return The name of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the genre.
     * 
     * @param name The name of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the server ID of the genre.
     * 
     * @return The server ID of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the server ID of the genre.
     * 
     * @param serverId The server ID of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * Gets the ID of the genre.
     * 
     * @return The ID of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the genre.
     * 
     * @param id The ID of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the channel ID of the genre.
     * 
     * @return The channel ID of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Object getChannelId() {
        return channelId;
    }

    /**
     * Sets the channel ID of the genre.
     * 
     * @param channelId The channel ID of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setChannelId(Object channelId) {
        this.channelId = channelId;
    }

    /**
     * Gets the type of the genre.
     * 
     * @return The type of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the genre.
     * 
     * @param type The type of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the location type of the genre.
     * 
     * @return The location type of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Sets the location type of the genre.
     * 
     * @param locationType The location type of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    /**
     * Gets the premiere date of the genre.
     * 
     * @return The premiere date of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Date getPremiereDate() {
        return premiereDate;
    }

    /**
     * Sets the premiere date of the genre.
     * 
     * @param premiereDate The premiere date of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    /**
     * Gets the critic rating of the genre.
     * 
     * @return The critic rating of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getCriticRating() {
        return criticRating;
    }

    /**
     * Sets the critic rating of the genre.
     * 
     * @param criticRating The critic rating of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
    }

    /**
     * Gets the official rating of the genre.
     * 
     * @return The official rating of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getOfficialRating() {
        return officialRating;
    }

    /**
     * Sets the official rating of the genre.
     * 
     * @param officialRating The official rating of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    /**
     * Gets the community rating of the genre.
     * 
     * @return The community rating of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getCommunityRating() {
        return communityRating;
    }

    /**
     * Sets the community rating of the genre.
     * 
     * @param communityRating The community rating of the genre.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }
}
