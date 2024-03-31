package com.lariflix.jemm.reports;

import com.lariflix.jemm.dtos.JellyfinCadPeopleItem;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import java.util.ArrayList;

/**
 * The JellyfinReportPeopleItem class extends the JellyfinCadPeopleItem class and is used to represent a person in a report.
 *
 * This class contains the details of a person, such as the name, role, and other relevant details. 
 * It also contains a list of items associated with the person, if any. It provides methods to set and retrieve these details.
 *
 * @author Cesar Bianchi
 * @see JellyfinCadPeopleItem
 */
public class JellyfinReportPeopleItem extends JellyfinCadPeopleItem {

    private ArrayList<JellyfinReportInventorySubItem> peopleEpisodes = new ArrayList();
    private JellyfinItemMetadata peopleMetadata = new JellyfinItemMetadata();
    private String peoplePlace = new String();
    
    /**
     * Constructor for the JellyfinReportPeopleItem class.
     *
     * This is a no-argument constructor that initializes a new instance of the JellyfinReportPeopleItem class. It doesn't perform any specific actions.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportPeopleItem() {
    }

    /**
     * Sets the properties of this JellyfinReportPeopleItem based on the given JellyfinCadPeopleItem.
     *
     * This method sets the name, server ID, ID, premiere date, critic rating, official rating, channel ID, community rating, production year, type, and location type of this JellyfinReportPeopleItem to the corresponding properties of the given JellyfinCadPeopleItem.
     *
     * @param people A JellyfinCadPeopleItem object that should be used to set the properties of this JellyfinReportPeopleItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setItem(JellyfinCadPeopleItem people){        
        this.setName(people.getName());
        this.setServerId(people.getServerId());
        this.setId(people.getId());
        this.setPremiereDate(people.getPremiereDate());
        this.setCriticRating(people.getCriticRating());
        this.setOfficialRating(people.getOfficialRating());
        this.setChannelId(people.getChannelId());
        this.setCommunityRating(people.getCommunityRating());
        this.setProductionYear(people.getProductionYear());
        this.setType(people.getType());
        this.setLocationType(people.getLocationType());        
    }

    /**
     * Retrieves the peopleMetadata property of this JellyfinReportPeopleItem.
     *
     * @return A JellyfinItemMetadata object representing the metadata of the person in this JellyfinReportPeopleItem. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinItemMetadata getPeopleMetadata() {
        return peopleMetadata;
    }

    /**
     * Sets the peopleMetadata property of this JellyfinReportPeopleItem.
     *
     * This method sets the metadata of the person in this JellyfinReportPeopleItem to the given JellyfinItemMetadata. 
     * If the JellyfinItemMetadata has at least one production location, it also sets the peoplePlace of this JellyfinReportPeopleItem to the first production location.
     *
     * @param peopleMetadata A JellyfinItemMetadata object that should be used as the new metadata for the person in this JellyfinReportPeopleItem. 
     * This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setPeopleMetadata(JellyfinItemMetadata peopleMetadata) {
        this.peopleMetadata = peopleMetadata;
        
        if ((peopleMetadata.getProductionlocations() != null) && (peopleMetadata.getProductionlocations().size() > 0)){
            this.peoplePlace = peopleMetadata.getProductionlocations().get(0);
        }
        
    }
    
    /**
     * Adds an episode to the peopleEpisodes property of this JellyfinReportPeopleItem.
     *
     * This method creates a new JellyfinReportInventorySubItem, sets the sub-item and sub-item metadata of the JellyfinReportInventorySubItem to the given episode and episode metadata, and adds the JellyfinReportInventorySubItem to the peopleEpisodes list.
     *
     * @param episode A JellyfinItem object representing the episode to add. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @param episodeMetadata A JellyfinItemMetadata object representing the metadata of the episode to add. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void addPeopleEpisode(JellyfinItem episode, JellyfinItemMetadata episodeMetadata){
        
        JellyfinReportInventorySubItem eps = new JellyfinReportInventorySubItem();
        eps.setSubItem(episode);
        eps.setSubItemMetadata(episodeMetadata);
        
        this.peopleEpisodes.add(eps);        
    }

    /**
     * Retrieves the peopleEpisodes property of this JellyfinReportPeopleItem.
     *
     * @return An ArrayList of JellyfinReportInventorySubItem objects representing the episodes of the person in this JellyfinReportPeopleItem. Each JellyfinReportInventorySubItem represents an episode and includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinReportInventorySubItem> getPeopleEpisodes() {
        return peopleEpisodes;
    }

    /**
     * Sets the peopleEpisodes property of this JellyfinReportPeopleItem.
     *
     * @param peopleEpisodes An ArrayList of JellyfinReportInventorySubItem objects that should be used as the new episodes for the person in this JellyfinReportPeopleItem. Each JellyfinReportInventorySubItem should represent an episode and include the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setPeopleEpisodes(ArrayList<JellyfinReportInventorySubItem> peopleEpisodes) {
        this.peopleEpisodes = peopleEpisodes;
    }

    /**
     * Retrieves the peoplePlace property of this JellyfinReportPeopleItem.
     *
     * @return A String representing the place of the person in this JellyfinReportPeopleItem. This could be the location where the person was born or currently resides.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public String getPeoplePlace() {
        return peoplePlace;
    }

    /**
     * Sets the peoplePlace property of this JellyfinReportPeopleItem.
     *
     * @param peoplePlace A String that should be used as the new place for the person in this JellyfinReportPeopleItem. This could be the location where the person was born or currently resides.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setPeoplePlace(String peoplePlace) {
        this.peoplePlace = peoplePlace;
    }
    
}

