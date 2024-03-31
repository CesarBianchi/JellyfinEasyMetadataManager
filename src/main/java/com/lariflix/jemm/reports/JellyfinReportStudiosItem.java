
package com.lariflix.jemm.reports;

import com.lariflix.jemm.dtos.JellyfinCadStudioItem;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import java.util.ArrayList;

/**
 * The JellyfinReportStudiosItem class extends the JellyfinCadStudioItem class and is used to represent a studio in a report.
 *
 * This class contains the details of a studio, such as the name and other relevant details. 
 * It also contains a list of items associated with the studio, if any. It provides methods to set and retrieve these details.
 *
 * @author Cesar Bianchi
 * @see JellyfinCadStudioItem
 */
public class JellyfinReportStudiosItem extends JellyfinCadStudioItem{
    
    private JellyfinItemMetadata studioMetadata = new JellyfinItemMetadata();
    private ArrayList<JellyfinReportInventorySubItem> studioEpisodes = new ArrayList();
    private int totalsubItems = 0;

     /**
     * Constructor for the JellyfinReportStudiosItem class.
     *
     * This is a no-argument constructor that initializes a new instance of the JellyfinReportStudiosItem class. It doesn't perform any specific actions.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportStudiosItem() {
    }
    
    /**
     * Sets the properties of this JellyfinReportStudiosItem based on the given JellyfinCadStudioItem.
     *
     * This method sets the name, server ID, ID, channel ID, type, and location type of this JellyfinReportStudiosItem to the corresponding properties of the given JellyfinCadStudioItem.
     *
     * @param it A JellyfinCadStudioItem object that should be used to set the properties of this JellyfinReportStudiosItem. This includes the name, server ID, ID, channel ID, type, and location type.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setItem(JellyfinCadStudioItem it){
        this.name = it.getName();
        this.serverId = it.getServerId();
        this.id = it.getId();        
        this.channelId = it.getChannelId();
        this.type = it.getType();
        this.locationType = it.getLocationType();   
    }

    /**
     * Retrieves the studioMetadata property of this JellyfinReportStudiosItem.
     *
     * @return A JellyfinItemMetadata object representing the metadata of the studio in this JellyfinReportStudiosItem. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinItemMetadata getStudioMetadata() {
        return studioMetadata;
    }

    /**
     * Sets the studioMetadata property of this JellyfinReportStudiosItem.
     *
     * @param studiosMetadata A JellyfinItemMetadata object that should be used as the new metadata for the studio in this JellyfinReportStudiosItem. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setStudioMetadata(JellyfinItemMetadata studiosMetadata) {
        this.studioMetadata = studiosMetadata;
    }
    
    /**
     * Sets the totalsubItems property of this JellyfinReportStudiosItem.
     *
     * @param totalsubItems An integer that should be used as the new total number of sub-items in this JellyfinReportStudiosItem. This represents the total number of items associated with the studio.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setTotalsubItems(int totalsubItems) {
        this.totalsubItems = totalsubItems;
    }
    
    /**
     * Adds an episode to the studioEpisodes property of this JellyfinReportStudiosItem.
     *
     * This method creates a new JellyfinReportInventorySubItem, sets the sub-item and sub-item metadata of the JellyfinReportInventorySubItem to the given episode and episode metadata, and adds the JellyfinReportInventorySubItem to the studioEpisodes list.
     *
     * @param episode A JellyfinItem object representing the episode to add. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @param episodeMetadata A JellyfinItemMetadata object representing the metadata of the episode to add. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void addStudioEpisode(JellyfinItem episode, JellyfinItemMetadata episodeMetadata){
        
        JellyfinReportInventorySubItem eps = new JellyfinReportInventorySubItem();
        eps.setSubItem(episode);
        eps.setSubItemMetadata(episodeMetadata);
        
        this.studioEpisodes.add(eps);        
    }
    /**
     * Retrieves the studioEpisodes property of this JellyfinReportStudiosItem.
     *
     * @return An ArrayList of JellyfinReportInventorySubItem objects representing the episodes of the studio in this JellyfinReportStudiosItem. Each JellyfinReportInventorySubItem represents an episode and includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinReportInventorySubItem> getStudioEpisodes() {
        return studioEpisodes;
    }

    /**
     * Sets the studioEpisodes property of this JellyfinReportStudiosItem.
     *
     * @param studiosEpisodes An ArrayList of JellyfinReportInventorySubItem objects that should be used as the new episodes for the studio in this JellyfinReportStudiosItem. Each JellyfinReportInventorySubItem should represent an episode and include the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setStudioEpisodes(ArrayList<JellyfinReportInventorySubItem> studiosEpisodes) {
        this.studioEpisodes = studiosEpisodes;
    }
}
