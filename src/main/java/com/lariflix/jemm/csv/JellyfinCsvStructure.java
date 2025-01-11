/*
 * Copyright (C) 2025 cesarbianchi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.lariflix.jemm.csv;

import com.lariflix.jemm.dtos.JellyfinStudioItem;
import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;


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
    
    public JellyfinCsvStructure(){
        
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = this.removeInvalidChars(Id);
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String ParentId) {
        this.ParentId = this.removeInvalidChars(ParentId);
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        
        
        this.Name = this.removeInvalidChars(Name);
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public void setOriginalTitle(String OriginalTitle) {
        this.OriginalTitle = this.removeInvalidChars(OriginalTitle);
    }

    public String getSortName() {
        return SortName;
    }

    public void setSortName(String SortName) {
        this.SortName = this.removeInvalidChars(SortName);
    }

    public String getForcedSortName() {
        return ForcedSortName;
    }

    public void setForcedSortName(String ForcedSortName) {
        this.ForcedSortName = this.removeInvalidChars(ForcedSortName);
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = this.removeInvalidChars(Type);
    }

    public String getCollectionType() {
        return CollectionType;
    }

    public void setCollectionType(String CollectionType) {
        this.CollectionType = this.removeInvalidChars(CollectionType);
    }

    public String getProductionYear() {
        return ProductionYear;
    }

    public void setProductionYear(String ProductionYear) {
        this.ProductionYear = this.removeInvalidChars(ProductionYear);
    }

    public String getCommunityRating() {
        return CommunityRating;
    }

    public void setCommunityRating(String CommunityRating) {
        this.CommunityRating = this.removeInvalidChars(CommunityRating);
    }

    public String getCriticRating() {
        return CriticRating;
    }

    public void setCriticRating(String CriticRating) {
        this.CriticRating = this.removeInvalidChars(CriticRating);
    }

    public String getOfficialRating() {
        return OfficialRating;
    }

    public void setOfficialRating(String OfficialRating) {
        this.OfficialRating = this.removeInvalidChars(OfficialRating);
    }

    public String getPremiereDate() {
        return PremiereDate;
    }

    public void setPremiereDate(String PremiereDate) {
        this.PremiereDate = this.removeInvalidChars(PremiereDate);
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String DateCreated) {
        this.DateCreated = this.removeInvalidChars(DateCreated);
    }

    public String getGenres() {
        return Genres;
    }

    public void setGenres(String genres) {
        this.Genres = this.removeInvalidChars(genres);
    }

    public void setGenres(ArrayList<String>  grs) {
        
        for (int nI = 0; nI < grs.size(); nI++){
               
            this.Genres = this.Genres.concat(grs.get(nI));
            
            if ((grs.size()-1) != nI){
                this.Genres = this.removeInvalidChars(this.Genres.concat(", "));
            
            }
        }        
    }
    
    public String getPreferredMetadataLanguage() {        
        return PreferredMetadataLanguage;
    }

    public void setPreferredMetadataLanguage(String PreferredMetadataLanguage) {
        this.PreferredMetadataLanguage = this.removeInvalidChars(PreferredMetadataLanguage);
    }

    public String getPreferredMetadataCountryCode() {
        return PreferredMetadataCountryCode;
    }

    public void setPreferredMetadataCountryCode(String PreferredMetadataCountryCode) {
        this.PreferredMetadataCountryCode = this.removeInvalidChars(PreferredMetadataCountryCode);
    }

    public String getStudios() {
        return Studios;
    }

    public void setStudios(ArrayList<JellyfinStudioItem> Studios) {
        
        for (int nI = 0; nI < Studios.size(); nI++){            
            this.Studios = this.Studios.concat(Studios.get(nI).getName());
            
            if ((Studios.size()-1) != nI){
                this.Studios = this.removeInvalidChars(this.Studios.concat(""));
            }            
        }
        
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String Tags) {
        this.Tags = this.removeInvalidChars(Tags);
    }
    
    public void setTags(ArrayList<String>  Tgs) {
        
        for (int nI = 0; nI < Tgs.size(); nI++){            
            this.Tags = this.Tags.concat(Tgs.get(nI));
            
            if ((Tgs.size()-1) != nI){
                this.Tags = this.removeInvalidChars(this.Tags.concat(", "));
            }            
        }
        
        
    }

    public String getLocationType() {
        return LocationType;
    }

    public void setLocationType(String LocationType) {
        this.LocationType = this.removeInvalidChars(LocationType);
    }

    public String getMediaType() {
        return MediaType;
    }

    public void setMediaType(String MediaType) {
        this.MediaType = this.removeInvalidChars(MediaType);
    }

    public String getIsHD() {
        return IsHD;
    }

    public void setIsHD(String IsHD) {
        this.IsHD = this.removeInvalidChars(IsHD);
    }
    
    public void setIsHD(boolean HD) {
        
        if (HD){
            this.IsHD = "True";
        } else {
            this.IsHD = "False";
        }
    }
    
    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = this.removeInvalidChars(Path);
    }
    
    private String removeInvalidChars(String cContent){
        String cReplacedContent = new String();
        
        //To prevent "broke csv line" case any string has comma inside
        if (cContent != null) {        
            cReplacedContent = new String(cContent).replace(";","");
            
            //Remove "indentation spaces present in subfoldes name
            String prefixSubFolder = "   ";
            String prefixSubFolderInd = "⎆ ";
            if (cReplacedContent.contains(prefixSubFolderInd)){
                cReplacedContent = cReplacedContent.replace(prefixSubFolder, "");
                cReplacedContent = cReplacedContent.replace(prefixSubFolderInd,"");
            }
            
        } else {
            cReplacedContent = "";
        }
        
        return cReplacedContent;
    }

    public String getJemmVersion() {
        return JemmVersion;
    }

    public void setJemmVersion(String jemmVersion) {
        
        String withprefix = "to_prevent_noobies_".concat(jemmVersion);
        
        String md5Hex = DigestUtils.md5Hex(withprefix).toUpperCase();
        
        this.JemmVersion = md5Hex;
    }

    
    public boolean checkJellyfinVersionMD5(String hash, String value){
        
        String withprefix = "to_prevent_noobies_".concat(value);
        
        String md5Hex = DigestUtils.md5Hex(withprefix).toUpperCase();
        
        boolean isOk = md5Hex.equals(hash);
        
        return isOk;
    }
    
    public String getServerID() {
        return ServerID;
    }

    public void setServerID(String serverID) {
        this.ServerID = serverID;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String ovView) {
        this.Overview = this.removeInvalidChars(ovView);
        this.Overview = this.Overview.replace("\n", " || ");
    }
    
    public String getOverviewWithSkips() {
        return Overview.replace(" || ", "\n");
    }
    
    

}
