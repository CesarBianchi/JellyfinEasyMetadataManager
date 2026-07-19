package com.lariflix.jemm.utils;

import java.util.ArrayList;


/**
 * Utility class that provides a predefined list of Jellyfin content ratings.
 *
 * <p>This class maintains an internal list of rating strings commonly used by
 * Jellyfin. It exposes methods to load, reload, and retrieve those ratings as
 * either a live list or a string array suitable for UI components such as
 * combo boxes or dropdowns.
 *
 * <p>Example usage:
 * <pre>
 * JellyfinRatingList r = new JellyfinRatingList();
 * r.JellyfinRatingList(); // populate (note: this is not a constructor)
 * String[] items = r.getItems();
 * </pre>
 *
 * <p>Notes:
 * - The method named {@code JellyfinRatingList()} is not a Java constructor;
 *   it is a regular method that populates the list when invoked.
 * - The class is not thread-safe: concurrent modification of the returned
 *   list from multiple threads may produce undefined behavior.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinRatingList {
    private ArrayList<String> ratings = new ArrayList<>();
    

    /**
     * Populates the internal list with the default ratings.
     *
     * <p>Note: this method is named like a constructor but is declared with a
     * return type and therefore is not a true Java constructor. Callers can
     * invoke this method to explicitly populate the internal list, or use the
     * other accessors which ensure the list is populated when needed.
     *
     * @since 1.0
     */
    public void JellyfinRatingList(){
        this.loadRatings();
    }
    
   
    /**
     * Populates the internal ratings list with a predefined set of Jellyfin
     * content rating labels.
     *
     * <p>This method appends to the existing list; callers who want a fresh
     * set should call {@link #reloadRatings()} first.
     *
     * @since 1.0
     */
    public void loadRatings() {
        
        ratings.add("");
        ratings.add("Unrated");
        ratings.add("Approved");
        ratings.add("G");
        ratings.add("TV-G");
        ratings.add("TV-Y");
        ratings.add("TV-Y7");
        ratings.add("TV-Y7-FV");
        ratings.add("PG");
        ratings.add("TV-PG");
        ratings.add("TV-PG-D");
        ratings.add("TV-PG-L");
        ratings.add("TV-PG-S");
        ratings.add("TV-PG-V");
        ratings.add("TV-PG-DL");
        ratings.add("TV-PG-DS");
        ratings.add("TV-PG-DV");
        ratings.add("TV-PG-LS");
        ratings.add("TV-PG-LV");
        ratings.add("TV-PG-SV");
        ratings.add("TV-PG-DLS");
        ratings.add("TV-PG-DLV");
        ratings.add("TV-PG-DSV");
        ratings.add("TV-PG-LSV");
        ratings.add("TV-PG-DLSV");
        ratings.add("PG-13");
        ratings.add("TV-14");
        ratings.add("TV-14-D");
        ratings.add("TV-14-L");
        ratings.add("TV-14-S");
        ratings.add("TV-14-V");
        ratings.add("TV-14-DL");
        ratings.add("TV-14-DS");
        ratings.add("TV-14-DV");
        ratings.add("TV-14-LS");
        ratings.add("TV-14-LV");
        ratings.add("TV-14-SV");
        ratings.add("TV-14-DLS");
        ratings.add("TV-14-DLV");
        ratings.add("TV-14-DSV");
        ratings.add("TV-14-LSV");
        ratings.add("TV-14-DLSV");
        ratings.add("R");
        ratings.add("NC-17");
        ratings.add("TV-MA");
        ratings.add("TV-MA-L");
        ratings.add("TV-MA-S");
        ratings.add("TV-MA-V");
        ratings.add("TV-MA-LS");
        ratings.add("TV-MA-LV");
        ratings.add("TV-MA-SV");
        ratings.add("TV-MA-LSV");
        ratings.add("TV-X");
        ratings.add("BR-L");
        ratings.add("TV-AO");
        ratings.add("21");
        ratings.add("XXX");
        ratings.add("Banned");
    }

    /**
     * Returns the live internal ratings list.
     *
     * <p>Warning: the returned list is the internal backing list and
     * modifications to it will affect this object's state.
     *
     * @return the live {@link ArrayList} of rating strings (may be empty)
     * @since 1.0
     */
    public ArrayList<String> getRatings() {
        return ratings;
    }
   
    /**
     * Clears the current ratings and reloads the default set.
     *
     * @since 1.0
     */
    private void reloadRatings(){
        this.ratings = new ArrayList<>();
        this.loadRatings();
    }
    
    /**
     * Returns the ratings as a string array.
     *
     * <p>This method ensures the internal list is freshly loaded before
     * converting it to an array suitable for UI components such as dropdowns.
     *
     * @return an array containing the current rating labels; never {@code null}
     * @since 1.0
     */
    public String[] getItems() {    
        this.reloadRatings();
        String[] items = this.ratings.toArray(new String[ratings.size()]);
        return items;
    }
    
}
