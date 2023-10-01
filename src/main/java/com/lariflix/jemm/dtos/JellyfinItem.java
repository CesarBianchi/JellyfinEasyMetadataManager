package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author cesarbianchi
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
    

    public JellyfinItem() {
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

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public int getCriticRating() {
        return criticRating;
    }

    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
    }

    public String getOfficialRating() {
        return officialRating;
    }

    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    public int getCommunityRating() {
        return communityRating;
    }

    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public boolean isIsFolder() {
        return isFolder;
    }

    public void setIsFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public JellyfinItemMetadata getItemMetadata() {
        return itemMetadata;
    }

    public void setItemMetadata(JellyfinItemMetadata itemMetadata) {
        this.itemMetadata = itemMetadata;
    }
    
    
}
