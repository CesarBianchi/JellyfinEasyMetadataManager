package com.lariflix.jemm.reports;

import com.lariflix.jemm.dtos.JellyfinCadGenresItem;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import java.util.ArrayList;

/**
 * The JellyfinReportGenresItem class extends the JellyfinCadGenresItem class and is used to represent a genre item in a report.
 *
 * This class contains the details of a genre item, such as the name, the number of items in the genre, and other relevant details. 
 * It also contains a list of sub-items for the genre, if any.
 *
 * @author Cesar Bianchi
 * @see JellyfinCadGenresItem
 */
public class JellyfinReportGenresItem extends JellyfinCadGenresItem{

    private JellyfinItemMetadata genreMetadata = new JellyfinItemMetadata();
    private ArrayList<JellyfinReportInventorySubItem> genreEpisodes = new ArrayList();
    private int totalsubItems = 0;

    /**
     * Constructor for the JellyfinReportGenresItem class.
     *
     * This is a no-argument constructor that initializes a new instance of the JellyfinReportGenresItem class. It doesn't perform any specific actions.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportGenresItem() {
    }
    
    /**
     * Sets the item property of this JellyfinReportGenresItem.
     *
     * This method takes a JellyfinCadGenresItem object as a parameter and sets the properties of this JellyfinReportGenresItem to match the properties of the given item.
     *
     * @param it A JellyfinCadGenresItem object that should be used to set the properties of this JellyfinReportGenresItem. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setItem(JellyfinCadGenresItem it){
        this.name = it.getName();
        this.serverId = it.getServerId();
        this.id = it.getId();        
        this.channelId = it.getChannelId();
        this.type = it.getType();
        this.locationType = it.getLocationType();
        this.premiereDate = it.getPremiereDate();
        this.criticRating = it.getCriticRating();
        this.officialRating = it.getOfficialRating();
        this.communityRating = it.getCommunityRating();        
    }

    /**
     * Retrieves the genreMetadata property of this JellyfinReportGenresItem.
     *
     * @return A JellyfinItemMetadata object representing the metadata of the genre of this JellyfinReportGenresItem. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinItemMetadata getGenreMetadata() {
        return genreMetadata;
    }

    /**
     * Sets the genreMetadata property of this JellyfinReportGenresItem.
     *
     * @param genreMetadata A JellyfinItemMetadata object that should be used as the new metadata for the genre of this JellyfinReportGenresItem. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setGenreMetadata(JellyfinItemMetadata genreMetadata) {
        this.genreMetadata = genreMetadata;
    }
    
    /**
     * Sets the totalsubItems property of this JellyfinReportGenresItem.
     *
     * @param totalsubItems An integer that should be used as the new total number of sub-items for the genre of this JellyfinReportGenresItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setTotalsubItems(int totalsubItems) {
        this.totalsubItems = totalsubItems;
    }
 
    /**
     * Adds a new episode to the genreEpisodes list of this JellyfinReportGenresItem.
     *
     * @param episode A JellyfinItem object representing the episode to be added. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @param episodeMetadata A JellyfinItemMetadata object representing the metadata of the episode to be added. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void addGenreEpisode(JellyfinItem episode, JellyfinItemMetadata episodeMetadata){
        
        JellyfinReportInventorySubItem eps = new JellyfinReportInventorySubItem();
        eps.setSubItem(episode);
        eps.setSubItemMetadata(episodeMetadata);
        
        this.genreEpisodes.add(eps);        
    }

    /**
     * Retrieves the genreEpisodes property of this JellyfinReportGenresItem.
     *
     * @return An ArrayList of JellyfinReportInventorySubItem objects representing the episodes of the genre of this JellyfinReportGenresItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinReportInventorySubItem> getGenreEpisodes() {
        return genreEpisodes;
    }

    /**
     * Sets the genreEpisodes property of this JellyfinReportGenresItem.
     *
     * @param genreEpisodes An ArrayList of JellyfinReportInventorySubItem objects that should be used as the new episodes for the genre of this JellyfinReportGenresItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setGenreEpisodes(ArrayList<JellyfinReportInventorySubItem> genreEpisodes) {
        this.genreEpisodes = genreEpisodes;
    }
    
    
}
