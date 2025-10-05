package com.lariflix.jemm.csv;

import com.lariflix.jemm.dtos.JellyfinStudioItem;
import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * The JellyfinCsvStructure class represents the structure of a CSV file for Jellyfin metadata.
 * It contains various fields related to media items and provides methods to set and get these fields.
 * It also includes methods to remove invalid characters from strings and to check the MD5 hash of the Jellyfin version.
 * 
 * @since 1.2.0
 * @version 1.0
 * @author CesarBianchi
 * @see JellyfinExportMetadata
 * @see JellyfinImportMetadata
 */
public class JellyfinCsvStructure {
    public String Id = new String();
    public String ParentId = new String();
    public String Name = new String();
    public String OriginalTitle = new String();
    public String SortName = new String();
    public String ForcedSortName  = new String();    
    public String Type = new String();
    public String CollectionType = new String();
    public String ProductionYear = new String();    
    public String CommunityRating  = new String();
    public String CriticRating  = new String();
    public String OfficialRating  = new String();
    public String PremiereDate = new String();
    public String DateCreated = new String();
    public String Genres = new String();
    public String PreferredMetadataLanguage = new String();
    public String PreferredMetadataCountryCode = new String();
    public String Studios = new String();
    public String Tags = new String();
    public String LocationType = new String();
    public String MediaType = new String();
    public String IsHD = new String();            
    public String Path = new String();
    public String JemmVersion = new String();
    public String ServerID = new String();
    public String Overview = new String();
    
    /**
     * Default constructor for the JellyfinCsvStructure class.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinCsvStructure(){
        
    }

    // Getters and Setters with JavaDoc

    /**
     * Gets the ID.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the ID
     */
    public String getId() {
        return Id;
    }

    /**
     * Sets the ID.
     * @since 1.2.0
     * @author CesarBianchi
     * @param Id the ID to set
     */
    public void setId(String Id) {
        this.Id = this.removeInvalidChars(Id);
    }

    /**
     * Gets the Parent ID.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Parent ID
     */
    public String getParentId() {
        return ParentId;
    }

    /**
     * Sets the Parent ID.
     * @since 1.2.0
     * @author CesarBianchi
     * @param ParentId the Parent ID to set
     */
    public void setParentId(String ParentId) {
        this.ParentId = this.removeInvalidChars(ParentId);
    }

    /**
     * Gets the Name.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the Name.
     * @since 1.2.0
     * @author CesarBianchi
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = this.removeInvalidChars(Name);
    }

    /**
     * Gets the Original Title.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Original Title
     */
    public String getOriginalTitle() {
        return OriginalTitle;
    }

    /**
     * Sets the Original Title.
     * @since 1.2.0
     * @author CesarBianchi
     * @param OriginalTitle the Original Title to set
     */
    public void setOriginalTitle(String OriginalTitle) {
        this.OriginalTitle = this.removeInvalidChars(OriginalTitle);
    }

    /**
     * Gets the Sort Name.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Sort Name
     */
    public String getSortName() {
        return SortName;
    }

    /**
     * Sets the Sort Name.
     * @since 1.2.0
     * @author CesarBianchi
     * @param SortName the Sort Name to set
     */
    public void setSortName(String SortName) {
        this.SortName = this.removeInvalidChars(SortName);
    }

    /**
     * Gets the Forced Sort Name.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Forced Sort Name
     */
    public String getForcedSortName() {
        return ForcedSortName;
    }

    /**
     * Sets the Forced Sort Name.
     * @since 1.2.0
     * @author CesarBianchi
     * @param ForcedSortName the Forced Sort Name to set
     */
    public void setForcedSortName(String ForcedSortName) {
        this.ForcedSortName = this.removeInvalidChars(ForcedSortName);
    }

    /**
     * Gets the Type.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Type
     */
    public String getType() {
        return Type;
    }

    /**
     * Sets the Type.
     * @since 1.2.0
     * @author CesarBianchi
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.Type = this.removeInvalidChars(Type);
    }

    /**
     * Gets the Collection Type.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Collection Type
     */
    public String getCollectionType() {
        return CollectionType;
    }

    /**
     * Sets the Collection Type.
     * @since 1.2.0
     * @author CesarBianchi
     * @param CollectionType the Collection Type to set
     */
    public void setCollectionType(String CollectionType) {
        this.CollectionType = this.removeInvalidChars(CollectionType);
    }

    /**
     * Gets the Production Year.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Production Year
     */
    public String getProductionYear() {
        return ProductionYear;
    }

    /**
     * Sets the Production Year.
     * @since 1.2.0
     * @author CesarBianchi
     * @param ProductionYear the Production Year to set
     */
    public void setProductionYear(String ProductionYear) {
        this.ProductionYear = this.removeInvalidChars(ProductionYear);
    }

    /**
     * Gets the Community Rating.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Community Rating
     */
    public String getCommunityRating() {
        return CommunityRating;
    }

