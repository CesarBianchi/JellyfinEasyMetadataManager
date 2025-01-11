package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lariflix.jemm.utils.TransformDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a folder in the Jellyfin server.
 * It is used to store and manage information related to a specific folder in the Jellyfin server.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinFolderMetadata
 * @see JellyfinItems
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
    
    private int folderLevel = 1;
    
    /**
     * Default constructor for the JellyfinFolder class.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinFolder() {
    }

    /**
     * Gets the name of the folder.
     * 
     * @return The name of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the folder.
     * 
     * @param name The name to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the server ID of the folder.
     * 
     * @return The server ID of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the server ID of the folder.
     * 
     * @param serverId The server ID to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * Gets the ID of the folder.
     * 
     * @return The ID of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the folder.
     * 
     * @param id The ID to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the premiere date of the folder.
     * 
     * @return The premiere date of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public Date getPremiereDate() {
        return premiereDate;
    }

    /**
     * Sets the premiere date of the folder.
     * 
     * @param premiereDate The premiere date to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }
    /**
     * Gets the critic rating of the folder.
     * 
     * @return The critic rating of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getCriticRating() {
        return criticRating;
    }

    /**
     * Sets the critic rating of the folder.
     * 
     * @param criticRating The critic rating to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
    }

    /**
     * Gets the official rating of the folder.
     * 
     * @return The official rating of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getOfficialRating() {
        return officialRating;
    }

    /**
     * Sets the official rating of the folder.
     * 
     * @param officialRating The official rating to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    /**
     * Gets the channel ID of the folder.
     * 
     * @return The channel ID of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public Object getChannelId() {
        return channelId;
    }
    /**
     * Sets the channel ID of the folder.
     * 
     * @param channelId The channel ID to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setChannelId(Object channelId) {
        this.channelId = channelId;
    }

    /**
     * Gets the community rating of the folder.
     * 
     * @return The community rating of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getCommunityRating() {
        return communityRating;
    }

    /**
     * Sets the community rating of the folder.
     * 
     * @param communityRating The community rating to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }

    /**
     * Gets the production year of the folder.
     * 
     * @return The production year of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * Sets the production year of the folder.
     * 
     * @param productionYear The production year to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    /**
     * Checks if the item is a folder.
     * 
     * @return True if the item is a folder, false otherwise.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public boolean IsFolder() {
        return isFolder;
    }

    /**
     * Sets the folder status of the item.
     * 
     * @param isFolder The folder status to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setIsFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }

    /**
     * Gets the type of the item.
     * 
     * @return The type of the item.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the item.
     * 
     * @param type The type to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the collection type of the item.
     * 
     * @return The collection type of the item.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getCollectionType() {
        return collectionType;
    }

    /**
     * Sets the collection type of the item.
     * 
     * @param collectionType The collection type to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    /**
     * Gets the location type of the folder.
     * 
     * @return The location type of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Sets the location type of the folder.
     * 
     * @param locationType The location type to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    /**
     * Gets the metadata of the folder.
     * 
     * @return The metadata of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinFolderMetadata getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata of the folder.
     * 
     * @param metadata The metadata to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setMetadata(JellyfinFolderMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * Gets the content of the folder.
     * 
     * @return The content of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinItems getFolderContent() {
        return folderContent;
    }

    /**
     * Sets the content of the folder.
     * 
     * @param items The content to be set.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setFolderContent(JellyfinItems items) {
        this.folderContent = items;
    }

    public int getFolderLevel() {
        return folderLevel;
    }

    public void setFolderLevel(int folderLevel) {
        this.folderLevel = folderLevel;
    }

    public void mySetProductionYear(String prdYear) {
        this.productionYear = Integer.parseInt(prdYear);
    }

    public void mySetCommunityRating(String rating) {
        this.communityRating = Integer.parseInt(rating);
    }

    public void mySetCriticRating(String rating) {
        this.criticRating = Integer.parseInt(rating);
    }

    public void mySetPremiereDate(String date) {
        try {
            this.premiereDate = new TransformDateFormat().getFullDateFromSimple(date);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinFolder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}