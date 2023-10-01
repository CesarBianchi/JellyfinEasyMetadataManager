package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinFolder {

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
    @JsonProperty("IsFolder") 
    public boolean isFolder;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("CollectionType") 
    public String collectionType;
    @JsonProperty("BackdropImageTags") 
    public ArrayList<Object> backdropImageTags;
    @JsonProperty("LocationType") 
    public String locationType;

    public JellyfinFolderMetadata metadata;
    public JellyfinItems folderContent;
    
    public JellyfinFolder() {
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

    public Object getChannelId() {
        return channelId;
    }

    public void setChannelId(Object channelId) {
        this.channelId = channelId;
    }

    public int getCommunityRating() {
        return communityRating;
    }

    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
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

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public JellyfinFolderMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(JellyfinFolderMetadata metadata) {
        this.metadata = metadata;
    }

    public JellyfinItems getFolderContent() {
        return folderContent;
    }

    public void setFolderContent(JellyfinItems items) {
        this.folderContent = items;
    }
    
    
    
}