    /**
     * Sets the Community Rating.
     * @since 1.2.0
     * @author CesarBianchi
     * @param CommunityRating the Community Rating to set
     */
    public void setCommunityRating(String CommunityRating) {
        this.CommunityRating = this.removeInvalidChars(CommunityRating);
    }

    /**
     * Gets the Critic Rating.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Critic Rating
     */
    public String getCriticRating() {
        return CriticRating;
    }

    /**
     * Sets the Critic Rating.
     * @since 1.2.0
     * @author CesarBianchi
     * @param CriticRating the Critic Rating to set
     */
    public void setCriticRating(String CriticRating) {
        this.CriticRating = this.removeInvalidChars(CriticRating);
    }

    /**
     * Gets the Official Rating.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Official Rating
     */
    public String getOfficialRating() {
        return OfficialRating;
    }

    /**
     * Sets the Official Rating.
     * @since 1.2.0
     * @author CesarBianchi
     * @param OfficialRating the Official Rating to set
     */
    public void setOfficialRating(String OfficialRating) {
        this.OfficialRating = this.removeInvalidChars(OfficialRating);
    }

    /**
     * Gets the Premiere Date.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Premiere Date
     */
    public String getPremiereDate() {
        return PremiereDate;
    }

    /**
     * Sets the Premiere Date.
     * @since 1.2.0
     * @author CesarBianchi
     * @param PremiereDate the Premiere Date to set
     */
    public void setPremiereDate(String PremiereDate) {
        this.PremiereDate = this.removeInvalidChars(PremiereDate);
    }

    /**
     * Gets the Date Created.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Date Created
     */
    public String getDateCreated() {
        return DateCreated;
    }

    /**
     * Sets the Date Created.
     * @since 1.2.0
     * @author CesarBianchi
     * @param DateCreated the Date Created to set
     */
    public void setDateCreated(String DateCreated) {
        this.DateCreated = this.removeInvalidChars(DateCreated);
    }

    /**
     * Gets the Genres.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Genres
     */
    public String getGenres() {
        return Genres;
    }

    /**
     * Sets the Genres.
     * @since 1.2.0
     * @author CesarBianchi
     * @param genres the Genres to set
     */
    public void setGenres(String genres) {
        this.Genres = this.removeInvalidChars(genres);
    }

    /**
     * Sets the Genres from a list.
     * @since 1.2.0
     * @author CesarBianchi
     * @param grs the list of Genres to set
     */
    public void setGenres(ArrayList<String> grs) {
        for (int nI = 0; nI < grs.size(); nI++) {
            this.Genres = this.Genres.concat(grs.get(nI));
            if ((grs.size() - 1) != nI) {
                this.Genres = this.removeInvalidChars(this.Genres.concat(", "));
            }
        }
    }

    /**
     * Gets the Preferred Metadata Language.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Preferred Metadata Language
     */
    public String getPreferredMetadataLanguage() {
        return PreferredMetadataLanguage;
    }

    /**
     * Sets the Preferred Metadata Language.
     * @since 1.2.0
     * @author CesarBianchi
     * @param PreferredMetadataLanguage the Preferred Metadata Language to set
     */
    public void setPreferredMetadataLanguage(String PreferredMetadataLanguage) {
        this.PreferredMetadataLanguage = this.removeInvalidChars(PreferredMetadataLanguage);
    }

    /**
     * Gets the Preferred Metadata Country Code.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Preferred Metadata Country Code
     */
    public String getPreferredMetadataCountryCode() {
        return PreferredMetadataCountryCode;
    }

    /**
     * Sets the Preferred Metadata Country Code.
     * @since 1.2.0
     * @author CesarBianchi
     * @param PreferredMetadataCountryCode the Preferred Metadata Country Code to set
     */
    public void setPreferredMetadataCountryCode(String PreferredMetadataCountryCode) {
        this.PreferredMetadataCountryCode = this.removeInvalidChars(PreferredMetadataCountryCode);
    }

    /**
     * Gets the Studios.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Studios
     */
    public String getStudios() {
        return Studios;
    }

    /**
     * Sets the Studios from a list.
     * @since 1.2.0
     * @author CesarBianchi
     * @param Studios the list of Studios to set
     */
    public void setStudios(ArrayList<JellyfinStudioItem> Studios) {
        for (int nI = 0; nI < Studios.size(); nI++) {
            this.Studios = this.Studios.concat(Studios.get(nI).getName());
            if ((Studios.size() - 1) != nI) {
                this.Studios = this.removeInvalidChars(this.Studios.concat(""));
            }
        }
    }

    /**
     * Gets the Tags.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Tags
     */
    public String getTags() {
        return Tags;
    }

    /**
     * Sets the Tags.
     * @since 1.2.0
     * @author CesarBianchi
     * @param Tags the Tags to set
     */
    public void setTags(String Tags) {
        this.Tags = this.removeInvalidChars(Tags);
    }

