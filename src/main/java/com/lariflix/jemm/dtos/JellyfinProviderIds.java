
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the provider IDs for a media item in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinProviderIds {
    @JsonProperty("Imdb") 
    public String imdb;
    @JsonProperty("Tmdb") 
    public String tmdb;
    @JsonProperty("TmdbCollection") 
    public String tmdbCollection;

    /**
     * Default constructor for JellyfinProviderIds.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinProviderIds() {
    }

    /**
     * Returns the IMDB ID of the media item.
     *
     * @return The IMDB ID of the media item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getImdb() {
        return imdb;
    }

    /**
     * Sets the IMDB ID of the media item.
     *
     * @param imdb The new IMDB ID of the media item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    /**
     * Returns the TMDB ID of the media item.
     *
     * @return The TMDB ID of the media item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getTmdb() {
        return tmdb;
    }

    /**
     * Sets the TMDB ID of the media item.
     *
     * @param tmdb The new TMDB ID of the media item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setTmdb(String tmdb) {
        this.tmdb = tmdb;
    }

    /**
     * Returns the TMDB Collection ID of the media item.
     *
     * @return The TMDB Collection ID of the media item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getTmdbCollection() {
        return tmdbCollection;
    }

    /**
     * Sets the TMDB Collection ID of the media item.
     *
     * @param tmdbCollection The new TMDB Collection ID of the media item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setTmdbCollection(String tmdbCollection) {
        this.tmdbCollection = tmdbCollection;
    }
    
    
    
}
