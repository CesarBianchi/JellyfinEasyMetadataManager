
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lariflix.jemm.utils.TransformDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents the metadata for a Jellyfin folder.
 * It is used to store and manage information related to the metadata of a specific folder in the Jellyfin server.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinPeopleItem
 * @see JellyfinStudioItem
 * @see JellyfinGenreItem
 * @see JellyfinCadPeopleItem
 * @see JellyfinCadStudioItem
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

    /**
     * Default constructor for the JellyfinFolderMetadata class.
     * Initializes a new instance of the class without setting any of the fields.
     *
     * @author Cesar Bianchi
     */
    public JellyfinFolderMetadata() {
    }

    /**
     * Gets the name of the folder.
     *
     * @return A string representing the name of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the folder.
     *
     * @param name A string containing the new name of the folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the server ID.
     *
     * @return A string representing the server ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the server ID.
     *
     * @param serverId A string containing the new server ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * Gets the ID.
     *
     * @return A string representing the ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID.
     *
     * @param id A string containing the new ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the Etag.
     *
     * @return A string representing the Etag.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getEtag() {
        return etag;
    }

    /**
     * Sets the Etag.
     *
     * @param etag A string containing the new Etag.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    /**
     * Gets the date created.
     *
     * @return A Date object representing the date created.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the date created.
     *
     * @param dateCreated A Date object containing the new date created.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Checks if the item can be deleted.
     *
     * @return A boolean value indicating whether the item can be deleted.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public boolean isCanDelete() {
        return canDelete;
    }

    /**
     * Sets the canDelete property.
     *
     * @param canDelete A boolean indicating whether the item can be deleted.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    /**
     * Gets the canDownload property.
     *
     * @return A boolean indicating whether the item can be downloaded.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public boolean isCanDownload() {
        return canDownload;
    }

    /**
     * Sets the canDownload property.
     *
     * @param canDownload A boolean indicating whether the item can be downloaded.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCanDownload(boolean canDownload) {
        this.canDownload = canDownload;
    }

    /**
     * Gets the preferred metadata language.
     *
     * @return A string representing the preferred metadata language.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getPreferredMetadataLanguage() {
        return preferredMetadataLanguage;
    }

    /**
     * Sets the preferred metadata language.
     *
     * @param preferredMetadataLanguage A string containing the new preferred metadata language.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setPreferredMetadataLanguage(String preferredMetadataLanguage) {
        this.preferredMetadataLanguage = preferredMetadataLanguage;
    }

    /**
     * Gets the preferred metadata country code.
     *
     * @return A string representing the preferred metadata country code.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getPreferredMetadataCountryCode() {
        return preferredMetadataCountryCode;
    }

    /**
     * Sets the preferred metadata country code.
     *
     * @param preferredMetadataCountryCode A string containing the new preferred metadata country code.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setPreferredMetadataCountryCode(String preferredMetadataCountryCode) {
        this.preferredMetadataCountryCode = preferredMetadataCountryCode;
    }

    /**
     * Gets the sort name.
     *
     * @return A string representing the sort name.
     * @author Cesar Bianchi
     */
    public String getSortName() {
        return sortName;
    }

    /**
     * Sets the sort name.
     *
     * @param sortName A string containing the new sort name.
     * @author Cesar Bianchi
     */
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    /**
     * Gets the forced sort name.
     *
     * @return A string representing the forced sort name.
     * @author Cesar Bianchi
     */
    public String getForcedSortName() {
        return forcedSortName;
    }

    /**
     * Sets the forced sort name.
     *
     * @param forcedSortName A string containing the new forced sort name.
     * @author Cesar Bianchi
     */
    public void setForcedSortName(String forcedSortName) {
        this.forcedSortName = forcedSortName;
    }

    /**
     * Gets the premiere date.
     *
     * @return A Date object representing the premiere date.
     * @author Cesar Bianchi
     */
    public Date getPremiereDate() {
        return premiereDate;
    }

    /**
     * Sets the premiere date.
     *
     * @param premiereDate A Date object containing the new premiere date.
     * @author Cesar Bianchi
     */
    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    /**
     * Gets the external URLs.
     *
     * @return An ArrayList of Objects representing the external URLs.
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getExternalUrls() {
        return externalUrls;
    }

    /**
     * Sets the external URLs.
     *
     * @param externalUrls An ArrayList of Objects containing the new external URLs.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setExternalUrls(ArrayList<Object> externalUrls) {
        this.externalUrls = externalUrls;
    }

    /**
     * Gets the path.
     *
     * @return A string representing the path.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     *
     * @param path A string containing the new path.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Checks if the media source display is enabled.
     *
     * @return A boolean value indicating whether the media source display is enabled.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public boolean isEnableMediaSourceDisplay() {
        return enableMediaSourceDisplay;
    }

    /**
     * Sets the enableMediaSourceDisplay property.
     *
     * @param enableMediaSourceDisplay A boolean indicating whether the media source display should be enabled.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setEnableMediaSourceDisplay(boolean enableMediaSourceDisplay) {
        this.enableMediaSourceDisplay = enableMediaSourceDisplay;
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
     * Gets the custom rating.
     *
     * @return A string representing the custom rating.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getCustomRating() {
        return customRating;
    }

    /**
     * Sets the custom rating.
     *
     * @param customRating A string containing the new custom rating.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCustomRating(String customRating) {
        this.customRating = customRating;
    }

    /**
     * Gets the channel ID.
     *
     * @return An Object representing the channel ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public Object getChannelId() {
        return channelId;
    }

    /**
     * Sets the channel ID.
     *
     * @param channelId An Object containing the new channel ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setChannelId(Object channelId) {
        this.channelId = channelId;
    }

    /**
     * Gets the overview.
     *
     * @return A string representing the overview.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Sets the overview.
     *
     * @param overview A string containing the new overview.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * Gets the taglines.
     *
     * @return An ArrayList of Objects representing the taglines.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<Object> getTaglines() {
        return taglines;
    }

    /**
     * Sets the taglines.
     *
     * @param taglines An ArrayList of Objects containing the new taglines.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setTaglines(ArrayList<Object> taglines) {
        this.taglines = taglines;
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
     * Gets the play access.
     *
     * @return A string representing the play access.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getPlayAccess() {
        return playAccess;
    }

    /**
     * Sets the play access.
     *
     * @param playAccess A string containing the new play access.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setPlayAccess(String playAccess) {
        this.playAccess = playAccess;
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
     * Gets the remote trailers.
     *
     * @return An ArrayList of Objects representing the remote trailers.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<Object> getRemoteTrailers() {
        return remoteTrailers;
    }

    /**
     * Sets the remote trailers.
     *
     * @param remoteTrailers An ArrayList of Objects containing the new remote trailers.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setRemoteTrailers(ArrayList<Object> remoteTrailers) {
        this.remoteTrailers = remoteTrailers;
    }

    /**
     * Checks if the item is a folder.
     *
     * @return A boolean value indicating whether the item is a folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public boolean isIsFolder() {
        return isFolder;
    }

    /**
     * Sets the isFolder property.
     *
     * @param isFolder A boolean indicating whether the item is a folder.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setIsFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }

    /**
     * Gets the parent ID.
     *
     * @return A string representing the parent ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the parent ID.
     *
     * @param parentId A string containing the new parent ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
     * Gets the people.
     *
     * @return An ArrayList of JellyfinPeopleItem objects representing the people.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<JellyfinPeopleItem> getPeople() {
        return people;
    }

    /**
     * Sets the people.
     *
     * @param people An ArrayList of JellyfinPeopleItem objects containing the new people.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setPeople(ArrayList<JellyfinPeopleItem> people) {
        this.people = people;
    }

    /**
     * Gets the studios.
     *
     * @return An ArrayList of JellyfinStudioItem objects representing the studios.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<JellyfinStudioItem> getStudios() {
        return studios;
    }

    /**
     * Sets the studios.
     *
     * @param studios An ArrayList of JellyfinStudioItem objects containing the new studios.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setStudios(ArrayList<JellyfinStudioItem> studios) {
        this.studios = studios;
    }

    /**
     * Gets the genre items.
     *
     * @return An ArrayList of JellyfinGenreItem objects representing the genre items.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<JellyfinGenreItem> getGenreItems() {
        return genreItems;
    }

    /**
     * Sets the genre items.
     *
     * @param genreItems An ArrayList of JellyfinGenreItem objects containing the new genre items.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setGenreItems(ArrayList<JellyfinGenreItem> genreItems) {
        this.genreItems = genreItems;
    }

    /**
     * Gets the local trailer count.
     *
     * @return An integer representing the local trailer count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getLocalTrailerCount() {
        return localTrailerCount;
    }

    /**
     * Sets the local trailer count.
     *
     * @param localTrailerCount An integer containing the new local trailer count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setLocalTrailerCount(int localTrailerCount) {
        this.localTrailerCount = localTrailerCount;
    }

    /**
     * Gets the child count.
     *
     * @return An integer representing the child count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getChildCount() {
        return childCount;
    }

    /**
     * Sets the child count.
     *
     * @param childCount An integer containing the new child count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    /**
     * Gets the special feature count.
     *
     * @return An integer representing the special feature count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public int getSpecialFeatureCount() {
        return specialFeatureCount;
    }

    /**
     * Sets the special feature count.
     *
     * @param specialFeatureCount An integer containing the new special feature count.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setSpecialFeatureCount(int specialFeatureCount) {
        this.specialFeatureCount = specialFeatureCount;
    }

    /**
     * Gets the display preferences ID.
     *
     * @return A string representing the display preferences ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getDisplayPreferencesId() {
        return displayPreferencesId;
    }

    /**
     * Sets the display preferences ID.
     *
     * @param displayPreferencesId A string containing the new display preferences ID.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setDisplayPreferencesId(String displayPreferencesId) {
        this.displayPreferencesId = displayPreferencesId;
    }

    /**
     * Gets the tags.
     *
     * @return An ArrayList of Strings representing the tags.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * Sets the tags.
     *
     * @param tags An ArrayList of Strings containing the new tags.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    /**
     * Gets the primary image aspect ratio.
     *
     * @return A double representing the primary image aspect ratio.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public double getPrimaryImageAspectRatio() {
        return primaryImageAspectRatio;
    }

    /**
     * Sets the primary image aspect ratio.
     *
     * @param primaryImageAspectRatio A double containing the new primary image aspect ratio.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setPrimaryImageAspectRatio(double primaryImageAspectRatio) {
        this.primaryImageAspectRatio = primaryImageAspectRatio;
    }

    /**
     * Gets the collection type.
     *
     * @return A string representing the collection type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public String getCollectionType() {
        return collectionType;
    }

    /**
     * Sets the collection type.
     *
     * @param collectionType A string containing the new collection type.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    /**
     * Gets the backdrop image tags.
     *
     * @return An ArrayList of Objects representing the backdrop image tags.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<Object> getBackdropImageTags() {
        return backdropImageTags;
    }

    /**
     * Sets the backdrop image tags.
     *
     * @param backdropImageTags An ArrayList of Objects containing the new backdrop image tags.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setBackdropImageTags(ArrayList<Object> backdropImageTags) {
        this.backdropImageTags = backdropImageTags;
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
     * Gets the locked fields.
     *
     * @return An ArrayList of Objects representing the locked fields.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public ArrayList<Object> getLockedFields() {
        return lockedFields;
    }

    /**
     * Sets the locked fields.
     *
     * @param lockedFields An ArrayList of Objects containing the new locked fields.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setLockedFields(ArrayList<Object> lockedFields) {
        this.lockedFields = lockedFields;
    }

    /**
     * Checks if the data is locked.
     *
     * @return A boolean value indicating whether the data is locked.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public boolean isLockData() {
        return lockData;
    }

    /**
     * Sets the lockData property.
     *
     * @param lockData A boolean indicating whether the data is locked.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setLockData(boolean lockData) {
        this.lockData = lockData;
    }

    public void mySetProductionYear(String prdYear) {
        this.productionYear = Integer.parseInt(prdYear);
    }

    public void mySetCommunityRating(String rating) {
        this.communityRating = Integer.parseInt(rating);
    }

    public void mySetPremiereDate(String date) {
        try {
            this.premiereDate = new TransformDateFormat().getFullDateFromSimple(date);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinFolderMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mySetDateCreated(String date) {
        try {
            this.dateCreated = new TransformDateFormat().getFullDateFromSimple(date);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinFolderMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
