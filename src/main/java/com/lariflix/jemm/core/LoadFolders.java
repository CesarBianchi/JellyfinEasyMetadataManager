
package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lariflix.jemm.dtos.JellyfinFolder;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.utils.JellyfimParameters;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 * This class is responsible for loading folders from the Jellyfin server.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see LoadFolderMetadata
 */
public class LoadFolders {
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String cUserAdminID = new String();
    private String fullURL = new String();
    private JellyfimParameters foldersType = null;

    /**
     * Default constructor for the LoadFolders class.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public LoadFolders(JellyfimParameters typeOfFolders) {
        this.setFoldersType(typeOfFolders);
    }
    
     /**
      * Constructor for the LoadFolders class.
      *
      * @param jellyfinURL The URL of the Jellyfin server.
      * @param apiToken The API token for accessing the Jellyfin server.
      * @param cAdminID The ID of the admin user.
      * @since 1.0
      * @author Cesar Bianchi
      */
     public LoadFolders(String jellyfinURL, String apiToken, String cAdminID, JellyfimParameters typeOfFolders) {
         this.setJellyfinInstanceUrl(jellyfinURL);
         this.setApiToken(apiToken);
         this.setcUserAdminID(cAdminID);
         this.setFoldersType(typeOfFolders);
     }

    /**
     * Requests a list of folders from the Jellyfin server.
     *
     * @return A JellyfinFolders object containing the list of folders.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws IOException If an I/O error occurs.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinFolders requestFolders() throws MalformedURLException, IOException, ParseException{
        
        URL url = new URL(this.getFullURL());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();
        
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            //String inline = "{\n" + "    \"Users\" : ";
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

           //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
               inline += scanner.nextLine();
            }
            //inline += "}";

            //Close the scanner
            scanner.close();

            //Transform the JSON String in a Object
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JellyfinFolders folders = mapper.readValue(inline, JellyfinFolders.class);

            //Define order By Name (Just for Root Folders)
            if (folders.items != null && folders.items.size() > 0){
                folders.items.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
            }
            
            //load and add SubFolders as Folder-Item
            //Issue: https://github.com/CesarBianchi/JellyfinEasyMetadataManager/issues/12
            if (this.getFoldersType() == JellyfimParameters.FOLDERS_AND_SUBFOLDERS){
                folders = this.getSubFolders(folders);
            }
            
            return folders;
        }
        
        
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
     * Constructs the full URL for accessing the items on the Jellyfin server.
     *
     * @return The full URL as a string.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getFullURL() {
        String urlWithApiKey = new String();
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Items");
        urlWithApiKey = urlWithApiKey.concat("?ApiKey=").concat(this.apiToken);
        urlWithApiKey = urlWithApiKey.concat("&userId=").concat(cUserAdminID);
        
        return urlWithApiKey;
    }

    /**
     * Sets the full URL for accessing a specific folder on the Jellyfin server.
     *
     * @param fullURL The full URL as a string.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    /**
     * Gets the ID of the admin user.
     *
     * @return The ID of the admin user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getcUserAdminID() {
        return cUserAdminID;
    }

    /**
     * Sets the ID of the admin user.
     *
     * @param cUserAdminID The ID of the admin user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setcUserAdminID(String cUserAdminID) {
        this.cUserAdminID = cUserAdminID;
    }

    public JellyfimParameters getFoldersType() {
        return foldersType;
    }

    public void setFoldersType(JellyfimParameters foldersType) {
        this.foldersType = foldersType;
    }

    private JellyfinFolders getSubFolders(JellyfinFolders folders) {
        
        for (int nI = 0; nI < folders.getItems().size(); nI++){
            
            LoadItems loadSubFolders = new LoadItems(JellyfimParameters.JUST_SUBFOLDERS);
            loadSubFolders.setJellyfinInstanceUrl(this.getJellyfinInstanceUrl());
            loadSubFolders.setApiToken(this.getApiToken());
            loadSubFolders.setcUserAdminID(this.getcUserAdminID());
            loadSubFolders.setcParentID(folders.getItems().get(nI).getId() );            
            
            try {
                JellyfinItems subFolders = loadSubFolders.requestItems();
                
                //Set Alfabetical Order
                if (subFolders.getItems() != null && subFolders.getItems().size() > 0){
                    subFolders.items.sort((o2, o1) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
                }
                
                for (int nJ = 0; nJ < subFolders.getItems().size(); nJ++){
                   
                    //get parentFolder level
                    int parentFolderLevel = folders.getItems().get(nI).getFolderLevel();
                   
                    
                    JellyfinFolder newSubFolder = new JellyfinFolder();
                    newSubFolder = this.addNewSubFolder(subFolders.getItems().get(nJ),parentFolderLevel);                                      
                    
                    //Add a new SubFolder
                    folders.getItems().add(nI+1, newSubFolder);                    
                }
                
                
            
            } catch (IOException ex) {
                Logger.getLogger(LoadFolders.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(LoadFolders.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        return folders;
    }

    private JellyfinFolder addNewSubFolder(JellyfinItem subFolder, int parentFolderLevel) {
        
        //Define the prefix String - like "path indentation"
        String prefix = new String();
        prefix = new String(" ").repeat(parentFolderLevel*3).concat("⎆ ");
        
        //Transform a "JellyfinItem Object" to "JellyfinFolder Object"
        JellyfinFolder newSubFolder = new JellyfinFolder();        
        newSubFolder.setName(prefix.concat(subFolder.getName()));
        newSubFolder.setServerId(subFolder.getServerId());
        newSubFolder.setId(subFolder.getId());
        newSubFolder.setPremiereDate(subFolder.getPremiereDate());
        newSubFolder.setCriticRating(subFolder.getCriticRating());
        newSubFolder.setOfficialRating(subFolder.getOfficialRating());
        newSubFolder.setChannelId("<Unknow - Check LoadFolders.addNewSubFolder>");
        newSubFolder.setCommunityRating(subFolder.getCommunityRating());
        newSubFolder.setProductionYear(subFolder.getProductionYear());
        newSubFolder.setIsFolder(true);
        newSubFolder.setType(subFolder.getType());
        newSubFolder.setCollectionType("<Unknow - Check LoadFolders.addNewSubFolder>");
        newSubFolder.setLocationType(subFolder.getLocationType());
        newSubFolder.setFolderLevel(parentFolderLevel+1);
        
        return newSubFolder;
    }

 

    

    
}
