package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents the updates to Jellyfin items.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinItem
 */
public class JellyfinItemUpdate {

    @JsonProperty("Id") 
    public String id;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("OriginalTitle") 
    public String originalTitle;
    @JsonProperty("ForcedSortName") 
    public String forcedSortName;
    @JsonProperty("CommunityRating") 
    public int communityRating;
    @JsonProperty("CriticRating") 
    public int criticRating;
    @JsonProperty("IndexNumber") 
    public Object indexNumber;
    @JsonProperty("AirsBeforeSeasonNumber") 
    public String airsBeforeSeasonNumber;
    @JsonProperty("AirsAfterSeasonNumber") 
    public String airsAfterSeasonNumber;
    @JsonProperty("AirsBeforeEpisodeNumber") 
    public String airsBeforeEpisodeNumber;
    @JsonProperty("ParentIndexNumber") 
    public Object parentIndexNumber;
    @JsonProperty("DisplayOrder") 
    public String displayOrder;
    @JsonProperty("Album") 
    public String album;
    @JsonProperty("Overview") 
    public String overview;
    @JsonProperty("Status") 
    public String status;
    @JsonProperty("Genres") 
    public ArrayList<String> genres;
    @JsonProperty("Tags") 
    public ArrayList<String> tags;
    @JsonProperty("Studios") 
    public ArrayList<JellyfinStudioItem> studios;
    @JsonProperty("PremiereDate") 
    public String premiereDate;
    @JsonProperty("DateCreated") 
    public String dateCreated;
    @JsonProperty("ProductionYear") 
    public int productionYear;

    @JsonProperty("OfficialRating") 
    public String officialRating;
    @JsonProperty("CustomRating") 
    public String customRating;
    @JsonProperty("People") 
    public ArrayList<JellyfinPeopleItem> people;
    @JsonProperty("LockData") 
    public boolean lockData;
    @JsonProperty("LockedFields") 
    public ArrayList<Object> lockedFields;
    
    @JsonProperty("PreferredMetadataLanguage") 
    public String preferredMetadataLanguage;
    @JsonProperty("PreferredMetadataCountryCode") 
    public String preferredMetadataCountryCode;
    @JsonProperty("Taglines") 
    public ArrayList<Object> taglines;
    
    @JsonProperty("ProviderIds") 
    public JellyfinProviderIds providerIds;

