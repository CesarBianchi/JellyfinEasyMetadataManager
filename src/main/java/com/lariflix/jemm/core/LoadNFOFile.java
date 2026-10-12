
package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.nfo.JemmNFO;
import com.lariflix.jemm.dtos.nfo.JemmNFODiffs;
import com.lariflix.jemm.dtos.nfo.Movie;
import com.lariflix.jemm.utils.TransformDateFormat;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Loads metadata from an NFO file, exposes its contents as a Swing tree, and
 * calculates differences between movie metadata and a Jellyfin item.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 * @see Movie
 * @see JemmNFODiffs
 */
public class LoadNFOFile {
    private String nfoFilePath = new String();
    private String NFOType = new String();    
    private JemmNFO NFOObject = new JemmNFO();
    private ArrayList<JemmNFODiffs> differences = new ArrayList();
    
    
    /**
     * Creates a loader with no NFO file path configured.
     *
     * @since 1.0
     * @see #setNfoFilePath(String)
     * @see #loadXMLFile()
     */
    public LoadNFOFile() {
    
    }
    
    /**
     * Creates a loader for the specified NFO file and detects its media type.
     *
     * @param cFile path to the NFO file
     * @since 1.0
     * @see #setNfoFilePath(String)
     * @see #getNFOType()
     */
    public LoadNFOFile(String cFile) {
        this.setNfoFilePath(cFile);
        this.loadNFOType();
    }
    
    /**
     * Returns the configured NFO file path.
     *
     * @return path to the NFO file
     * @since 1.0
     * @see #setNfoFilePath(String)
     */
    public String getNfoFilePath() {
        return nfoFilePath;
    }

    /**
     * Sets the path to the NFO file to load.
     *
     * @param nfoFilePath path to the NFO file
     * @since 1.0
     * @see #getNfoFilePath()
     * @see #loadXMLFile()
     */
    public void setNfoFilePath(String nfoFilePath) {
        this.nfoFilePath = nfoFilePath;
    }
    
    /**
     * Returns the differences collected for the loaded movie metadata.
     *
     * @return the mutable list of metadata differences
     * @since 1.0
     * @see JemmNFODiffs
     * @see #loadDifferences(String, JellyfinItem)
     */
    public ArrayList<JemmNFODiffs> getDifferences() {
        return differences;
    }

    /**
     * Replaces the list of collected metadata differences.
     *
     * @param differences list of differences to store
     * @since 1.0
     * @see #getDifferences()
     * @see JemmNFODiffs
     */
    public void setDifferences(ArrayList<JemmNFODiffs> differences) {
        this.differences = differences;
    }

    /**
     * Appends one metadata difference to the collected results.
     *
     * @param difference difference to add
     * @since 1.0
     * @see JemmNFODiffs
     * @see #getDifferences()
     */
    public void addDifference(JemmNFODiffs difference){
        this.differences.add(difference);
    }
    
    /**
     * Detects the media type by checking for known NFO document elements.
     *
     * @throws IOException if the configured file cannot be read
     * @since 1.0
     * @see #getNFOType()
     * @see #setNfoFilePath(String)
     */
    private void setNFOType() throws IOException {
        String cNFOFIle = this.getNfoFilePath();
        String content = Files.readString(Path.of(cNFOFIle));

        if (content.contains("<movie>")) {
            this.NFOType = "VIDEO";
        } else if (content.contains("<tvshow>")) {
            this.NFOType = "TV SHOW";
        } else if (content.contains("<episodedetails>")) {
            this.NFOType = "EPISODES";            
        } else if (content.contains("<album>")) {
            this.NFOType = "AUDIO";
        } else if (content.contains("<track>")) {
            this.NFOType = "AUDIO";
        }        

    }

    /**
     * Returns the detected media type, such as {@code VIDEO} or {@code AUDIO}.
     *
     * @return detected media type, or an empty string when it is not recognized
     * @since 1.0
     * @see #setNFOType()
     */
    public String getNFOType() {
        return NFOType;
    }

    /**
     * Detects the NFO media type and loads movie metadata when the type is video.
     *
     * @throws IOException if an I/O error occurs while accessing the NFO file
     * @since 1.0
     * @see #getNFOType()
     * @see #getNFOObject()
     * @see #loadNFOForMovie()
     */
    public void loadXMLFile() throws IOException{
        //1* Identify the type of media into NFO File
        this.loadNFOType();                
        if (!this.getNFOType().isEmpty()){            
            if (this.getNFOType().equals("VIDEO")){                               
                this.NFOObject.setMovie(this.loadNFOForMovie());
            }
        } else {
            System.out.println("No NFO File defined to load.");
        }
    }
    
