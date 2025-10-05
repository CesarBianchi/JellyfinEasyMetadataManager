package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItemUpdate;
import com.lariflix.jemm.dtos.JellyfinProviderIds;
import com.lariflix.jemm.utils.JellyfinParameters;
import com.lariflix.jemm.utils.TransformDateFormat;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;


/**
 * This class is responsible for managing and save folder items in Jellyfin Server.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see SaveFolder
 */
public class SaveFolder {

    private JellyfinInstanceDetails instance = new JellyfinInstanceDetails();
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String fullURL = new String();
    private TransformDateFormat transformDate = new TransformDateFormat();
    private JellyfinParameters jemmParameters;
    private String itemID = new String();
    private String cFolderID = new String();
    
    private final int JUST_FOLDER_ITEM = 1;
    private final int FOLDER_AND_CONTENT = 2;
    private final int JUST_CONTENT_ITEM = 3;
    
    /**
     * Default constructor for the SaveFolder class.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public SaveFolder() {
        // ...
    }

    /**
     * Constructor for the SaveFolder class.
     *
     * @param inst The Jellyfin instance details.
     * @param cFolderID The ID of the folder.
     * @param IDItem The ID of the item.
     * @param nOpc The option number.
     * @param jellyfinURL The URL of the Jellyfin server.
     * @param apiToken The API token for accessing the Jellyfin server.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public SaveFolder(JellyfinInstanceDetails inst, String cFolderID, String IDItem, JellyfinParameters jemmParam, String jellyfinURL, String apiToken) {
        this.setInstance(inst);
        this.setcFolderID(cFolderID);
        this.setItemID(IDItem);
        this.setnOpc(jemmParam);
        this.setJellyfinInstanceUrl(jellyfinURL);
        this.setApiToken(apiToken);
    }

    /**
     * Posts updates about folders to the Jellyfin server.
     *
     * @return The HTTP response code from the server.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws IOException If an I/O error occurs.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int postUpdates() throws MalformedURLException, IOException, ParseException{
        int responsecode = 0;

        JellyfinItemUpdate itemUpdate = this.getObjItemToUpdate();
        
        if (!itemUpdate.getId().isEmpty()){
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String bodyRequestJson = ow.writeValueAsString(itemUpdate);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.getFullURL()))
                .POST(HttpRequest.BodyPublishers.ofString(bodyRequestJson))
                .setHeader("Content-type",  "application/json")
                .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                responsecode = response.statusCode();

            } catch (InterruptedException ex) {
                Logger.getLogger(SaveFolder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return responsecode;
        
    }
    
    /**
     * This method is used to post the Jellyfin item to update.
     *
     * @return JellyfinItemUpdate object with the item details to be updated.
     * @since 1.0
     * @author Cesar Bianchi
     */
    private JellyfinItemUpdate getObjItemToUpdate() {
        JellyfinItemUpdate itemToUpdate = new JellyfinItemUpdate();
        ArrayList<String> genres = new ArrayList();
        
        if (this.getnOpc() == jemmParameters.FOLDERS_AND_SUBFOLDERS){
            
            //Seek Folder
            for (int nI = 0; nI < instance.getFolders().getItems().size(); nI++){
                if (instance.getFolders().getItems().get(nI).getId().equals(this.getcFolderID()) ){
                    
                    itemToUpdate.setId(instance.getFolders().getItems().get(nI).getId());
                    itemToUpdate.setName(instance.getFolders().getItems().get(nI).getMetadata().getName() );
                    itemToUpdate.setOriginalTitle(instance.getFolders().getItems().get(nI).getMetadata().getSortName() );
                    itemToUpdate.setForcedSortName(instance.getFolders().getItems().get(nI).getMetadata().getName());
                    itemToUpdate.setCommunityRating(instance.getFolders().getItems().get(nI).getMetadata().getCommunityRating());
                    itemToUpdate.setCriticRating(instance.getFolders().getItems().get(nI).getCriticRating());
                    itemToUpdate.setIndexNumber(null);
                    itemToUpdate.setAirsBeforeSeasonNumber("");
                    itemToUpdate.setAirsAfterSeasonNumber("");
                    itemToUpdate.setAirsBeforeEpisodeNumber("");
                    itemToUpdate.setParentIndexNumber(null);
                    itemToUpdate.setDisplayOrder("");
                    itemToUpdate.setAlbum("");
                    itemToUpdate.setOverview(instance.getFolders().getItems().get(nI).getMetadata().getOverview());
                    itemToUpdate.setStatus("");
                    
                    for (int nJ = 0; nJ < instance.getFolders().getItems().get(nI).getMetadata().getGenreItems().size(); nJ++){
                        genres.add(instance.getFolders().getItems().get(nI).getMetadata().getGenreItems().get(nJ).getName());
                    }
                    itemToUpdate.setGenres(genres);                    
                    itemToUpdate.setTags(instance.getFolders().getItems().get(nI).getMetadata().getTags());
                    itemToUpdate.setStudios(instance.getFolders().getItems().get(nI).getMetadata().getStudios());
                    itemToUpdate.setPremiereDate(transformDate.convertToFull(instance.getFolders().getItems().get(nI).getMetadata().getPremiereDate()) );
                    itemToUpdate.setDateCreated(transformDate.convertToFull(instance.getFolders().getItems().get(nI).getMetadata().getDateCreated()) );
                    itemToUpdate.setProductionYear(instance.getFolders().getItems().get(nI).getMetadata().getProductionYear());
                    itemToUpdate.setOfficialRating(instance.getFolders().getItems().get(nI).getMetadata().getOfficialRating());
                    itemToUpdate.setCustomRating(instance.getFolders().getItems().get(nI).getMetadata().getCustomRating());
                    itemToUpdate.setPeople(instance.getFolders().getItems().get(nI).getMetadata().getPeople());
                    itemToUpdate.setLockData(false);
                    itemToUpdate.setPreferredMetadataLanguage(instance.getFolders().getItems().get(nI).getMetadata().getPreferredMetadataLanguage());
                    itemToUpdate.setPreferredMetadataCountryCode(instance.getFolders().getItems().get(nI).getMetadata().getPreferredMetadataCountryCode());
                    
                    JellyfinProviderIds providerID = new JellyfinProviderIds();
                    providerID.setImdb("");
                    providerID.setTmdb("");
                    providerID.setTmdbCollection("");
                    itemToUpdate.setProviderIds(providerID);
                    
                    break;
                }
            }
        
            
        } else if (this.getnOpc() == jemmParameters.JUST_ITEMS){
            
            //Seek Folder
            for (int nI = 0; nI < instance.getFolders().getItems().size(); nI++){                
                if (instance.getFolders().getItems().get(nI).getId().equals(this.getcFolderID()) ){
                    
                    //Seek Item
                    for (int nJ = 0; nJ < instance.getFolders().getItems().get(nI).getFolderContent().getItems().size(); nJ++){
                        if (instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getId().equals(this.getItemID())){
                            
                            itemToUpdate.setId(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getId());
                            itemToUpdate.setName(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getName() );
                            itemToUpdate.setOriginalTitle(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getOriginalTitle() );
                            itemToUpdate.setForcedSortName(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getOriginalTitle());
                            itemToUpdate.setCommunityRating(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getCommunityRating());
                            itemToUpdate.setCriticRating(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getCriticRating());
                            itemToUpdate.setIndexNumber(null);
                            itemToUpdate.setAirsBeforeSeasonNumber("");
                            itemToUpdate.setAirsAfterSeasonNumber("");
                            itemToUpdate.setAirsBeforeEpisodeNumber("");
                            itemToUpdate.setParentIndexNumber(null);
                            itemToUpdate.setDisplayOrder("");
                            itemToUpdate.setAlbum("");
                            itemToUpdate.setOverview(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getOverview());
                            itemToUpdate.setStatus("");
                            
                            
                            for (int nX = 0; nX < instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getGenreItems().size(); nX++){
                                genres.add(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getGenreItems().get(nX).getName());
                            }
                            itemToUpdate.setGenres(genres);

                            ArrayList<String> tags = new ArrayList();
                            for (int nX = 0; nX < instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getTags().size(); nX++){
                                tags.add(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getTags().get(nX) );
                            }
                            itemToUpdate.setTags(tags);
                            
                            
                            
                            itemToUpdate.setStudios(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getStudios());
                            itemToUpdate.setPremiereDate( transformDate.convertToFull(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getPremiereDate()) );
                            
                            itemToUpdate.setDateCreated(transformDate.convertToFull(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getDateCreated()) );
                            itemToUpdate.setProductionYear(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getProductionYear());
                            itemToUpdate.setOfficialRating(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getOfficialRating());
                            itemToUpdate.setCustomRating(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getCustomRating());
                            itemToUpdate.setPeople(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getPeople());
                            itemToUpdate.setLockData(false);
                            itemToUpdate.setPreferredMetadataLanguage(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getPreferredMetadataLanguage());
                            itemToUpdate.setPreferredMetadataCountryCode(instance.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ).getItemMetadata().getPreferredMetadataCountryCode());

                            JellyfinProviderIds providerID = new JellyfinProviderIds();
                            providerID.setImdb("");
                            providerID.setTmdb("");
                            providerID.setTmdbCollection("");
                            itemToUpdate.setProviderIds(providerID);
                            
                            break;
                        }                        
                    }                    
                    break;
                }
            }
        }
        
