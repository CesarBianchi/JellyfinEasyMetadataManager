package com.lariflix.jemm.reports;
import com.lariflix.jemm.dtos.JellyfinFolder;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import java.util.ArrayList;

/**
 * The JellyfinReportInventoryItem class extends the JellyfinFolder class and is used to represent an inventory item in a report.
 *
 * This class contains the details of an inventory item, such as the name, the number of items in the category, and other relevant details. 
 * It also contains a list of sub-items for the item, if any.
 *
 * @author Cesar Bianchi
 * @see JellyfinFolder
 */
public class JellyfinReportInventoryItem extends JellyfinFolder{
    
    private ArrayList<JellyfinReportInventorySubItem> subItems = new ArrayList();
    private JellyfinItemMetadata itemMetadata = new JellyfinItemMetadata();
    private String genres = new String();
    private String tags = new String();
    private int totalsubItems = 0;

    /**
     * Constructor for the JellyfinReportInventoryItem class.
     *
     * This is a no-argument constructor that initializes a new instance of the JellyfinReportInventoryItem class. It doesn't perform any specific actions.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportInventoryItem() {
        // constructor body
    }

    /**
     * Retrieves the subItems property of this JellyfinReportInventoryItem.
     *
     * @return An ArrayList of JellyfinReportInventorySubItem objects representing the sub-items of this JellyfinReportInventoryItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinReportInventorySubItem> getSubItems() {
        return subItems;
    }

    /**
     * Sets the subItems property of this JellyfinReportInventoryItem.
     *
     * @param subItems An ArrayList of JellyfinReportInventorySubItem objects that should be used as the new sub-items for this JellyfinReportInventoryItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setSubItems(ArrayList<JellyfinReportInventorySubItem> subItems) {
        this.subItems = subItems;
    }

    /**
     * Retrieves the totalsubItems property of this JellyfinReportInventoryItem.
     *
     * @return An integer representing the total number of sub-items of this JellyfinReportInventoryItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public int getTotalsubItems() {
        return totalsubItems;
    }

    /**
     * Sets the totalsubItems property of this JellyfinReportInventoryItem.
     *
     * @param totalsubItems An integer that should be used as the new total number of sub-items for this JellyfinReportInventoryItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setTotalsubItems(int totalsubItems) {
        this.totalsubItems = totalsubItems;
    }

    /**
     * Sets the itemMetadata property of this JellyfinReportInventoryItem.
     *
     * This method also sets the genres and tags properties based on the given itemMetadata.
     *
     * @param itemMetadata A JellyfinItemMetadata object that should be used as the new metadata for this JellyfinReportInventoryItem. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setItemMetadata(JellyfinItemMetadata itemMetadata) {
        this.itemMetadata = itemMetadata;
        
        this.setGenres();
        this.setTags();
    }

    /**
     * Retrieves the itemMetadata property of this JellyfinReportInventoryItem.
     *
     * @return A JellyfinItemMetadata object representing the metadata of this JellyfinReportInventoryItem. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinItemMetadata getItemMetadata() {
        return itemMetadata;
    }

    /**
     * Retrieves the genres property of this JellyfinReportInventoryItem.
     *
     * @return A String representing the genres of this JellyfinReportInventoryItem. The genres are returned as a comma-separated list.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public String getGenres() {
        return genres;
    }

    /**
     * Sets the genres property of this JellyfinReportInventoryItem.
     *
     * This method retrieves the genre names from the itemMetadata property and concatenates them into a comma-separated list. This list is then used as the new genres for this JellyfinReportInventoryItem.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setGenres() {        
        for (int nI = 0; nI < itemMetadata.genreItems.size(); nI++){
            this.genres =  this.genres.concat(itemMetadata.genreItems.get(nI).getName());
            
            if (nI+1 != itemMetadata.genreItems.size()){
                this.genres = this.genres.concat(", ");
            }
        }
    }

    /**
     * Retrieves the tags property of this JellyfinReportInventoryItem.
     *
     * @return A String representing the tags of this JellyfinReportInventoryItem. The tags are returned as a comma-separated list.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public String getTags() {
        return tags;
    }

    /**
     * Sets the tags property of this JellyfinReportInventoryItem.
     *
     * This method retrieves the tags from the itemMetadata property and concatenates them into a comma-separated list. This list is then used as the new tags for this JellyfinReportInventoryItem.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setTags() {
        for (int nI = 0; nI < itemMetadata.getTags().size(); nI++){
            this.tags =  this.tags.concat(itemMetadata.getTags().get(nI));
            
            if (nI+1 != itemMetadata.getTags().size()){
                this.tags = this.tags.concat(", ");
            }
        }
    }
    
    /**
     * Transforms a JellyfinFolder into a JellyfinReportInventoryItem.
     *
     * This method sets the properties of this JellyfinReportInventoryItem based on the given JellyfinFolder. 
     * This includes the channel ID, collection type, community rating, critic rating, folder content, ID, whether it is a folder, location type, metadata, name, official rating, premiere date, production year, server ID, and type.
     *
     * @param it A JellyfinFolder object that should be transformed into a JellyfinReportInventoryItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setItem(JellyfinFolder it){
        //Transform a JellyfinFolder into a JellyfinReportInventoryItem
        this.setChannelId(it.getChannelId());
        this.setCollectionType(it.getCollectionType());
        this.setCommunityRating(it.getCommunityRating());
        this.setCriticRating(it.getCriticRating());
        this.setFolderContent(it.getFolderContent());
        this.setId(it.getId());
        this.setIsFolder(it.IsFolder());
        this.setLocationType(it.getLocationType());
        this.setMetadata(it.getMetadata());
        this.setName(it.getName());
        this.setOfficialRating(it.getOfficialRating());
        this.setPremiereDate(it.getPremiereDate());
        this.setProductionYear(it.getProductionYear());
        this.setServerId(it.getServerId());
        this.setType(it.getType());
    }
    
    /**
     * Transforms a JellyfinItems into a list of JellyfinReportInventorySubItem and sets it as the sub-items of this JellyfinReportInventoryItem.
     *
     * This method creates a new JellyfinReportInventorySubItem for each item in the given JellyfinItems, sets the sub-item of the JellyfinReportInventorySubItem to the item, and adds the JellyfinReportInventorySubItem to a list. 
     * This list is then used as the new sub-items for this JellyfinReportInventoryItem. The method also sets the total number of sub-items to the size of the list.
     *
     * @param subItems A JellyfinItems object that should be transformed into a list of JellyfinReportInventorySubItem.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setSubItems(JellyfinItems subItems){
        //Transform a JellyfinItems into a list of JellyfinReportInventorySubItem
        ArrayList<JellyfinReportInventorySubItem> reportSubItems = new ArrayList();                
        for (int nI = 0; nI < subItems.items.size(); nI++){
            
            JellyfinReportInventorySubItem reportSubItem = new JellyfinReportInventorySubItem();            
            reportSubItem.setSubItem(subItems.getItems().get(nI));
            
            reportSubItems.add(reportSubItem);
        }
        
        this.subItems = reportSubItems;
        this.setTotalsubItems(this.subItems.size());
    }
    
}
