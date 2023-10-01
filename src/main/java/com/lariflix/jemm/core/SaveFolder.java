package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItemUpdate;
import com.lariflix.jemm.dtos.JellyfinProviderIds;
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
 *
 * @author cesarbianchi
 */
public class SaveFolder {
    
    private JellyfinInstanceDetails instance = new JellyfinInstanceDetails();
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String fullURL = new String();
    private TransformDateFormat transformDate = new TransformDateFormat();
    private int nOpc = 0;
    private String itemID = new String();
    private String cFolderID = new String();
    
    private final int JUST_FOLDER_ITEM = 1;
    private final int FOLDER_AND_CONTENT = 2;
    private final int JUST_CONTENT_ITEM = 3;
    
    public SaveFolder() {
    }

    public SaveFolder(JellyfinInstanceDetails inst, String cFolderID, String IDItem, int nOpc, String jellyfinURL, String apiToken) {
        this.setInstance(inst);
        this.setcFolderID(cFolderID);
        this.setItemID(IDItem);
        this.setnOpc(nOpc);
        this.setJellyfinInstanceUrl(jellyfinURL);
        this.setApiToken(apiToken);
        
    }

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
    
    private JellyfinItemUpdate getObjItemToUpdate() {
        JellyfinItemUpdate itemToUpdate = new JellyfinItemUpdate();
        ArrayList<String> genres = new ArrayList();
        
        if (this.getnOpc() == JUST_FOLDER_ITEM){
            
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
        
            
        } else if (this.getnOpc() == JUST_CONTENT_ITEM){
            
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
    
    public JellyfinInstanceDetails getInstance() {
        return instance;
    }

    public void setInstance(JellyfinInstanceDetails instance) {
        this.instance = instance;
    }

    public String getJellyfinInstanceUrl() {
        return jellyfinInstanceUrl;
    }

    public void setJellyfinInstanceUrl(String jellyfinInstanceUrl) {
        this.jellyfinInstanceUrl = jellyfinInstanceUrl;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public int getnOpc() {
        return nOpc;
    }

    public void setnOpc(int nOpc) {
        this.nOpc = nOpc;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getcFolderID() {
        return cFolderID;
    }

    public void setcFolderID(String cFolderID) {
        this.cFolderID = cFolderID;
    }

    

    public String getFullURL() {
        String urlWithApiKey = new String();
        String id = new String();
        
        if (this.getnOpc() == JUST_FOLDER_ITEM){
            id = this.getcFolderID();
        } else if (this.getnOpc() == JUST_CONTENT_ITEM){
            id = this.getItemID();
        }
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Items/").concat(id);
        urlWithApiKey = urlWithApiKey.concat("?ApiKey=").concat(this.apiToken);
        
        return urlWithApiKey;
    }

    

    
    
    
}
