
package com.lariflix.jemm.reports;

import java.util.ArrayList;

/**
 * The JellyfinReportTagsItem class is used to represent a tag in a report.
 *
 * This class contains the details of a tag, such as the name and other relevant details. 
 * It also contains a list of items associated with the tag, if any. It provides methods to set and retrieve these details.
 *
 * @author Cesar Bianchi
 */
public class JellyfinReportTagsItem {
    private String tagName = new String();
    private int tagMediaItems = 0;
    private ArrayList<JellyfinReportInventorySubItem> tagEpisodes = new ArrayList();

    /**
     * Constructor for the JellyfinReportTagsItem class.
     *
     * This constructor initializes a new instance of the JellyfinReportTagsItem class and sets the tagMediaItems property to the size of the tagEpisodes list.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportTagsItem() {
        this.tagMediaItems = this.tagEpisodes.size();
    }

    /**
     * Retrieves the tagName property of this JellyfinReportTagsItem.
     *
     * @return A String representing the name of the tag in this JellyfinReportTagsItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Sets the tagName property of this JellyfinReportTagsItem.
     *
     * @param tagName A String that should be used as the new name of the tag in this JellyfinReportTagsItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    
    /**
     * Retrieves the tagEpisodes property of this JellyfinReportTagsItem.
     *
     * @return An ArrayList of JellyfinReportInventorySubItem objects representing the episodes of the tag in this JellyfinReportTagsItem. 
     * Each JellyfinReportInventorySubItem represents an episode and includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinReportInventorySubItem> getTagEpisodes() {
        return tagEpisodes;
    }

    /**
     * Sets the tagEpisodes property of this JellyfinReportTagsItem.
     *
     * @param tagEpisodes An ArrayList of JellyfinReportInventorySubItem objects that should be used as the new episodes for the tag in this JellyfinReportTagsItem. 
     * Each JellyfinReportInventorySubItem should represent an episode and include the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setTagEpisodes(ArrayList<JellyfinReportInventorySubItem> tagEpisodes) {
        this.tagEpisodes = tagEpisodes;
        this.tagMediaItems = this.tagEpisodes.size();
    }
    
    /**
     * Adds an episode to the tagEpisodes property of this JellyfinReportTagsItem and updates the tagMediaItems property.
     *
     * @param episode A JellyfinReportInventorySubItem object representing the episode to add. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void addTagEpisode(JellyfinReportInventorySubItem episode){
        this.tagEpisodes.add(episode);
        this.tagMediaItems = this.tagEpisodes.size();
    }

    /**
     * Retrieves the tagMediaItems property of this JellyfinReportTagsItem.
     *
     * @return An integer representing the total number of media items in this JellyfinReportTagsItem. This is the same as the size of the tagEpisodes list.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public int getTagMediaItems() {
        return tagMediaItems;
    }

    /**
     * Sets the tagMediaItems property of this JellyfinReportTagsItem to the size of the tagEpisodes list.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setTagMediaItems() {
        this.tagMediaItems = this.tagEpisodes.size();
    }
    
    
    
}
