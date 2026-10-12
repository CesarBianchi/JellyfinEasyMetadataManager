
package com.lariflix.jemm.dtos.nfo;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.forms.MainWindow;
import com.lariflix.jemm.utils.JellyfinParameters;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * Root DTO representing a Jellyfin NFO metadata document.
 * <p>
 * This class acts as the top-level container for a movie metadata structure,
 * exposing the main {@link Movie} object used during serialization and
 * deserialization of NFO content.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see Movie
 */
public class JemmNFO {
    /** The movie metadata represented by this NFO document. */
    Movie movie = new Movie();
    Audio audio = new Audio();  

    /**
     * Creates a new empty NFO document container.
     *
     * @since 1.0
     * @see Movie
     */
    public JemmNFO() {
    }

    /**
     * Returns the movie metadata associated with this NFO document.
     *
     * @return the movie metadata, or {@code null} if not configured
     * @since 1.0
     * @see #setMovie(Movie)
     */
    public Movie getMovie() {
        return movie;
    }

    public Audio getAudio() {
        return audio;
    }

    /**
     * Sets the movie metadata associated with this NFO document.
     *
     * @param movie the movie metadata to store
     * @since 1.0
     * @see #getMovie()
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public JellyfinItem convertToJemmStandard(JellyfinItem itemObj, Movie mov) {
        JellyfinItem jemmStandard = itemObj;
        if (mov == null){
            mov = this.getMovie();
        }
        
        jemmStandard.setCommunityRating(  Integer.parseInt( mov.getRating()));
        jemmStandard.setCriticRating( Integer.parseInt( mov.getRating()));        
        jemmStandard.setName( mov.getTitle());
        jemmStandard.setProductionYear( Integer.parseInt(mov.getYear()));
        jemmStandard.setPremiereDate( mov.getPremiered());
        
        jemmStandard.getItemMetadata().setCommunityRating( Integer.parseInt( mov.getRating()));
        jemmStandard.getItemMetadata().setCriticRating( Integer.parseInt( mov.getRating()) );
        jemmStandard.getItemMetadata().setDateCreated( mov.getPremiered());
        jemmStandard.getItemMetadata().setForcedSortName( mov.getTitle());
        jemmStandard.getItemMetadata().setName(mov.getTitle() );
        jemmStandard.getItemMetadata().setOriginalTitle(mov.getTitle());
        jemmStandard.getItemMetadata().setPremiereDate(mov.getPremiered());
        jemmStandard.getItemMetadata().setProductionYear(Integer.parseInt(mov.getYear()));
        jemmStandard.getItemMetadata().getProviderIds().setImdb( mov.getImdbid());
        jemmStandard.getItemMetadata().getProviderIds().setTmdb( mov.getTmdbid());
        jemmStandard.getItemMetadata().setSortName( mov.getTitle());
        
        //Tags
        //Genres
        //People
        
        return jemmStandard;
    }

    public boolean PostUpdates(String folderID, String itemID, JellyfinItem itemObj, JellyfinParameters jellyfinParameters, ConnectJellyfinAPI connectAPI, JellyfinInstanceDetails instanceData) {
        boolean updateMainObj = false;
        boolean updateJFInstance = false;
        
        updateMainObj = this.updateItemOnMainObject(folderID,itemID,itemObj,instanceData);
        
        if (updateMainObj){
            updateJFInstance = this.updateItemOnJellyfin(folderID,itemID,jellyfinParameters,connectAPI,instanceData);    
        }
        
        return updateJFInstance;
    }
    
    private boolean updateItemOnMainObject(String folderID, String itemID, JellyfinItem itemObj,JellyfinInstanceDetails instanceData) {
        boolean lSuccess = false;
        
        if (!folderID.isEmpty()){
            if (!itemID.isEmpty()){
                for (int nI = 0; nI < instanceData.getFolders().getItems().size(); nI++){
                    if (instanceData.getFolders().getItems().get(nI).getId().equals(folderID)){
                        for (int nK = 0; nK < instanceData.getFolders().getItems().get(nI).getFolderContent().getItems().size(); nK++ ){
                            if (instanceData.getFolders().getItems().get(nI).getFolderContent().getItems().get(nK).getId().equals(itemID) ){  
                                
                                JellyfinItem toBeItem = this.convertToJemmStandard(itemObj, this.getMovie());                                        
                                instanceData.getFolders().getItems().get(nI).getFolderContent().getItems().set(nK, toBeItem);                                
                                
                                lSuccess = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return lSuccess;
    }
    
    private boolean updateItemOnJellyfin(String folderID, String itemID, JellyfinParameters jemmParameters, ConnectJellyfinAPI connectAPI,JellyfinInstanceDetails instanceData ) {
        boolean lSuccess = false;
        
        try {
            connectAPI.postUpdate(folderID, itemID, instanceData, jemmParameters.JUST_ITEMS);
            lSuccess = true;
        } catch (IOException ex) {
            System.getLogger(MainWindow.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ParseException ex) {
            System.getLogger(MainWindow.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return lSuccess;
    }

}
