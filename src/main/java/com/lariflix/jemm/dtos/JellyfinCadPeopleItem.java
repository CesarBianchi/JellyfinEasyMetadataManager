package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Represents a JellyfinCadPeopleItem object.
 * 
 * @version 1.0.0
 * @since 1.0.0
 * @author Cesar Bianchi
 * @see JellyfinCadPeopleItems
 */
public class JellyfinCadPeopleItem {
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("ServerId") 
    public String serverId;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("PremiereDate") 
    public Date premiereDate;
    @JsonProperty("CriticRating") 
    public int criticRating;
    @JsonProperty("OfficialRating") 
    public String officialRating;
    @JsonProperty("ChannelId") 
    public Object channelId;
    @JsonProperty("CommunityRating") 
    public int communityRating;
    @JsonProperty("ProductionYear") 
    public int productionYear;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("LocationType") 
    public String locationType;

    /**
     * Default constructor for the JellyfinCadPeopleItem class.
     * This constructor is used when creating a new instance of this class without setting any initial values.
     * 
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinCadPeopleItem() {
    }

    /**
     * Gets the name of the JellyfinCadPeopleItem.
     * 
     * @return the name of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the JellyfinCadPeopleItem.
     * 
     * @param name the name to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the server ID of the JellyfinCadPeopleItem.
     * 
     * @return the server ID of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the server ID of the JellyfinCadPeopleItem.
     * 
     * @param serverId the server ID to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * Gets the ID of the JellyfinCadPeopleItem.
     * 
     * @return the ID of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the JellyfinCadPeopleItem.
     * 
     * @param id the ID to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the premiere date of the JellyfinCadPeopleItem.
     * 
     * @return the premiere date of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Date getPremiereDate() {
        return premiereDate;
    }

    /**
     * Sets the premiere date of the JellyfinCadPeopleItem.
     * 
     * @param premiereDate the premiere date to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    /**
     * Gets the critic rating of the JellyfinCadPeopleItem.
     * 
     * @return the critic rating of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getCriticRating() {
        return criticRating;
    }

    /**
     * Sets the critic rating of the JellyfinCadPeopleItem.
     * 
     * @param criticRating the critic rating to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
    }

    /**
     * Gets the official rating of the JellyfinCadPeopleItem.
     * 
     * @return the official rating of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getOfficialRating() {
        return officialRating;
    }

    /**
     * Sets the official rating of the JellyfinCadPeopleItem.
     * 
     * @param officialRating the official rating to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    /**
     * Gets the channel ID of the JellyfinCadPeopleItem.
     * 
     * @return the channel ID of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Object getChannelId() {
        return channelId;
    }

    /**
     * Sets the channel ID of the JellyfinCadPeopleItem.
     * 
     * @param channelId the channel ID to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setChannelId(Object channelId) {
        this.channelId = channelId;
    }

    /**
     * Gets the community rating of the JellyfinCadPeopleItem.
     * 
     * @return the community rating of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getCommunityRating() {
        return communityRating;
    }

    /**
     * Sets the community rating of the JellyfinCadPeopleItem.
     * 
     * @param communityRating the community rating to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }

    /**
     * Gets the production year of the JellyfinCadPeopleItem.
     * 
     * @return the production year of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * Sets the production year of the JellyfinCadPeopleItem.
     * 
     * @param productionYear the production year to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    /**
     * Gets the type of the JellyfinCadPeopleItem.
     * 
     * @return the type of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the JellyfinCadPeopleItem.
     * 
     * @param type the type to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the location type of the JellyfinCadPeopleItem.
     * 
     * @return the location type of the JellyfinCadPeopleItem
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Sets the location type of the JellyfinCadPeopleItem.
     * 
     * @param locationType the location type to set
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}
