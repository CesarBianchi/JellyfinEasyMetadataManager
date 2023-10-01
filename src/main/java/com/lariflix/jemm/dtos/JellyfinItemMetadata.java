package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinItemMetadata {
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("OriginalTitle") 
    public String originalTitle;
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
    @JsonProperty("Container") 
    public String container;
    @JsonProperty("SortName") 
    public String sortName;
    @JsonProperty("ForcedSortName") 
    public String forcedSortName;
    @JsonProperty("PremiereDate") 
    public Date premiereDate;
    //@JsonProperty("MediaSources") 
    //public ArrayList<JellyfimMediaSource> mediaSources;
    @JsonProperty("CriticRating") 
    public int criticRating;
    @JsonProperty("Path") 
    public String path;
    @JsonProperty("EnableMediaSourceDisplay") 
    public boolean enableMediaSourceDisplay;
    @JsonProperty("OfficialRating") 
    public String officialRating;
    @JsonProperty("CustomRating") 
    public String customRating;
    @JsonProperty("Overview") 
    public String overview;
    @JsonProperty("Genres") 
    public ArrayList<String> genres;
    @JsonProperty("CommunityRating") 
    public int communityRating;
    @JsonProperty("RunTimeTicks") 
    public long runTimeTicks;
    @JsonProperty("PlayAccess") 
    public String playAccess;
    @JsonProperty("AspectRatio") 
    public String aspectRatio;
    @JsonProperty("ProductionYear") 
    public int productionYear;
    @JsonProperty("IsHD") 
    public boolean isHD;
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

    @JsonProperty("DisplayPreferencesId") 
    public String displayPreferencesId;
    @JsonProperty("Tags") 
    public ArrayList<String> tags;
    @JsonProperty("PrimaryImageAspectRatio") 
    public double primaryImageAspectRatio;
    @JsonProperty("VideoType") 
    public String videoType;
    @JsonProperty("LocationType") 
    public String locationType;
    @JsonProperty("MediaType") 
    public String mediaType;
    @JsonProperty("LockData") 
    public boolean lockData;


    public JellyfinItemMetadata() {
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

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
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
/*
    public ArrayList<JellyfimMediaSource> getMediaSources() {
        return mediaSources;
    }

    public void setMediaSources(ArrayList<JellyfimMediaSource> mediaSources) {
        this.mediaSources = mediaSources;
    }
*/
    public int getCriticRating() {
        return criticRating;
    }

    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }


    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public int getCommunityRating() {
        return communityRating;
    }

    public void setCommunityRating(int communityRating) {
        this.communityRating = communityRating;
    }

    public long getRunTimeTicks() {
        return runTimeTicks;
    }

    public void setRunTimeTicks(long runTimeTicks) {
        this.runTimeTicks = runTimeTicks;
    }

    public String getPlayAccess() {
        return playAccess;
    }

    public void setPlayAccess(String playAccess) {
        this.playAccess = playAccess;
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

    public boolean isIsHD() {
        return isHD;
    }

    public void setIsHD(boolean isHD) {
        this.isHD = isHD;
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

    public boolean isLockData() {
        return lockData;
    }

    public void setLockData(boolean lockData) {
        this.lockData = lockData;
    }

    
}
