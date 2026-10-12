package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the collection of rating entries for a media item in an NFO document.
 * <p>
 * This DTO groups one or more {@link Rating} objects and exposes convenience
 * methods for querying and manipulating the list while preserving the XML shape
 * expected by Jellyfin metadata files.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see Rating
 */
@JacksonXmlRootElement(localName = "ratings")
public class Ratings {
    /** List of rating entries contained in the ratings block. */
    @JacksonXmlProperty(localName = "rating")
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<Rating> ratings;

    /**
     * Creates an empty ratings collection.
     *
     * @since 1.0
     * @see Rating
     */
    public Ratings() {
    }

    /**
     * Returns the list of rating entries.
     *
     * @return the rating list, or {@code null} if it was not initialized
     * @since 1.0
     * @see #setRating(ArrayList)
     */
    public List<Rating> getRating() {
        return ratings;
    }

    /**
     * Sets the list of rating entries.
     *
     * @param ratings a list of ratings to store
     * @since 1.0
     * @see #getRating()
     */
    public void setRating(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    /**
     * Adds a rating to the collection.
     *
     * @param ratingParam the rating to append
     * @since 1.0
     * @see #getRating()
     */
    public void addRating(Rating ratingParam) {

        if (this.ratings == null){
            ArrayList<Rating> ratingsLoc = new ArrayList();
            ratingsLoc.add(ratingParam);
            this.ratings = ratingsLoc;
        } else {
            this.ratings.add(ratingParam); 
        }
        
    }

    /**
     * Returns the number of ratings currently stored.
     *
     * @return the total count of ratings
     * @since 1.0
     * @see #getRating()
     */
    public int size() {
        int lenght = this.ratings.size();
        return lenght;
    }
}
