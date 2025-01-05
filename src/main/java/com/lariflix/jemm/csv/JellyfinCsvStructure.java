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
    
    public JellyfinCsvStructure(){
        
    }

    public String getId() {
        if (Id == null){
            Id = "";
        }
        
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getParentId() {
        if (ParentId == null){
            ParentId = "";
        }
        
        return ParentId;
    }

    public void setParentId(String ParentId) {
        this.ParentId = ParentId;
    }

    public String getName() {
        if (Name == null){
            Name = "";
        }
        
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getOriginalTitle() {
        if (OriginalTitle == null){
            OriginalTitle = "";
        }
        
        return OriginalTitle;
    }

    public void setOriginalTitle(String OriginalTitle) {
        this.OriginalTitle = OriginalTitle;
    }

    public String getSortName() {
        if (SortName == null){
            SortName = "";
        }
        
        return SortName;
    }

    public void setSortName(String SortName) {
        this.SortName = SortName;
    }

    public String getForcedSortName() {
        if (ForcedSortName == null){
            ForcedSortName = "";
        }
        
        return ForcedSortName;
    }

    public void setForcedSortName(String ForcedSortName) {
        this.ForcedSortName = ForcedSortName;
    }

    public String getType() {
        if (Type == null){
            Type = "";
        }
        
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getCollectionType() {
        if (CollectionType == null){
            CollectionType = "";
        }
        
        return CollectionType;
    }

    public void setCollectionType(String CollectionType) {
        this.CollectionType = CollectionType;
    }

    public String getProductionYear() {
        if (ProductionYear == null){
            ProductionYear = "";
        }
        
        return ProductionYear;
    }

    public void setProductionYear(String ProductionYear) {
        this.ProductionYear = ProductionYear;
    }

    public String getCommunityRating() {
        if (CommunityRating == null){
            CommunityRating = "";
        }
        
        return CommunityRating;
    }

    public void setCommunityRating(String CommunityRating) {
        this.CommunityRating = CommunityRating;
    }

    public String getCriticRating() {
        if (CriticRating == null){
            CriticRating = "";
        }
        
        return CriticRating;
    }

    public void setCriticRating(String CriticRating) {
        this.CriticRating = CriticRating;
    }

    public String getOfficialRating() {
        if (OfficialRating == null){
            OfficialRating = "";
        }
        
        return OfficialRating;
    }

    public void setOfficialRating(String OfficialRating) {
        this.OfficialRating = OfficialRating;
    }

    public String getPremiereDate() {
        if (PremiereDate == null){
            PremiereDate = "";
        }
        
        return PremiereDate;
    }

    public void setPremiereDate(String PremiereDate) {
        this.PremiereDate = PremiereDate;
    }

    public String getDateCreated() {
        if (DateCreated == null){
            DateCreated = "";
        }
        return DateCreated;
    }

    public void setDateCreated(String DateCreated) {
        this.DateCreated = DateCreated;
    }

    public String getGenres() {
        if (Genres == null){
            Genres = "";
        }
        return Genres;
    }

    public void setGenres(String genres) {
        this.Genres = genres;
    }

    public void setGenres(ArrayList<String>  grs) {
        
        for (int nI = 0; nI < grs.size(); nI++){
               
            this.Genres = this.Genres.concat(grs.get(nI));
            
            if ((grs.size()-1) != nI){
                this.Genres = this.Studios.concat("|");
            
            }
        }        
    }
    
    public String getPreferredMetadataLanguage() {        
        if (PreferredMetadataLanguage == null){
            PreferredMetadataLanguage = "";
        }
        return PreferredMetadataLanguage;
    }

    public void setPreferredMetadataLanguage(String PreferredMetadataLanguage) {
        this.PreferredMetadataLanguage = PreferredMetadataLanguage;
    }

    public String getPreferredMetadataCountryCode() {
        if (PreferredMetadataCountryCode == null){
            PreferredMetadataCountryCode = "";
        }
        return PreferredMetadataCountryCode;
    }

    public void setPreferredMetadataCountryCode(String PreferredMetadataCountryCode) {
        this.PreferredMetadataCountryCode = PreferredMetadataCountryCode;
    }

    public String getStudios() {
        if (Studios == null){
            Studios = "";
        }
        return Studios;
    }

    public void setStudios(ArrayList<JellyfinStudioItem> Studios) {
        
        for (int nI = 0; nI < Studios.size(); nI++){            
            this.Studios = this.Studios.concat(Studios.get(nI).getName());
            
            if ((Studios.size()-1) != nI){
                this.Studios = this.Studios.concat("|");
            }            
        }
        
    }

    public String getTags() {
        if (Tags == null){
            Tags = "";
        }
        return Tags;
    }

    public void setTags(String Tags) {
        this.Tags = Tags;
    }
    
    public void setTags(ArrayList<String>  Tgs) {
        
        for (int nI = 0; nI < Tgs.size(); nI++){            
            this.Tags = this.Tags.concat(Tgs.get(nI));
            
            if ((Tgs.size()-1) != nI){
                this.Tags = this.Tags.concat("|");
            }            
        }
        
        
    }

    public String getLocationType() {
        if (LocationType == null){
            LocationType = "";
        }
        return LocationType;
    }

    public void setLocationType(String LocationType) {
        this.LocationType = LocationType;
    }

    public String getMediaType() {
        if (MediaType == null){
            MediaType = "";
        }
        return MediaType;
    }

    public void setMediaType(String MediaType) {
        this.MediaType = MediaType;
    }

    public String getIsHD() {
        if (IsHD == null){
            IsHD = "";
        }
        return IsHD;
    }

    public void setIsHD(String IsHD) {
        this.IsHD = IsHD;
    }
    
    public void setIsHD(boolean HD) {
        
        if (HD){
            this.IsHD = "True";
        } else {
            this.IsHD = "False";
        }
    }
    
    public String getPath() {
        if (Path == null){
            Path = "";
        }
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }
    
    
}
