package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * This class represents the JellyfinItem.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinItem {

    @JsonProperty("Name") 
    public String name;
    @JsonProperty("ServerId") 
    public String serverId;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("Container") 
    public String container;
    @JsonProperty("PremiereDate") 
    public Date premiereDate;
    @JsonProperty("CriticRating") 
    public int criticRating;
    @JsonProperty("OfficialRating") 
    public String officialRating;
    @JsonProperty("CommunityRating") 
    public int communityRating;
    @JsonProperty("AspectRatio") 
    public String aspectRatio;
    @JsonProperty("ProductionYear") 
    public int productionYear;
    @JsonProperty("IsFolder") 
    public boolean isFolder;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("videoType") 
    public String videoType;
    @JsonProperty("LocationType") 
    public String locationType;
    @JsonProperty("MediaType") 
    public String mediaType;
    
    public JellyfinItemMetadata itemMetadata;
    

    /**
     * Default constructor for JellyfinItem.
     *
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinItem() {
    }

    /**
     * Gets the name.
     *
     * @return A string representing the name.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name A string containing the new name.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the server id.
     *
     * @return A string representing the server id.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the server id.
     *
     * @param serverId A string containing the new server id.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * Gets the id.
     *
     * @return A string representing the id.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id A string containing the new id.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the container.
     *
     * @return A string representing the container.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getContainer() {
        return container;
    }

    /**
     * Sets the container.
     *
     * @param container A string containing the new container.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * Gets the premiere date.
     *
     * @return A Date object representing the premiere date.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public Date getPremiereDate() {
        return premiereDate;
    }

    /**
     * Sets the premiere date.
     *
     * @param premiereDate A Date object containing the new premiere date.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    /**
     * Gets the critic rating.
     *
     * @return An integer representing the critic rating.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getCriticRating() {
        return criticRating;
    }

    /**
     * Sets the critic rating.
     *
     * @param criticRating An integer containing the new critic rating.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
    }

    /**
     * Gets the official rating.
     *
     * @return A string representing the official rating.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getOfficialRating() {
        return officialRating;
    }

    /**
     * Sets the official rating.
     *
     * @param officialRating A string containing the new official rating.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    /**
     * Gets the community rating.
     *
     * @return An integer representing the community rating.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getCommunityRating() {
        return communityRating;
    }

    /**
     * Sets the community rating.
     *
     * @param communityRating An integer containing the new community rating.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }

    /**
     * Gets the aspect ratio.
     *
     * @return A string representing the aspect ratio.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * Sets the aspect ratio.
     *
     * @param aspectRatio A string containing the new aspect ratio.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * Gets the production year.
     *
     * @return An integer representing the production year.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * Sets the production year.
     *
     * @param productionYear An integer containing the new production year.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    /**
     * Checks if the item is a folder.
     *
     * @return A boolean indicating whether the item is a folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public boolean isIsFolder() {
        return isFolder;
    }

    /**
     * Sets whether the item is a folder.
     *
     * @param isFolder A boolean indicating the new folder status.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setIsFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }

    /**
     * Gets the type.
     *
     * @return A string representing the type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type A string containing the new type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the video type.
     *
     * @return A string representing the video type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getVideoType() {
        return videoType;
    }

    /**
     * Sets the video type.
     *
     * @param videoType A string containing the new video type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    /**
     * Gets the location type.
     *
     * @return A string representing the location type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Sets the location type.
     *
     * @param locationType A string containing the new location type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    /**
     * Gets the media type.
     *
     * @return A string representing the media type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets the media type.
     *
     * @param mediaType A string containing the new media type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * Gets the item metadata.
     *
     * @return A JellyfinItemMetadata object representing the item metadata.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinItemMetadata getItemMetadata() {
        return itemMetadata;
    }

    /**
     * Sets the item metadata.
     *
     * @param itemMetadata A JellyfinItemMetadata object containing the new item metadata.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setItemMetadata(JellyfinItemMetadata itemMetadata) {
        this.itemMetadata = itemMetadata;
    }
    
}
