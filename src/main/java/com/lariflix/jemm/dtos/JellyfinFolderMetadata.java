
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents the metadata for a Jellyfin folder.
 * It is used to store and manage information related to the metadata of a specific folder in the Jellyfin server.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinFolderMetadata {
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("SortName") 
    public String sortName;
    @JsonProperty("ForcedSortName") 
    public String forcedSortName;
    @JsonProperty("ServerId") 
    public String serverId;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("Etag") 
    public String etag;
    @JsonProperty("DateCreated") 
    public Date dateCreated;
    @JsonProperty("CanDelete") 
    public boolean canDelete;
    @JsonProperty("CanDownload") 
    public boolean canDownload;
    @JsonProperty("PreferredMetadataLanguage") 
    public String preferredMetadataLanguage;
    @JsonProperty("PreferredMetadataCountryCode") 
    public String preferredMetadataCountryCode; 
    @JsonProperty("PremiereDate") 
    public Date premiereDate;
    @JsonProperty("ExternalUrls") 
    public ArrayList<Object> externalUrls;
    @JsonProperty("Path") 
    public String path;
    @JsonProperty("EnableMediaSourceDisplay") 
    public boolean enableMediaSourceDisplay;
    @JsonProperty("OfficialRating") 
    public String officialRating;
    @JsonProperty("CustomRating") 
    public String customRating;
    @JsonProperty("ChannelId") 
    public Object channelId;
    @JsonProperty("Overview") 
    public String overview;
    @JsonProperty("Taglines") 
    public ArrayList<Object> taglines;
    @JsonProperty("CommunityRating") 
    public int communityRating;
    @JsonProperty("PlayAccess") 
    public String playAccess;
    @JsonProperty("ProductionYear") 
    public int productionYear;
    @JsonProperty("RemoteTrailers") 
    public ArrayList<Object> remoteTrailers;
    @JsonProperty("IsFolder") 
    public boolean isFolder;
    @JsonProperty("ParentId") 
    public String parentId;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("People") 
    public ArrayList<JellyfinPeopleItem> people;
    @JsonProperty("Studios") 
    public ArrayList<JellyfinStudioItem> studios;
    @JsonProperty("GenreItems") 
    public ArrayList<JellyfinGenreItem> genreItems;
    @JsonProperty("LocalTrailerCount") 
    public int localTrailerCount;
    @JsonProperty("ChildCount") 
    public int childCount;
    @JsonProperty("SpecialFeatureCount") 
    public int specialFeatureCount;
    @JsonProperty("DisplayPreferencesId") 
    public String displayPreferencesId;
    @JsonProperty("Tags") 
    public ArrayList<String> tags;
    @JsonProperty("PrimaryImageAspectRatio") 
    public double primaryImageAspectRatio;
    @JsonProperty("CollectionType") 
    public String collectionType;
    @JsonProperty("BackdropImageTags") 
    public ArrayList<Object> backdropImageTags;
    @JsonProperty("LocationType") 
    public String locationType;
    @JsonProperty("LockedFields") 
    public ArrayList<Object> lockedFields;
    @JsonProperty("LockData") 
    public boolean lockData;

    public JellyfinFolderMetadata() {
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

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public boolean isCanDownload() {
        return canDownload;
    }

    public void setCanDownload(boolean canDownload) {
        this.canDownload = canDownload;
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

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getForcedSortName() {
        return forcedSortName;
    }

    public void setForcedSortName(String forcedSortName) {
        this.forcedSortName = forcedSortName;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public ArrayList<Object> getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ArrayList<Object> externalUrls) {
        this.externalUrls = externalUrls;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isEnableMediaSourceDisplay() {
        return enableMediaSourceDisplay;
    }

    public void setEnableMediaSourceDisplay(boolean enableMediaSourceDisplay) {
        this.enableMediaSourceDisplay = enableMediaSourceDisplay;
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

    public Object getChannelId() {
        return channelId;
    }

    public void setChannelId(Object channelId) {
        this.channelId = channelId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public ArrayList<Object> getTaglines() {
        return taglines;
    }

    public void setTaglines(ArrayList<Object> taglines) {
        this.taglines = taglines;
    }

    public int getCommunityRating() {
        return communityRating;
    }

    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }

    public String getPlayAccess() {
        return playAccess;
    }

    public void setPlayAccess(String playAccess) {
        this.playAccess = playAccess;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public ArrayList<Object> getRemoteTrailers() {
        return remoteTrailers;
    }

    public void setRemoteTrailers(ArrayList<Object> remoteTrailers) {
        this.remoteTrailers = remoteTrailers;
    }

    public boolean isIsFolder() {
        return isFolder;
    }

    public void setIsFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<JellyfinPeopleItem> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<JellyfinPeopleItem> people) {
        this.people = people;
    }

    public ArrayList<JellyfinStudioItem> getStudios() {
        return studios;
    }

    public void setStudios(ArrayList<JellyfinStudioItem> studios) {
        this.studios = studios;
    }

    public ArrayList<JellyfinGenreItem> getGenreItems() {
        return genreItems;
    }

    public void setGenreItems(ArrayList<JellyfinGenreItem> genreItems) {
        this.genreItems = genreItems;
    }

    public int getLocalTrailerCount() {
        return localTrailerCount;
    }

    public void setLocalTrailerCount(int localTrailerCount) {
        this.localTrailerCount = localTrailerCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public int getSpecialFeatureCount() {
        return specialFeatureCount;
    }

    public void setSpecialFeatureCount(int specialFeatureCount) {
        this.specialFeatureCount = specialFeatureCount;
    }

    public String getDisplayPreferencesId() {
        return displayPreferencesId;
    }

    public void setDisplayPreferencesId(String displayPreferencesId) {
        this.displayPreferencesId = displayPreferencesId;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public double getPrimaryImageAspectRatio() {
        return primaryImageAspectRatio;
    }

    public void setPrimaryImageAspectRatio(double primaryImageAspectRatio) {
        this.primaryImageAspectRatio = primaryImageAspectRatio;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public ArrayList<Object> getBackdropImageTags() {
        return backdropImageTags;
    }

    public void setBackdropImageTags(ArrayList<Object> backdropImageTags) {
        this.backdropImageTags = backdropImageTags;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public ArrayList<Object> getLockedFields() {
        return lockedFields;
    }

    public void setLockedFields(ArrayList<Object> lockedFields) {
        this.lockedFields = lockedFields;
    }

    public boolean isLockData() {
        return lockData;
    }

    public void setLockData(boolean lockData) {
        this.lockData = lockData;
    }
    
    
    
}
