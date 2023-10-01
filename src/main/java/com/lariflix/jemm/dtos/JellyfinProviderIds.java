
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinProviderIds {
    @JsonProperty("Imdb") 
    public String imdb;
    @JsonProperty("Tmdb") 
    public String tmdb;
    @JsonProperty("TmdbCollection") 
    public String tmdbCollection;

    public JellyfinProviderIds() {
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getTmdb() {
        return tmdb;
    }

    public void setTmdb(String tmdb) {
        this.tmdb = tmdb;
    }

    public String getTmdbCollection() {
        return tmdbCollection;
    }

    public void setTmdbCollection(String tmdbCollection) {
        this.tmdbCollection = tmdbCollection;
    }
    
    
    
}
