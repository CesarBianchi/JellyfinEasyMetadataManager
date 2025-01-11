package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.utils.JellyfimParameters;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

 /**
 * This class is responsible for loading items from the Jellyfin server.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see LoadItems
 */
public class LoadItems {

    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String cUserAdminID = new String();
    private String cParentID = new String();
    private String fullURL = new String();
    private JellyfimParameters itemsType = null;
    
    /**
     * Default constructor for the LoadItems class.
     *
     * @param typeOfItems A JellyfinParameters object representing the type of items to load. This could be any of the types defined in the JellyfinParameters class.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public LoadItems(JellyfimParameters typeOfItems) {
        this.setItemsType(typeOfItems);
    }

    /**
     * Constructor for the LoadItems class.
     *
     * @param jellyfinURL The URL of the Jellyfin server. This should be a valid URL, including the protocol (http or https) and the domain name or IP address of the Jellyfin server. It may also include a port number if the server is not running on the default port.
     * @param apiToken The API token for accessing the Jellyfin server. This should be a valid API token provided by the Jellyfin server.
     * @param cAdminID The ID of the admin user. This should be a valid user ID for a user with admin privileges on the Jellyfin server.
     * @param cParID The ID of the parent item. This should be a valid item ID for an item on the Jellyfin server.
     * @param typeOfItems A JellyfinParameters object representing the type of items to load. This could be any of the types defined in the JellyfinParameters class.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public LoadItems(String jellyfinURL, String apiToken, String cAdminID, String cParID,JellyfimParameters typeOfItems) {
       this.setJellyfinInstanceUrl(jellyfinURL);
       this.setApiToken(apiToken);
       this.setcUserAdminID(cAdminID);
       this.setcParentID(cParID);
       this.setItemsType(typeOfItems);
    }
    
    /**
     * Requests items from the Jellyfin server.
     *
     * @return A JellyfinItems object containing the items.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws IOException If an I/O error occurs.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinItems requestItems() throws MalformedURLException, IOException, ParseException{
        
        URL url = new URL(this.getFullURL());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();
        
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

           //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
               inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();

            //Transform the JSON String in a Object
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JellyfinItems folderItems = mapper.readValue(inline, JellyfinItems.class);
            
            //Add a ParentID from Here
            for (int nI = 0; nI < folderItems.getItems().size(); nI++){
                folderItems.getItems().get(nI).setParentId(this.getcParentID());
            }

            return folderItems;
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

    /**
     * Gets the ID of the parent item.
     *
     * @return The ID of the parent item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getcParentID() {
        return this.cParentID;
    }

    /**
     * Sets the ID of the parent item.
     *
     * @param cParentID The ID of the parent item.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setcParentID(String cParentID) {
        this.cParentID = cParentID;
    }

    /**
     * Constructs the full URL for accessing the items on the Jellyfin server.
     * The URL is constructed based on the Jellyfin instance URL, the admin user ID, the parent ID, the API token, and the type of items to retrieve.
     *
     * @return The full URL as a string. The URL includes the base Jellyfin instance URL, the path to the items endpoint, the parent ID, the user ID, the API token, and any necessary filters based on the type of items to retrieve.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getFullURL() {
        String urlWithApiKey = new String();
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Users/").concat(this.getcUserAdminID());
        urlWithApiKey = urlWithApiKey.concat("/Items");
        urlWithApiKey = urlWithApiKey.concat("?parentId=").concat(this.getcParentID());
        urlWithApiKey = urlWithApiKey.concat("&userId=").concat(this.getcUserAdminID());
        urlWithApiKey = urlWithApiKey.concat("&ApiKey=").concat(this.apiToken);
        
        if (this.getItemsType() == JellyfimParameters.JUST_ITEMS){
            urlWithApiKey = urlWithApiKey.concat("&filters=").concat("IsNotFolder");
        } else if (this.getItemsType() == JellyfimParameters.JUST_SUBFOLDERS){
            urlWithApiKey = urlWithApiKey.concat("&filters=").concat("IsFolder");
        } else {
            //Nothig to do: Default way include Subfolers and Items
        }        
        
        return urlWithApiKey;
    }

    /**
     * Retrieves the type of items that this LoadItems instance is configured to load.
     *
     * @return A JellyfinParameters object representing the type of items to load. This could be any of the types defined in the JellyfinParameters class.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfimParameters getItemsType() {
        return itemsType;
    }

    /**
     * Sets the type of items that this LoadItems instance is configured to load.
     *
     * @param itemsType A JellyfinParameters object representing the type of items to load. This could be any of the types defined in the JellyfinParameters class.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setItemsType(JellyfimParameters itemsType) {
        this.itemsType = itemsType;
    }
 
    
    
}
