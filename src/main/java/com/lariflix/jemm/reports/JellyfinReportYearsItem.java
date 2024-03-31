package com.lariflix.jemm.reports;

import java.util.ArrayList;

/**
 * The JellyfinReportYearsItem class is used to represent a year in a report.
 *
 * This class contains the details of a year, such as the name and other relevant details.
 * It also contains a list of items associated with the year, if any. It provides methods to set and retrieve these details.
 *
 * @author Cesar Bianchi
 */
public class JellyfinReportYearsItem {
    
    private String year = new String();
    private int yearMediaItems = 0;
    private ArrayList<JellyfinReportInventorySubItem> yearEpisodes = new ArrayList();
    
    /**
     * Constructor for the JellyfinReportYearsItem class.
     *
     * This constructor initializes a new instance of the JellyfinReportYearsItem class and sets the yearMediaItems property to the size of the yearEpisodes list.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportYearsItem() {
        this.yearMediaItems = this.yearEpisodes.size();
    }

    /**
     * Retrieves the year property of this JellyfinReportYearsItem.
     *
     * @return A String representing the year in this JellyfinReportYearsItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets the year property of this JellyfinReportYearsItem.
     *
     * @param yearName A String that should be used as the new year in this JellyfinReportYearsItem.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setYear(String yearName) {
        this.year = yearName;
    }

    /**
     * Retrieves the yearEpisodes property of this JellyfinReportYearsItem.
     *
     * @return An ArrayList of JellyfinReportInventorySubItem objects representing the episodes of the year in this JellyfinReportYearsItem. Each JellyfinReportInventorySubItem represents an episode and includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public ArrayList<JellyfinReportInventorySubItem> getYearEpisodes() {
        return yearEpisodes;
    }

    /**
     * Sets the yearEpisodes property of this JellyfinReportYearsItem and updates the yearMediaItems property.
     *
     * @param yearEpisodes An ArrayList of JellyfinReportInventorySubItem objects that should be used as the new episodes for the year in this JellyfinReportYearsItem. Each JellyfinReportInventorySubItem should represent an episode and include the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setYearEpisodes(ArrayList<JellyfinReportInventorySubItem> yearEpisodes) {
        this.yearEpisodes = yearEpisodes;
        this.yearMediaItems = this.yearEpisodes.size();
    }
    /**
     * Adds an episode to the yearEpisodes property of this JellyfinReportYearsItem and updates the yearMediaItems property.
     *
     * @param episode A JellyfinReportInventorySubItem object representing the episode to add. This includes the name, server ID, ID, channel ID, type, location type, premiere date, critic rating, official rating, and community rating.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void addYearEpisode(JellyfinReportInventorySubItem episode){
        this.yearEpisodes.add(episode);
        this.yearMediaItems = this.yearEpisodes.size();
    }
    /**
     * Retrieves the yearMediaItems property of this JellyfinReportYearsItem.
     *
     * @return An integer representing the total number of media items in this JellyfinReportYearsItem. This is the same as the size of the yearEpisodes list.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public int getYearMediaItems() {
        return yearMediaItems;
    }

    /**
     * Sets the yearMediaItems property of this JellyfinReportYearsItem to the size of the yearEpisodes list.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setYearMediaItems() {
        this.yearMediaItems = this.yearEpisodes.size();
    }
    
}
