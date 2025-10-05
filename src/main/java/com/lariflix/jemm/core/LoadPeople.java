package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.dtos.JellyfinCadPeopleItems;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 * This class is responsible for loading people from the Jellyfin server.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see LoadPeople
 */
public class LoadPeople {
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String cUserAdminID = new String();
    private String cParentID = new String();
    private String fullURL = new String();

    /**
     * Default constructor for the LoadPeople class.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public LoadPeople() {
        // ...
    }

    /**
     * Constructor for the LoadPeople class.
     *
     * @param jellyfinURL The URL of the Jellyfin server.
     * @param apiToken The API token for accessing the Jellyfin server.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public LoadPeople(String jellyfinURL, String apiToken) {
       this.setJellyfinInstanceUrl(jellyfinURL);
       this.setApiToken(apiToken);
    }

    /**
     * Requests people from the Jellyfin server.
     *
     * @return A JellyfinCadPeopleItems object containing the people.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws IOException If an I/O error occurs.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinCadPeopleItems requestPeople() throws MalformedURLException, IOException, ParseException{
        
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
            JellyfinCadPeopleItems people = mapper.readValue(inline, JellyfinCadPeopleItems.class);


            return people;
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
        return cParentID;
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
     * Constructs the full URL for accessing the persons on the Jellyfin server.
     *
     * @return The full URL as a string.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getFullURL() {
        String urlWithApiKey = new String();
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Persons");
        urlWithApiKey = urlWithApiKey.concat("?ApiKey=").concat(this.apiToken);
        
        return urlWithApiKey;
    }

    
}
