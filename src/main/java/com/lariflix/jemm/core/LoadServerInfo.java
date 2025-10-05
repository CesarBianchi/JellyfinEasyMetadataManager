package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lariflix.jemm.dtos.JellyfinServerInfo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 * The LoadServerInfo class is responsible for loading server information from a Jellyfin instance.
 * It uses the Jellyfin API to request server information and parse the response.
 * 
 * @since 1.2.0
 * @version 1.0
 * @see JellyfinServerInfo
 * @author CesarBianchi
 */
public class LoadServerInfo {
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String fullURL = new String();

    /**
     * Default constructor for the LoadServerInfo class.
     * 
     * @since 1.2.0
     * @author CesarBianchi
     */
    public LoadServerInfo() {
    }

    /**
     * Constructor for the LoadServerInfo class with parameters.
     * 
     * @param url The URL of the Jellyfin instance.
     * @param apiToken The API token for authentication.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public LoadServerInfo(String url, String apiToken) {
        this.setJellyfinInstanceUrl(url);
        this.setApiToken(apiToken);
    }

    /**
     * Gets the URL of the Jellyfin instance.
     * 
     * @return The URL of the Jellyfin instance.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public String getJellyfinInstanceUrl() {
        return jellyfinInstanceUrl;
    }

    /**
     * Sets the URL of the Jellyfin instance.
     * 
     * @param jellyfinInstanceUrl The URL of the Jellyfin instance.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public void setJellyfinInstanceUrl(String jellyfinInstanceUrl) {
        this.jellyfinInstanceUrl = jellyfinInstanceUrl;
    }

    /**
     * Gets the API token for authentication.
     * 
     * @return The API token.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * Sets the API token for authentication.
     * 
     * @param apiToken The API token.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    /**
     * Requests server information from the Jellyfin instance.
     * 
     * @return A JellyfinServerInfo object containing the server information.
     * @throws MalformedURLException If the URL is malformed.
     * @throws IOException If an I/O error occurs.
     * @throws ParseException If a parsing error occurs.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinServerInfo requestServerInfo() throws MalformedURLException, IOException, ParseException {
        URL url = new URL(this.getFullURL());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // Getting the response code
        int responsecode = conn.getResponseCode();
        
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            // Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            // Close the scanner
            scanner.close();

            // Transform the JSON String into an Object
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JellyfinServerInfo serverInfo = mapper.readValue(inline, JellyfinServerInfo.class);
            
            return serverInfo;
        }
    }

    /**
     * Gets the full URL for the API request, including the API token.
     * 
     * @return The full URL for the API request.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public String getFullURL() {
        String urlWithApiKey = this.getJellyfinInstanceUrl().concat("System/Info").concat("?ApiKey=").concat(this.apiToken);
        return urlWithApiKey;
    }
}