    /**
     * Detects the NFO media type if it has not already been set.
     *
     * @since 1.0
     * @see #setNFOType()
     * @see #getNFOType()
     */
    private void loadNFOType() {
        if (this.getNFOType().isEmpty()){
            try {
                this.setNFOType();
            } catch (IOException ex) {
                System.getLogger(LoadNFOFile.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }    
    
    /**
     * Deserializes the configured NFO file into movie metadata and trims its text.
     *
     * @return parsed movie metadata, or an empty movie object if deserialization fails
     * @since 1.0
     * @see Movie
     * @see XmlMapper
     * @see #trimSpaces(Movie)
     */
    private Movie loadNFOForMovie() {
        Movie movie = new Movie();
        File NFOFile = new File(this.getNfoFilePath());
        XmlMapper xmlMapper = new XmlMapper();
        
        try {
            xmlMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            movie = xmlMapper.readValue(NFOFile, Movie.class);
            
            //Cut spaces in most commom string attributes
            movie = this.trimSpaces(movie);
            
        } catch (IOException ex) {
            System.getLogger(LoadNFOFile.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return movie;
    }

    /**
     * Returns the NFO metadata container populated by {@link #loadXMLFile()}.
     *
     * @return the NFO metadata container
     * @since 1.0
     * @see JemmNFO
     * @see #loadXMLFile()
     */
    public JemmNFO getNFOObject() {
        return NFOObject;
    }

    /**
     * Builds a Swing tree containing the NFO file path and supported metadata.
     *
     * @return root node of the NFO content tree
     * @since 1.0
     * @see DefaultMutableTreeNode
     * @see #loadMovieTree()
     */
    public DefaultMutableTreeNode getTree() {
        
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("File: " + this.nfoFilePath);
        
        if (this.getNFOType().equals("VIDEO")){
            DefaultMutableTreeNode movieNode  = this.loadMovieTree();
            node.add(movieNode);
            
        } else if (this.getNFOType().equals("AUDIO")){
            //TO DO TO DO
        }
        
        return node;
    }
    
    /**
     * Builds a tree branch containing the loaded movie metadata and its lists.
     *
     * @return tree node representing the movie metadata
     * @since 1.0
     * @see Movie
     * @see DefaultMutableTreeNode
     */
    private DefaultMutableTreeNode loadMovieTree(){
        
        DefaultMutableTreeNode movieNode = new DefaultMutableTreeNode("Movie");
        movieNode.add(new DefaultMutableTreeNode("Title: " + this.NFOObject.getMovie().getTitle()));
        movieNode.add(new DefaultMutableTreeNode("Original Title: " + this.NFOObject.getMovie().getOriginaltitle()));
        movieNode.add(new DefaultMutableTreeNode("Overview: " + this.NFOObject.getMovie().getPlot()));
        movieNode.add(new DefaultMutableTreeNode("Year: " + this.NFOObject.getMovie().getYear()));
        movieNode.add(new DefaultMutableTreeNode("Premiere Date: " + this.NFOObject.getMovie().getPremieredSimple()));
        movieNode.add(new DefaultMutableTreeNode("Studio: " + this.NFOObject.getMovie().getStudio()));
        movieNode.add(new DefaultMutableTreeNode("Country: " + this.NFOObject.getMovie().getCountry()));
        movieNode.add(new DefaultMutableTreeNode("Credits: " + this.NFOObject.getMovie().getCredits()));
        movieNode.add(new DefaultMutableTreeNode("IMDB Id: " + this.NFOObject.getMovie().getImdbid()));    
        movieNode.add(new DefaultMutableTreeNode("TMDB Id: " + this.NFOObject.getMovie().getTmdbid()));    
        
        //Ratings
        if (this.NFOObject.getMovie().getRatings() != null){
            DefaultMutableTreeNode movieRatings = new DefaultMutableTreeNode("Ratings");
            for (int nI = 0; nI < this.NFOObject.getMovie().getRatings().size(); nI++ ){
                DefaultMutableTreeNode rating = new DefaultMutableTreeNode("Rating");

                rating.add(new DefaultMutableTreeNode("Value: " + this.NFOObject.getMovie().getRatings().getRating().get(nI).getValue() ));
                rating.add(new DefaultMutableTreeNode("Votes: " + this.NFOObject.getMovie().getRatings().getRating().get(nI).getVotes() ));
                movieRatings.add(rating);
            }
            movieNode.add(movieRatings);
        }
                
        //Genres
        if (this.NFOObject.getMovie().getGenre() != null){
            DefaultMutableTreeNode movieGenres = new DefaultMutableTreeNode("Genres");
            for (int nI = 0; nI < this.NFOObject.getMovie().getGenre().size(); nI++ ){            
                movieGenres.add(new DefaultMutableTreeNode("Genre: " + this.NFOObject.getMovie().getGenre().get(nI) ));            
            }
            movieNode.add(movieGenres);
        }
        
        //Tags
        if (this.NFOObject.getMovie().getTag() != null){
            DefaultMutableTreeNode movieTags = new DefaultMutableTreeNode("Tags");
            for (int nI = 0; nI < this.NFOObject.getMovie().getTag().size(); nI++ ){            
                movieTags.add(new DefaultMutableTreeNode("Tag: " + this.NFOObject.getMovie().getTag().get(nI) ));            
            }
            movieNode.add(movieTags);
        }
            
        //Actors
        if (this.NFOObject.getMovie().getActor() != null){
            DefaultMutableTreeNode movieStaff = new DefaultMutableTreeNode("Staff");
            for (int nI = 0; nI < this.NFOObject.getMovie().getActor().size(); nI++ ){            
                DefaultMutableTreeNode people = new DefaultMutableTreeNode("Actor");

                people.add(new DefaultMutableTreeNode("Name: " + this.NFOObject.getMovie().getActor().get(nI).getName() ));
                people.add(new DefaultMutableTreeNode("Role: " + this.NFOObject.getMovie().getActor().get(nI).getRole() ));
                movieStaff.add(people);
            }
            movieNode.add(movieStaff);
        }
        
        return movieNode;
    }

    /**
     * Calculates and appends metadata differences for the supported NFO media type.
     * Currently, comparisons are performed for video metadata only.
     *
     * @param itemID identifier of the Jellyfin item being compared
     * @param itemObj current Jellyfin item metadata
     * @since 1.0
     * @see JellyfinItem
     * @see JemmNFODiffs
     * @see #getDifferences()
     */
    public void loadDifferences(String itemID, JellyfinItem itemObj) {
        
        if (this.getNFOType().equals("VIDEO")){
            this.loadMovieDifferences(itemID,itemObj);
            
        } else if (this.getNFOType().equals("AUDIO")){
            //TO DO TO DO
        }
        
    }

    /**
     * Compares loaded movie metadata with the corresponding Jellyfin item fields.
     *
     * @param itemID identifier of the Jellyfin item being compared
     * @param itemObj current Jellyfin item metadata
     * @since 1.0
     * @see JellyfinItem
     * @see JemmNFODiffs
     * @see #addDifference(JemmNFODiffs)
     */
    private void loadMovieDifferences(String itemID, JellyfinItem itemObj) {
        JemmNFODiffs diff = new JemmNFODiffs();
        
        //Name        
        if (!this.NFOObject.getMovie().getTitle().equals(itemObj.getItemMetadata().getName())){
            diff = new JemmNFODiffs("Name", itemObj.getItemMetadata().getName(), this.NFOObject.getMovie().getTitle() );
            this.addDifference(diff);
        }
        
        
        //Original Title
        if (!this.NFOObject.getMovie().getTitle().equals(itemObj.getItemMetadata().getOriginalTitle())){
            diff = new JemmNFODiffs( "Original Title", itemObj.getItemMetadata().getOriginalTitle(), this.NFOObject.getMovie().getTitle() );
            this.addDifference(diff);
        }
        
        
        //Sort Name
        if (!this.NFOObject.getMovie().getTitle().equals(itemObj.getItemMetadata().getSortName())){
            diff = new JemmNFODiffs( "Sort Name", itemObj.getItemMetadata().getSortName(), this.NFOObject.getMovie().getTitle() );
            this.addDifference(diff);
        }
        
        //Created Date
        if (this.NFOObject.getMovie().getPremieredSimple() != null){
            String simpleDate = new TransformDateFormat().getSimpleDateFromFull(itemObj.getItemMetadata().getDateCreated());
            if (!this.NFOObject.getMovie().getPremieredSimple().equals(simpleDate)){
                diff = new JemmNFODiffs( "Created Date", simpleDate, this.NFOObject.getMovie().getPremieredSimple() );
                this.addDifference(diff);
            }
        }
        
        //Premiere Date
        if (this.NFOObject.getMovie().getPremieredSimple() != null){
            String sDate = new TransformDateFormat().getSimpleDateFromFull(itemObj.getItemMetadata().getPremiereDate());
            if (!this.NFOObject.getMovie().getPremieredSimple().equals(sDate)){
                diff = new JemmNFODiffs( "Premiere Date", sDate, this.NFOObject.getMovie().getPremieredSimple() );
                this.addDifference(diff);
            }
        }
        
        //Critic Rating
        if (this.NFOObject.getMovie().getRatings() != null){
            if (this.NFOObject.getMovie().getRatings().getRating().size() > 0){
                if (!this.NFOObject.getMovie().getRatings().getRating().get(0).getValue().equals(Integer.toString(itemObj.getItemMetadata().getCriticRating() ))){
                    diff = new JemmNFODiffs( "Critic Rating", Integer.toString(itemObj.getItemMetadata().getCriticRating()), this.NFOObject.getMovie().getRatings().getRating().get(0).getValue() );
                    this.addDifference(diff);
                }
            }
        }
        
        //Community Rating
        if (this.NFOObject.getMovie().getRatings() != null){
            if (this.NFOObject.getMovie().getRatings().getRating().size() > 0){
                if (!this.NFOObject.getMovie().getRatings().getRating().get(0).getValue().equals(Integer.toString(itemObj.getItemMetadata().getCommunityRating() ))){
                    diff = new JemmNFODiffs( "Community Rating", Integer.toString(itemObj.getItemMetadata().getCommunityRating()), this.NFOObject.getMovie().getRatings().getRating().get(0).getValue() );
                    this.addDifference(diff);
                }
            }
        }
        
        //Overview                
        if (!this.NFOObject.getMovie().getPlot().equals(itemObj.getItemMetadata().getOverview() )){
            diff = new JemmNFODiffs( "Overview", itemObj.getItemMetadata().getOverview(), this.NFOObject.getMovie().getPlot() );
            this.addDifference(diff);
        }
        
        
        //Year        
        if (!this.NFOObject.getMovie().getYear().equals(Integer.toString(itemObj.getItemMetadata().getProductionYear() ))){
            diff = new JemmNFODiffs( "Year", Integer.toString(itemObj.getItemMetadata().getProductionYear()), this.NFOObject.getMovie().getYear() );
            this.addDifference(diff);
        }
        
        //Provider ID: IMDB        
        if (!this.NFOObject.getMovie().getImdbid().equals( itemObj.getItemMetadata().getProviderIds().getImdb() )){                
            diff = new JemmNFODiffs( "Imdb ID", itemObj.getItemMetadata().getProviderIds().getImdb() , this.NFOObject.getMovie().getImdbid() );
            this.addDifference(diff);
        }
        
        //Provider ID: TMDB
        if (!this.NFOObject.getMovie().getTmdbid().equals( itemObj.getItemMetadata().getProviderIds().getTmdb() )){                
            diff = new JemmNFODiffs( "Tmdb ID", itemObj.getItemMetadata().getProviderIds().getTmdb() , this.NFOObject.getMovie().getTmdbid() );
            this.addDifference(diff);
        }
        
        //Actors
        if (this.NFOObject.getMovie().getActor() != null){
            String nfoActorName = new String();
            String asIsActorName = new String();
            int nCountUsed = 0;
            boolean lFound = false;
            for (int nI = 0; nI < this.NFOObject.getMovie().getActor().size(); nI++ ){
                lFound = false;
                nfoActorName = this.NFOObject.getMovie().getActor().get(nI).getName().trim();                        
                
                for (int nK = 0; nK < itemObj.getItemMetadata().getPeople().size(); nK++ ){
                    asIsActorName = itemObj.getItemMetadata().getPeople().get(nK).getName().trim();
                    
                    if (nfoActorName.toUpperCase().equals(asIsActorName.toUpperCase())){
                        lFound = true;
                        break;
                    }
                }                
                
                if (!lFound){
                    String cNameAsIs = new String();
                    
                    if (nCountUsed < itemObj.getItemMetadata().getPeople().size()){
                        cNameAsIs = itemObj.getItemMetadata().getPeople().get(nCountUsed).getName().trim();
                        nCountUsed++;
                    } else {
                        cNameAsIs = "";
                    }
                    
                    diff = new JemmNFODiffs( "Actor", cNameAsIs , nfoActorName );
                    this.addDifference(diff);
                }
            }
        }    
        
        //Genres
        if (this.NFOObject.getMovie().getGenre() != null){
            String nfoGenreName = new String();
            String asIsGenreName = new String();
            int nCountUsed = 0;
            boolean lFound = false;
            for (int nI = 0; nI < this.NFOObject.getMovie().getGenre().size(); nI++ ){
                lFound = false;
                nfoGenreName = this.NFOObject.getMovie().getGenre().get(nI).trim();                        

                for (int nK = 0; nK < itemObj.getItemMetadata().getGenreItems().size(); nK++ ){
                    asIsGenreName = itemObj.getItemMetadata().getGenreItems().get(nK).getName().trim();

                    if (nfoGenreName.toUpperCase().equals(asIsGenreName.toUpperCase())){
                        lFound = true;
                        break;
                    }
                }                

                if (!lFound){
                    String cNameAsIs = new String();

                    if (nCountUsed < itemObj.getItemMetadata().getGenreItems().size()){
                        cNameAsIs = itemObj.getItemMetadata().getGenreItems().get(nCountUsed).getName().trim();
                        nCountUsed++;
                    } else {
                        cNameAsIs = "";
                    }

                    diff = new JemmNFODiffs( "Genre", cNameAsIs , nfoGenreName );
                    this.addDifference(diff);
                }
            }
        }
        
        //Tags
        if (this.NFOObject.getMovie().getTag() != null){
            String nfoTagName = new String();
            String asIsTagName = new String();
            int nCountUsed = 0;
            boolean lFound = false;
            for (int nI = 0; nI < this.NFOObject.getMovie().getTag().size(); nI++ ){
                lFound = false;
                nfoTagName = this.NFOObject.getMovie().getTag().get(nI).trim();                        

                for (int nK = 0; nK < itemObj.getItemMetadata().getTags().size(); nK++ ){
                    
                    asIsTagName = itemObj.getItemMetadata().getTags().get(nK).trim();

                    if (nfoTagName.toUpperCase().equals(asIsTagName.toUpperCase())){
                        lFound = true;
                        break;
                    }
                }                

                if (!lFound){
                    String cNameAsIs = new String();

                    if (nCountUsed < itemObj.getItemMetadata().getTags().size()){
                        cNameAsIs = itemObj.getItemMetadata().getTags().get(nCountUsed).trim();
                        nCountUsed++;
                    } else {
                        cNameAsIs = "";
                    }

                    diff = new JemmNFODiffs( "Tag", cNameAsIs , nfoTagName );
                    this.addDifference(diff);
                }
            }
        }
    }

    /**
     * Trims leading and trailing whitespace from supported movie text fields.
     *
     * @param mov movie metadata whose text fields are normalized
     * @return the same movie object after its supported text fields are trimmed
     * @since 1.0
     * @see Movie
     */
    private Movie trimSpaces(Movie mov) {
        Movie movie = mov;
        
        if (movie.getCountry() != null)
            movie.setCountry(movie.getCountry().trim());

        if (movie.getCredits() != null)
            movie.setCredits(movie.getCredits().trim());

        if (movie.getDirector() != null)
            movie.setDirector(movie.getDirector().trim());

        if (movie.getOriginaltitle() != null)
            movie.setOriginaltitle(movie.getOriginaltitle().trim());

        if (movie.getStudio() != null)
            movie.setStudio(movie.getStudio().trim());

        if (movie.getTagline() != null)
            movie.setTagline(movie.getTagline().trim());

        if (movie.getTitle() != null)
            movie.setTitle(movie.getTitle().trim());

        if (movie.getYear() != null)
            movie.setYear(movie.getYear().trim());

        if (movie.getPlot() != null)
            movie.setPlot(movie.getPlot().trim());

        if (movie.getImdbid() != null)
            movie.setImdbid(movie.getImdbid().trim());

        if (movie.getTmdbid() != null)
            movie.setTmdbid(movie.getTmdbid().trim());

        for (int nI = 0; nI < movie.getGenre().size(); nI++){
            if (movie.getGenre().get(nI) != null)
                movie.getGenre().set(nI, movie.getGenre().get(nI).trim());
        }
        for (int nI = 0; nI < movie.getTag().size(); nI++){
            if (movie.getTag().get(nI) != null)
                movie.getTag().set(nI, movie.getTag().get(nI).trim());
        }
        
        return movie;
    }

}
