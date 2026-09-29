
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the provider IDs for a media item in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JellyfinProviderIds {
    @JsonProperty("Imdb") 
    public String imdb;
    @JsonProperty("Tmdb") 
    public String tmdb;
    @JsonProperty("TmdbCollection") 
    public String tmdbCollection;
    
    //new ones (added Sep-2026)
    @JsonProperty("Tvdb") 
    public String tvdb;  
    @JsonProperty("TvRage") 
    public String tvRage;    
    @JsonProperty("MusicBrainzArtist")
    public String musicBrainzArtist;
    @JsonProperty("MusicBrainzAlbum")
    public String musicBrainzAlbum;
    @JsonProperty("MusicBrainzReleaseGroup")
    public String musicBrainzReleaseGroup;
    @JsonProperty("MusicBrainzTrack")
    public String musicBrainzTrack;
    @JsonProperty("MusicBrainzReleaseTrack")
    public String musicBrainzReleaseTrack;
    @JsonProperty("AniDB")
    public String aniDB;
    @JsonProperty("AniList")
    public String aniList;
    @JsonProperty("MyAnimeList")
    public String myAnimeList;
    @JsonProperty("GoogleBooks")
    public String googleBooks;
    @JsonProperty("ISBN")
    public String isbn;
    @JsonProperty("OpenLibrary")
    public String openLibrary;
    @JsonProperty("Zap2It")
    public String zap2It;
    @JsonProperty("AudioDbArtist")
    public String audioDbArtist;
    @JsonProperty("AudioDbAlbum")
    public String audioDbAlbum;
            
            
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

    public String getTvdb() {
        return tvdb;
    }

    public void setTvdb(String tvdb) {
        this.tvdb = tvdb;
    }

    public String getTvRage() {
        return tvRage;
    }

    public void setTvRage(String tvRage) {
        this.tvRage = tvRage;
    }

    public String getMusicBrainzArtist() {
        return musicBrainzArtist;
    }

    public void setMusicBrainzArtist(String musicBrainzArtist) {
        this.musicBrainzArtist = musicBrainzArtist;
    }

    public String getMusicBrainzAlbum() {
        return musicBrainzAlbum;
    }

    public void setMusicBrainzAlbum(String musicBrainzAlbum) {
        this.musicBrainzAlbum = musicBrainzAlbum;
    }

    public String getMusicBrainzReleaseGroup() {
        return musicBrainzReleaseGroup;
    }

    public void setMusicBrainzReleaseGroup(String musicBrainzReleaseGroup) {
        this.musicBrainzReleaseGroup = musicBrainzReleaseGroup;
    }

    public String getMusicBrainzTrack() {
        return musicBrainzTrack;
    }

    public void setMusicBrainzTrack(String musicBrainzTrack) {
        this.musicBrainzTrack = musicBrainzTrack;
    }

    public String getMusicBrainzReleaseTrack() {
        return musicBrainzReleaseTrack;
    }

    public void setMusicBrainzReleaseTrack(String musicBrainzReleaseTrack) {
        this.musicBrainzReleaseTrack = musicBrainzReleaseTrack;
    }

    public String getAniDB() {
        return aniDB;
    }

    public void setAniDB(String aniDB) {
        this.aniDB = aniDB;
    }

    public String getAniList() {
        return aniList;
    }

    public void setAniList(String aniList) {
        this.aniList = aniList;
    }

    public String getMyAnimeList() {
        return myAnimeList;
    }

    public void setMyAnimeList(String myAnimeList) {
        this.myAnimeList = myAnimeList;
    }

    public String getGoogleBooks() {
        return googleBooks;
    }

    public void setGoogleBooks(String googleBooks) {
        this.googleBooks = googleBooks;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOpenLibrary() {
        return openLibrary;
    }

    public void setOpenLibrary(String openLibrary) {
        this.openLibrary = openLibrary;
    }

    public String getZap2It() {
        return zap2It;
    }

    public void setZap2It(String zap2It) {
        this.zap2It = zap2It;
    }

    public String getAudioDbArtist() {
        return audioDbArtist;
    }

    public void setAudioDbArtist(String audioDbArtist) {
        this.audioDbArtist = audioDbArtist;
    }

    public String getAudioDbAlbum() {
        return audioDbAlbum;
    }

    public void setAudioDbAlbum(String audioDbAlbum) {
        this.audioDbAlbum = audioDbAlbum;
    }
    
    
    
}