        return itemToUpdate;
    }
    
    /**
     * Gets the Jellyfin instance details.
     *
     * @return The Jellyfin instance details.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinInstanceDetails getInstance() {
        return instance;
    }

    /**
     * Sets the Jellyfin instance details.
     *
     * @param instance The Jellyfin instance details.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setInstance(JellyfinInstanceDetails instance) {
        this.instance = instance;
    }

    /**
     * Gets the Jellyfin instance URL.
     *
     * @return The Jellyfin instance URL.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getJellyfinInstanceUrl() {
        return jellyfinInstanceUrl;
    }

    /**
     * Sets the Jellyfin instance URL.
     *
     * @param jellyfinInstanceUrl The Jellyfin instance URL.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setJellyfinInstanceUrl(String jellyfinInstanceUrl) {
        this.jellyfinInstanceUrl = jellyfinInstanceUrl;
    }

    /**
     * Gets the API token.
     *
     * @return The API token.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * Sets the API token.
     *
     * @param apiToken The API token.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    /**
     * Gets the option number.
     *
     * @return The option number.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinParameters getnOpc() {
        return jemmParameters;
    }

    /**
     * Sets the option number.
     *
     * @param nOpc The option number.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setnOpc(JellyfinParameters jemmParam) {
        this.jemmParameters = jemmParam;
    }

    /**
     * Gets the item ID.
     *
     * @return The item ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Sets the item ID.
     *
     * @param itemID The item ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * Gets the folder ID.
     *
     * @return The folder ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getcFolderID() {
        return cFolderID;
    }

    /**
     * Sets the folder ID.
     *
     * @param cFolderID The folder ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setcFolderID(String cFolderID) {
        this.cFolderID = cFolderID;
    }

    
    /**
     * Constructs the full URL for update the items on the Jellyfin server.
     * The URL is constructed based on the option number. If the option number is JUST_FOLDER_ITEM,
     * the folder ID is used. If the option number is JUST_CONTENT_ITEM, the item ID is used.
     *
     * @return The full URL as a string.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getFullURL() {
        String urlWithApiKey = new String();
        String id = new String();
        
        if (this.getnOpc() == jemmParameters.FOLDERS_AND_SUBFOLDERS){
            id = this.getcFolderID();
        } else if (this.getnOpc() == jemmParameters.JUST_ITEMS){
            id = this.getItemID();
        }
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Items/").concat(id);
        urlWithApiKey = urlWithApiKey.concat("?ApiKey=").concat(this.apiToken);
        
        return urlWithApiKey;
    }

    

    
    
    
}