    /**
     * Sets the Tags from a list.
     * @since 1.2.0
     * @author CesarBianchi
     * @param Tgs the list of Tags to set
     */
    public void setTags(ArrayList<String> Tgs) {
        for (int nI = 0; nI < Tgs.size(); nI++) {
            this.Tags = this.Tags.concat(Tgs.get(nI));
            if ((Tgs.size() - 1) != nI) {
                this.Tags = this.removeInvalidChars(this.Tags.concat(", "));
            }
        }
    }

    /**
     * Gets the Location Type.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Location Type
     */
    public String getLocationType() {
        return LocationType;
    }

    /**
     * Sets the Location Type.
     * @since 1.2.0
     * @author CesarBianchi
     * @param LocationType the Location Type to set
     */
    public void setLocationType(String LocationType) {
        this.LocationType = this.removeInvalidChars(LocationType);
    }

    /**
     * Gets the Media Type.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Media Type
     */
    public String getMediaType() {
        return MediaType;
    }

    /**
     * Sets the Media Type.
     * @since 1.2.0
     * @author CesarBianchi
     * @param MediaType the Media Type to set
     */
    public void setMediaType(String MediaType) {
        this.MediaType = this.removeInvalidChars(MediaType);
    }

    /**
     * Gets the HD status.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the HD status
     */
    public String getIsHD() {
        return IsHD;
    }

    /**
     * Sets the HD status.
     * @since 1.2.0
     * @author CesarBianchi
     * @param IsHD the HD status to set
     */
    public void setIsHD(String IsHD) {
        this.IsHD = this.removeInvalidChars(IsHD);
    }

    /**
     * Sets the HD status.
     * @since 1.2.0
     * @author CesarBianchi
     * @param HD the HD status to set
     */
    public void setIsHD(boolean HD) {
        if (HD) {
            this.IsHD = "True";
        } else {
            this.IsHD = "False";
        }
    }

    /**
     * Gets the Path.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Path
     */
    public String getPath() {
        return Path;
    }

    /**
     * Sets the Path.
     * @since 1.2.0
     * @author CesarBianchi
     * @param Path the Path to set
     */
    public void setPath(String Path) {
        this.Path = this.removeInvalidChars(Path);
    }

    /**
     * Removes invalid characters from a string.
     * @since 1.2.0
     * @author CesarBianchi
     * @param cContent the string to process
     * @return the processed string
     */
    public String removeInvalidChars(String cContent) {
        String cReplacedContent = new String();
        // To prevent "broke csv line" case any string has comma inside
        if (cContent != null) {
            cReplacedContent = new String(cContent).replace(";", "");
            // Remove "indentation spaces present in subfolders name
            String prefixSubFolder = "   ";
            String prefixSubFolderInd = "⎆ ";
            if (cReplacedContent.contains(prefixSubFolderInd)) {
                cReplacedContent = cReplacedContent.replace(prefixSubFolder, "");
                cReplacedContent = cReplacedContent.replace(prefixSubFolderInd, "");
            }
        } else {
            cReplacedContent = "";
        }
        return cReplacedContent;
    }

    /**
     * Gets the Jemm Version.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Jemm Version
     */
    public String getJemmVersion() {
        return JemmVersion;
    }

    /**
     * Sets the Jemm Version.
     * @since 1.2.0
     * @author CesarBianchi
     * @param jemmVersion the Jemm Version to set
     */
    public void setJemmVersion(String jemmVersion) {
        String withprefix = "to_prevent_noobies_".concat(jemmVersion);
        String md5Hex = DigestUtils.md5Hex(withprefix).toUpperCase();
        this.JemmVersion = md5Hex;
    }

    /**
     * Checks the Jellyfin version MD5 hash.
     * @since 1.2.0
     * @author CesarBianchi
     * @param hash the hash to check
     * @param value the value to check against
     * @return true if the hash matches, false otherwise
     */
    public boolean checkJellyfinVersionMD5(String hash, String value) {
        String withprefix = "to_prevent_noobies_".concat(value);
        String md5Hex = DigestUtils.md5Hex(withprefix).toUpperCase();
        return md5Hex.equals(hash);
    }

    /**
     * Gets the Server ID.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Server ID
     */
    public String getServerID() {
        return ServerID;
    }

    /**
     * Sets the Server ID.
     * @since 1.2.0
     * @author CesarBianchi
     * @param serverID the Server ID to set
     */
    public void setServerID(String serverID) {
        this.ServerID = serverID;
    }

    /**
     * Gets the Overview.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Overview
     */
    public String getOverview() {
        return Overview;
    }

    /**
     * Sets the Overview.
     * @since 1.2.0
     * @author CesarBianchi
     * @param ovView the Overview to set
     */
    public void setOverview(String ovView) {
        this.Overview = this.removeInvalidChars(ovView);
        this.Overview = this.Overview.replace("\n", " || ");
    }

    /**
     * Gets the Overview with line breaks.
     * @since 1.2.0
     * @author CesarBianchi
     * @return the Overview with line breaks
     */
    public String getOverviewWithSkips() {
        return Overview.replace(" || ", "\n");
    }
}