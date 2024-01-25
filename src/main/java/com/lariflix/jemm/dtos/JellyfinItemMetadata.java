package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents the JellyfinItemMetadata.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinItem
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


    /**
     * Default constructor.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinItemMetadata() {
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
     * Returns the server ID of the item.
     *
     * @return The server ID of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the server ID of the item.
     *
     * @param serverId The new server ID of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
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
     * Returns the Etag of the item.
     *
     * @return The Etag of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getEtag() {
        return etag;
    }

    /**
     * Sets the Etag of the item.
     *
     * @param etag The new Etag of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }


    /**
     * Returns the date the item was created.
     *
     * @return The date the item was created.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the date the item was created.
     *
     * @param dateCreated The new creation date of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Returns whether the item can be deleted.
     *
     * @return True if the item can be deleted, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isCanDelete() {
        return canDelete;
    }

    /**
     * Sets whether the item can be deleted.
     *
     * @param canDelete The new delete status of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    /**
     * Returns whether the item can be downloaded.
     *
     * @return True if the item can be downloaded, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isCanDownload() {
        return canDownload;
    }

    /**
     * Sets whether the item can be downloaded.
     *
     * @param canDownload The new download status of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setCanDownload(boolean canDownload) {
        this.canDownload = canDownload;
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
     * Returns the container of the item.
     *
     * @return The container of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getContainer() {
        return container;
    }

    /**
     * Sets the container of the item.
     *
     * @param container The new container of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * Returns the sort name of the item.
     *
     * @return The sort name of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getSortName() {
        return sortName;
    }

    /**
     * Sets the sort name of the item.
     *
     * @param sortName The new sort name of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setSortName(String sortName) {
        this.sortName = sortName;
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
     * Returns the premiere date of the item.
     *
     * @return The premiere date of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public Date getPremiereDate() {
        return premiereDate;
    }

    /**
     * Sets the premiere date of the item.
     *
     * @param premiereDate The new premiere date of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
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
     * Returns the path of the item.
     *
     * @return The path of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path of the item.
     *
     * @param path The new path of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Returns whether the media source display is enabled.
     *
     * @return True if the media source display is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableMediaSourceDisplay() {
        return enableMediaSourceDisplay;
    }

    /**
     * Sets whether the media source display is enabled.
     *
     * @param enableMediaSourceDisplay The new status of the media source display.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableMediaSourceDisplay(boolean enableMediaSourceDisplay) {
        this.enableMediaSourceDisplay = enableMediaSourceDisplay;
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
     * Returns the runtime ticks of the item.
     *
     * @return The runtime ticks of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public long getRunTimeTicks() {
        return runTimeTicks;
    }

    /**
     * Sets the runtime ticks of the item.
     *
     * @param runTimeTicks The new runtime ticks of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setRunTimeTicks(long runTimeTicks) {
        this.runTimeTicks = runTimeTicks;
    }

    /**
     * Returns the play access of the item.
     *
     * @return The play access of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getPlayAccess() {
        return playAccess;
    }

    /**
     * Sets the play access of the item.
     *
     * @param playAccess The new play access of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPlayAccess(String playAccess) {
        this.playAccess = playAccess;
    }

    /**
     * Returns the aspect ratio of the item.
     *
     * @return The aspect ratio of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * Sets the aspect ratio of the item.
     *
     * @param aspectRatio The new aspect ratio of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
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
     * Returns whether the item is in HD.
     *
     * @return True if the item is in HD, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isIsHD() {
        return isHD;
    }
    /**
     * Sets whether the item is in HD.
     *
     * @param isHD The new HD status of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setIsHD(boolean isHD) {
        this.isHD = isHD;
    }

    /**
     * Returns whether the item is a folder.
     *
     * @return True if the item is a folder, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isIsFolder() {
        return isFolder;
    }

    /**
     * Sets whether the item is a folder.
     *
     * @param isFolder The new folder status of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setIsFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }

    /**
     * Returns the parent ID of the item.
     *
     * @return The parent ID of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the parent ID of the item.
     *
     * @param parentId The new parent ID of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * Returns the type of the item.
     *
     * @return The type of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the item.
     *
     * @param type The new type of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the people associated with the item.
     *
     * @return The people associated with the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinPeopleItem> getPeople() {
        return people;
    }

    /**
     * Sets the people associated with the item.
     *
     * @param people The new people associated with the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPeople(ArrayList<JellyfinPeopleItem> people) {
        this.people = people;
    }

    /**
     * Returns the studios associated with the item.
     *
     * @return The studios associated with the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinStudioItem> getStudios() {
        return studios;
    }

    /**
     * Sets the studios associated with the item.
     *
     * @param studios The new studios associated with the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setStudios(ArrayList<JellyfinStudioItem> studios) {
        this.studios = studios;
    }

    /**
     * Returns the genre items of the item.
     *
     * @return The genre items of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinGenreItem> getGenreItems() {
        return genreItems;
    }

    /**
     * Sets the genre items of the item.
     *
     * @param genreItems The new genre items of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setGenreItems(ArrayList<JellyfinGenreItem> genreItems) {
        this.genreItems = genreItems;
    }

    /**
     * Returns the display preferences ID of the item.
     *
     * @return The display preferences ID of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getDisplayPreferencesId() {
        return displayPreferencesId;
    }

    /**
     * Sets the display preferences ID of the item.
     *
     * @param displayPreferencesId The new display preferences ID of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setDisplayPreferencesId(String displayPreferencesId) {
        this.displayPreferencesId = displayPreferencesId;
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
     * Returns the primary image aspect ratio of the item.
     *
     * @return The primary image aspect ratio of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public double getPrimaryImageAspectRatio() {
        return primaryImageAspectRatio;
    }

    /**
     * Sets the primary image aspect ratio of the item.
     *
     * @param primaryImageAspectRatio The new primary image aspect ratio of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPrimaryImageAspectRatio(double primaryImageAspectRatio) {
        this.primaryImageAspectRatio = primaryImageAspectRatio;
    }

    /**
     * Returns the video type of the item.
     *
     * @return The video type of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getVideoType() {
        return videoType;
    }

    /**
     * Sets the video type of the item.
     *
     * @param videoType The new video type of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    /**
     * Returns the location type of the item.
     *
     * @return The location type of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Sets the location type of the item.
     *
     * @param locationType The new location type of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    /**
     * Returns the media type of the item.
     *
     * @return The media type of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets the media type of the item.
     *
     * @param mediaType The new media type of the item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * Returns whether the data of the item is locked.
     *
     * @return True if the data of the item is locked, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isLockData() {
        return lockData;
    }

    /**
     * Sets whether the data of the item is locked.
     *
     * @param lockData The new lock status of the item's data.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLockData(boolean lockData) {
        this.lockData = lockData;
    }

    
}
