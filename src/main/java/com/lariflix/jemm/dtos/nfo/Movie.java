
package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.lariflix.jemm.utils.TransformDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a movie metadata object serialized in the Jellyfin NFO format.
 * This DTO groups the fields used to describe a media item such as the title,
 * plot, premiere date, ratings, genres, tags, actors, and identifiers used by
 * Jellyfin and the import/export process.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 * @see Ratings
 * @see Uniqueid
 */
@JacksonXmlRootElement(localName = "movie")
public class Movie { 
    private String title;
    private String originaltitle;
    private String plot;
    private String tagline;
    private Ratings ratings;
    private String mpaa;
    private String year;
    private Date premiered;
    private String studio;
    
    @JacksonXmlProperty(localName = "rating")
    @JacksonXmlElementWrapper(useWrapping = false)
    private String rating;
    
    @JacksonXmlProperty(localName = "genre")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> genre;
    
    @JacksonXmlProperty(localName = "tag")
    @JacksonXmlElementWrapper(useWrapping = false)    
    private List<String> tag;
    
    private String country;
    private Set set;
    
    @JacksonXmlProperty(localName = "uniqueid")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Uniqueid> uniqueid;
    
    private String imdbid;
    private String tmdbid;
    
    private String credits;
    private String director;

    @JacksonXmlProperty(localName = "actor")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Actor> actor;
    
    private Thumb thumb;
    private Fanart fanart;

    /**
     * Creates a new empty movie metadata instance and initializes the default
     * field values.
     *
     * @since 1.0
     * @see #initialize()
     */
    public Movie() {
        this.initialize();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginaltitle() {
        return originaltitle;
    }

    public void setOriginaltitle(String originaltitle) {
        this.originaltitle = originaltitle;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings rats) {
        this.ratings = rats;
        
        Rating newRate = this.ratings.getRating().get(0);
        this.rating = newRate.getValue();        
    }

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public Date getPremiered() {
        return premiered;
    }
    
    public String getPremieredSimple(){
        TransformDateFormat transforDate = new TransformDateFormat();
        Date fullFormat = this.getPremiered();
        String simpleFormat = transforDate.getSimpleDateFromFull(fullFormat);
        return simpleFormat;
    }

    public void setPremiered(Date premiered) {
        this.premiered = premiered;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
    
    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public List<Uniqueid> getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(List<Uniqueid> uniq) {
        this.uniqueid = uniq;
        
        for (int nI = 0; nI < uniq.size(); nI++){
            if (uniq.get(nI).getType().trim().toUpperCase().equals("IMDB")){
                if (this.getImdbid().isEmpty()){
                    this.setImdbid(uniq.get(nI).getValue());
                }
            } else if (uniq.get(nI).getType().trim().toUpperCase().equals("TMDB")) {
                if (this.getTmdbid().isEmpty()){
                    this.setTmdbid(uniq.get(nI).getValue());
                }
            }
        }
        
    }
    
    public void addUniqueid(Uniqueid uniq){
        if (this.uniqueid == null){
            ArrayList<Uniqueid> uniqList = new ArrayList();
            uniqList.add(uniq);
            this.uniqueid = uniqList;
        } else {
            this.uniqueid.add(uniq);    
        }
        
        
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Actor> getActor() {
        return actor;
    }

    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }

    public Thumb getThumb() {
        return thumb;
    }

    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    public Fanart getFanart() {
        return fanart;
    }

    public void setFanart(Fanart fanart) {
        this.fanart = fanart;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbid() {
        return imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
        
        Uniqueid uniq = new Uniqueid();
        uniq.setType("imdb");
        uniq.setDefault(true);
        uniq.setValue(imdbid.trim());
        this.addUniqueid(uniq);        
    }

    public String getTmdbid() {
        return tmdbid;
    }

    public void setTmdbid(String tmdbid) {
        this.tmdbid = tmdbid;        
        Uniqueid uniq = new Uniqueid();
        uniq.setType("tmdb");
        uniq.setDefault(true);
        uniq.setValue(tmdbid.trim());
        this.addUniqueid(uniq);        
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String ratingParam) {
        this.rating = ratingParam;
        
        Rating rateLoc = new Rating();
        rateLoc.setValue(this.rating);
        rateLoc.setVotes(0);
        
        Ratings ratingsLoc = new Ratings();
        ratingsLoc.addRating(rateLoc);
        
        this.ratings = ratingsLoc;
    }

    private void initialize() {
        this.setTitle("");
        this.setOriginaltitle("");
        this.setPlot("");
        this.setTagline("");
        this.setMpaa("");
        this.setYear("");
        this.setStudio("");
        this.setCountry("");
        this.setImdbid("");
        this.setTmdbid("");
        this.setCredits("");
        this.setDirector("");
        //this.setRating("");
        
    }
    
}

