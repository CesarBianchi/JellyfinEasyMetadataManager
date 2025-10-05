
package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lariflix.jemm.dtos.JellyfinFolderMetadata;
import com.lariflix.jemm.dtos.JellyfinFolders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 * This class is responsible for loading folder metadata from the Jellyfin server.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinFolderMetadata
 * @see JellyfinFolders
 * @see LoadFolderMetadata
 * @see LoadFolders
 * 
 */
public class LoadFolderMetadata {

    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String cUserAdminID = new String();
    private String fullURL = new String();
    private String cFolderID = new String();

    /**
     * Constructor for the LoadFolderMetadata class.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public LoadFolderMetadata() {
        // ...
    }
    
    /**
     * Constructor for the LoadFolderMetadata class.
     *
     * @param jellyfinURL The URL of the Jellyfin server.
     * @param apiToken The API token for accessing the Jellyfin server.
     * @param cAdminID The ID of the admin user.
     * @param cFoldID The ID of the folder for which to load metadata.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public LoadFolderMetadata(String jellyfinURL, String apiToken, String cAdminID, String cFoldID) {
       this.setJellyfinInstanceUrl(jellyfinURL);
       this.setApiToken(apiToken);
       this.setcUserAdminID(cAdminID);
       this.setcFolderID(cFoldID);
    }

    /**
     * Requests metadata for a specific folder from the Jellyfin server.
     *
     * @return A JellyfinFolderMetadata object containing the folder's metadata.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws IOException If an I/O error occurs.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinFolderMetadata requestFolderMetadata() throws MalformedURLException, IOException, ParseException{
        
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
            JellyfinFolderMetadata foldMetadata = mapper.readValue(inline, JellyfinFolderMetadata.class);


            return foldMetadata;
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
     * Gets the admin user ID.
     *
     * @return The admin user ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getcUserAdminID() {
        return cUserAdminID;
    }

    /**
     * Sets the admin user ID.
     *
     * @param cUserAdminID The admin user ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setcUserAdminID(String cUserAdminID) {
        this.cUserAdminID = cUserAdminID;
    }

    /**
     * Constructs the full URL for accessing a specific folder on the Jellyfin server.
     *
     * @return The full URL as a string.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getFullURL() {
        String urlWithApiKey = new String();
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Users/");
        urlWithApiKey = urlWithApiKey.concat(this.getcUserAdminID()).concat("/");
        urlWithApiKey = urlWithApiKey.concat("Items/").concat(cFolderID);
        urlWithApiKey = urlWithApiKey.concat("?ApiKey=").concat(this.apiToken);
        
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
     * Gets the ID of the folder.
     *
     * @return The ID of the folder.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getcFolderID() {
        return cFolderID;
    }

    /**
     * Sets the ID of the folder.
     *
     * @param cFolderID The ID of the folder.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setcFolderID(String cFolderID) {
        this.cFolderID = cFolderID;
    }
            
    
            
}
