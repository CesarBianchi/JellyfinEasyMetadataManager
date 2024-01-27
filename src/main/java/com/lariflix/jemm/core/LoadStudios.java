package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lariflix.jemm.dtos.JellyfinCadGenresItems;
import com.lariflix.jemm.dtos.JellyfinCadStudioItems;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 * This class is responsible for loading studios from the Jellyfin server.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see LoadStudios
 */
public class LoadStudios {
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String fullURL = new String();
    private String cUserAdminID = new String();
    
    /**
     * Default constructor for the LoadStudios class.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public LoadStudios() {
        // ...
    }

    /**
     * Constructor for the LoadStudios class.
     *
     * @param jellyfinURL The URL of the Jellyfin server.
     * @param apiToken The API token for accessing the Jellyfin server.
     * @param cAdminID The ID of the admin user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public LoadStudios(String jellyfinURL, String apiToken, String cAdminID) {
       this.setJellyfinInstanceUrl(jellyfinURL);
       this.setApiToken(apiToken);
       this.setcUserAdminID(cAdminID);
    }

    /**
     * Requests studios from the Jellyfin server.
     *
     * @return A JellyfinCadStudioItems object containing the studios.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws IOException If an I/O error occurs.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinCadStudioItems requestStudios() throws MalformedURLException, IOException, ParseException{
        
        URL url = new URL(this.getFullURL());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();
        
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            String inline = new String();
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
            JellyfinCadStudioItems studios = mapper.readValue(inline, JellyfinCadStudioItems.class);


            return studios;
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
     * Constructs the full URL for accessing the studios on the Jellyfin server.
     *
     * @return The full URL as a string.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getFullURL() {
        String urlWithApiKey = new String();
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Studios").concat("?ApiKey=").concat(this.apiToken);
        //urlWithApiKey = urlWithApiKey.concat("&userId=").concat(this.getcUserAdminID());
        
        return urlWithApiKey;
    }
}