    /**
     * Default constructor for JellyfinItemUpdate.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinItemUpdate() {
    }

    /**
     * Returns the ID of the item.
     *
     * @return The ID of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the item.
     *
     * @param id The new ID of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name The new name of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the original title of the item.
     *
     * @return The original title of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * Sets the original title of the item.
     *
     * @param originalTitle The new original title of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * Returns the forced sort name of the item.
     *
     * @return The forced sort name of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getForcedSortName() {
        return forcedSortName;
    }

    /**
     * Sets the forced sort name of the item.
     *
     * @param forcedSortName The new forced sort name of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setForcedSortName(String forcedSortName) {
        this.forcedSortName = forcedSortName;
    }

    /**
     * Returns the community rating of the item.
     *
     * @return The community rating of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getCommunityRating() {
        return communityRating;
    }

    /**
     * Sets the community rating of the item.
     *
     * @param communityRating The new community rating of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }

    /**
     * Returns the critic rating of the item.
     *
     * @return The critic rating of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getCriticRating() {
        return criticRating;
    }

    /**
     * Sets the critic rating of the item.
     *
     * @param criticRating The new critic rating of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
    }

    /**
     * Returns the index number of the item.
     *
     * @return The index number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Object getIndexNumber() {
        return indexNumber;
    }

    /**
     * Sets the index number of the item.
     *
     * @param indexNumber The new index number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setIndexNumber(Object indexNumber) {
        this.indexNumber = indexNumber;
    }

    /**
     * Returns the airs before season number of the item.
     *
     * @return The airs before season number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getAirsBeforeSeasonNumber() {
        return airsBeforeSeasonNumber;
    }

    /**
     * Sets the airs before season number of the item.
     *
     * @param airsBeforeSeasonNumber The new airs before season number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setAirsBeforeSeasonNumber(String airsBeforeSeasonNumber) {
        this.airsBeforeSeasonNumber = airsBeforeSeasonNumber;
    }

    /**
     * Returns the airs after season number of the item.
     *
     * @return The airs after season number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getAirsAfterSeasonNumber() {
        return airsAfterSeasonNumber;
    }

    /**
     * Sets the airs after season number of the item.
     *
     * @param airsAfterSeasonNumber The new airs after season number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setAirsAfterSeasonNumber(String airsAfterSeasonNumber) {
        this.airsAfterSeasonNumber = airsAfterSeasonNumber;
    }

    /**
     * Returns the airs before episode number of the item.
     *
     * @return The airs before episode number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getAirsBeforeEpisodeNumber() {
        return airsBeforeEpisodeNumber;
    }

    /**
     * Sets the airs before episode number of the item.
     *
     * @param airsBeforeEpisodeNumber The new airs before episode number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setAirsBeforeEpisodeNumber(String airsBeforeEpisodeNumber) {
        this.airsBeforeEpisodeNumber = airsBeforeEpisodeNumber;
    }

    /**
     * Returns the parent index number of the item.
     *
     * @return The parent index number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Object getParentIndexNumber() {
        return parentIndexNumber;
    }

    /**
     * Sets the parent index number of the item.
     *
     * @param parentIndexNumber The new parent index number of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setParentIndexNumber(Object parentIndexNumber) {
        this.parentIndexNumber = parentIndexNumber;
    }

    /**
     * Returns the display order of the item.
     *
     * @return The display order of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getDisplayOrder() {
        return displayOrder;
    }

    /**
     * Sets the display order of the item.
     *
     * @param displayOrder The new display order of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * Returns the album of the item.
     *
     * @return The album of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Sets the album of the item.
     *
     * @param album The new album of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Returns the overview of the item.
     *
     * @return The overview of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Sets the overview of the item.
     *
     * @param overview The new overview of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * Returns the status of the item.
     *
     * @return The status of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the item.
     *
     * @param status The new status of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the genres of the item.
     *
     * @return The genres of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * Sets the genres of the item.
     *
     * @param genres The new genres of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     * Returns the tags of the item.
     *
     * @return The tags of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * Sets the tags of the item.
     *
     * @param tags The new tags of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    /**
     * Returns the studios of the item.
     *
     * @return The studios of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinStudioItem> getStudios() {
        return studios;
    }

    /**
     * Sets the studios of the item.
     *
     * @param studios The new studios of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setStudios(ArrayList<JellyfinStudioItem> studios) {
        this.studios = studios;
    }

    /**
     * Returns the premiere date of the item.
     *
     * @return The premiere date of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getPremiereDate() {
        return premiereDate;
    }

    /**
     * Sets the premiere date of the item.
     *
     * @param premiereDate The new premiere date of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    /**
     * Returns the date created of the item.
     *
     * @return The date created of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the date created of the item.
     *
     * @param dateCreated The new date created of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Returns the production year of the item.
     *
     * @return The production year of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * Sets the production year of the item.
     *
     * @param productionYear The new production year of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    /**
     * Returns the official rating of the item.
     *
     * @return The official rating of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getOfficialRating() {
        return officialRating;
    }

    /**
     * Sets the official rating of the item.
     *
     * @param officialRating The new official rating of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    /**
     * Returns the custom rating of the item.
     *
     * @return The custom rating of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getCustomRating() {
        return customRating;
    }

    /**
     * Sets the custom rating of the item.
     *
     * @param customRating The new custom rating of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCustomRating(String customRating) {
        this.customRating = customRating;
    }

    /**
     * Returns the people of the item.
     *
     * @return The people of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinPeopleItem> getPeople() {
        return people;
    }

    /**
     * Sets the people of the item.
     *
     * @param people The new people of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPeople(ArrayList<JellyfinPeopleItem> people) {
        this.people = people;
    }

    /**
     * Returns the lock data status of the item.
     *
     * @return The lock data status of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isLockData() {
        return lockData;
    }

    /**
     * Sets the lock data status of the item.
     *
     * @param lockData The new lock data status of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLockData(boolean lockData) {
        this.lockData = lockData;
    }

    /**
     * Returns the locked fields of the item.
     *
     * @return The locked fields of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getLockedFields() {
        return lockedFields;
    }

    /**
     * Sets the locked fields of the item.
     *
     * @param lockedFields The new locked fields of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLockedFields(ArrayList<Object> lockedFields) {
        this.lockedFields = lockedFields;
    }

    /**
     * Returns the preferred metadata language of the item.
     *
     * @return The preferred metadata language of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getPreferredMetadataLanguage() {
        return preferredMetadataLanguage;
    }
    /**
     * Sets the preferred metadata language of the item.
     *
     * @param preferredMetadataLanguage The new preferred metadata language of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPreferredMetadataLanguage(String preferredMetadataLanguage) {
        this.preferredMetadataLanguage = preferredMetadataLanguage;
    }

    /**
     * Returns the preferred metadata country code of the item.
     *
     * @return The preferred metadata country code of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getPreferredMetadataCountryCode() {
        return preferredMetadataCountryCode;
    }

    /**
     * Sets the preferred metadata country code of the item.
     *
     * @param preferredMetadataCountryCode The new preferred metadata country code of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPreferredMetadataCountryCode(String preferredMetadataCountryCode) {
        this.preferredMetadataCountryCode = preferredMetadataCountryCode;
    }

    /**
     * Returns the taglines of the item.
     *
     * @return The taglines of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getTaglines() {
        return taglines;
    }

    /**
     * Sets the taglines of the item.
     *
     * @param taglines The new taglines of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setTaglines(ArrayList<Object> taglines) {
        this.taglines = taglines;
    }

    /**
     * Returns the provider IDs of the item.
     *
     * @return The provider IDs of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinProviderIds getProviderIds() {
        return providerIds;
    }

    /**
     * Sets the provider IDs of the item.
     *
     * @param providerIds The new provider IDs of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setProviderIds(JellyfinProviderIds providerIds) {
        this.providerIds = providerIds;
    }
    
    
}
