package com.lariflix.jemm.reports;

import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;

/**
 * The JellyfinReportInventorySubItem class extends the JellyfinItem class and is used to represent a sub-item in an inventory item in a report.
 *
 * This class contains the details of a sub-item, such as the name, the number of items in the category, and other relevant details. 
 * It also contains a list of sub-items for the item, if any.
 *
 * @author Cesar Bianchi
 */
public class JellyfinReportInventorySubItem extends JellyfinItem{
    
    private JellyfinItemMetadata subItemMetadata = new JellyfinItemMetadata();
     
    /**
     * Constructor for the JellyfinReportInventorySubItem class.
     *
     * This is a no-argument constructor that initializes a new instance of the JellyfinReportInventorySubItem class. It doesn't perform any specific actions.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportInventorySubItem(){

    }

    /**
     * Sets the properties of this JellyfinReportInventorySubItem based on the given JellyfinItem.
     *
     * This method sets the aspect ratio, community rating, container, critic rating, ID, whether it is a folder, item metadata, location type, media type, name, official rating, premiere date, production year, server ID, type, and video type of this JellyfinReportInventorySubItem to the corresponding properties of the given JellyfinItem.
     *
     * @param subIt A JellyfinItem object that should be used to set the properties of this JellyfinReportInventorySubItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setSubItem(JellyfinItem subIt){
        this.setAspectRatio(subIt.getAspectRatio());
        this.setCommunityRating(subIt.getCommunityRating());
        this.setContainer(subIt.getContainer());
        this.setCriticRating(subIt.getCriticRating());
        this.setId(subIt.getId());
        this.setIsFolder(subIt.IsFolder());
        this.setItemMetadata(subIt.getItemMetadata());
        this.setLocationType(subIt.getLocationType());
        this.setMediaType(subIt.getMediaType());
        this.setName(subIt.getName());
        this.setOfficialRating(subIt.getOfficialRating());
        this.setPremiereDate(subIt.getPremiereDate());
        this.setProductionYear(subIt.getProductionYear());
        this.setServerId(subIt.getServerId());
        this.setType(subIt.getType());
        this.setVideoType(subIt.getVideoType());
    }
   
    /**
     * Sets the subItemMetadata property of this JellyfinReportInventorySubItem.
     *
     * @param subItemMetadata A JellyfinItemMetadata object that should be used as the new metadata for this JellyfinReportInventorySubItem. 
     * This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setSubItemMetadata(JellyfinItemMetadata subItemMetadata) {
        this.subItemMetadata = subItemMetadata;
    }

    /**
     * Retrieves the subItemMetadata property of this JellyfinReportInventorySubItem.
     *
     * @return A JellyfinItemMetadata object representing the metadata of this JellyfinReportInventorySubItem. 
     * This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinItemMetadata getSubItemMetadata() {
        return subItemMetadata;
    }
    
}
