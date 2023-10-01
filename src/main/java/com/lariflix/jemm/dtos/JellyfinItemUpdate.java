package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cesarbianchi
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

    public JellyfinItemUpdate() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getForcedSortName() {
        return forcedSortName;
    }

    public void setForcedSortName(String forcedSortName) {
        this.forcedSortName = forcedSortName;
    }

    public int getCommunityRating() {
        return communityRating;
    }

    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }

    public int getCriticRating() {
        return criticRating;
    }

    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
    }

    public Object getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(Object indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getAirsBeforeSeasonNumber() {
        return airsBeforeSeasonNumber;
    }

    public void setAirsBeforeSeasonNumber(String airsBeforeSeasonNumber) {
        this.airsBeforeSeasonNumber = airsBeforeSeasonNumber;
    }

    public String getAirsAfterSeasonNumber() {
        return airsAfterSeasonNumber;
    }

    public void setAirsAfterSeasonNumber(String airsAfterSeasonNumber) {
        this.airsAfterSeasonNumber = airsAfterSeasonNumber;
    }

    public String getAirsBeforeEpisodeNumber() {
        return airsBeforeEpisodeNumber;
    }

    public void setAirsBeforeEpisodeNumber(String airsBeforeEpisodeNumber) {
        this.airsBeforeEpisodeNumber = airsBeforeEpisodeNumber;
    }

    public Object getParentIndexNumber() {
        return parentIndexNumber;
    }

    public void setParentIndexNumber(Object parentIndexNumber) {
        this.parentIndexNumber = parentIndexNumber;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<JellyfinStudioItem> getStudios() {
        return studios;
    }

    public void setStudios(ArrayList<JellyfinStudioItem> studios) {
        this.studios = studios;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getOfficialRating() {
        return officialRating;
    }

    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    public String getCustomRating() {
        return customRating;
    }

    public void setCustomRating(String customRating) {
        this.customRating = customRating;
    }

    public ArrayList<JellyfinPeopleItem> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<JellyfinPeopleItem> people) {
        this.people = people;
    }

    public boolean isLockData() {
        return lockData;
    }

    public void setLockData(boolean lockData) {
        this.lockData = lockData;
    }

    public ArrayList<Object> getLockedFields() {
        return lockedFields;
    }

    public void setLockedFields(ArrayList<Object> lockedFields) {
        this.lockedFields = lockedFields;
    }

    public String getPreferredMetadataLanguage() {
        return preferredMetadataLanguage;
    }

    public void setPreferredMetadataLanguage(String preferredMetadataLanguage) {
        this.preferredMetadataLanguage = preferredMetadataLanguage;
    }

    public String getPreferredMetadataCountryCode() {
        return preferredMetadataCountryCode;
    }

    public void setPreferredMetadataCountryCode(String preferredMetadataCountryCode) {
        this.preferredMetadataCountryCode = preferredMetadataCountryCode;
    }

    public ArrayList<Object> getTaglines() {
        return taglines;
    }

    public void setTaglines(ArrayList<Object> taglines) {
        this.taglines = taglines;
    }

    public JellyfinProviderIds getProviderIds() {
        return providerIds;
    }

    public void setProviderIds(JellyfinProviderIds providerIds) {
        this.providerIds = providerIds;
    }
    
    
    
}
