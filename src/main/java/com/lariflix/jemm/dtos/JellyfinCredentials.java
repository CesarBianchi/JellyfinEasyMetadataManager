package com.lariflix.jemm.dtos;

/**
 * This class represents the credentials for a Jellyfin server.
 * It is used to store and manage information related to the credentials used to connect to a Jellyfin server.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinCredentials {
    public String baseURL = new String();
    public String tokenAPI = new String();

    /**
     * Default constructor for JellyfinCredentials.
     */
    public JellyfinCredentials() {
    }

    /**
     * Constructor for JellyfinCredentials with specified base URL and token.
     *
     * @param cURL   the base URL of the Jellyfin server
     * @param cToken the API token for authentication
     */
    public JellyfinCredentials(String cURL, String cToken) {
        this.setBaseURL(cURL);
        this.setTokenAPI(cToken);
    }

    /**
     * Retrieves the base URL of the Jellyfin server.
     *
     * @return the base URL
     */
    public String getBaseURL() {
        return baseURL;
    }

    /**
     * Sets the base URL of the Jellyfin server.
     *
     * @param baseURL the base URL to set
     */
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    /**
     * Retrieves the API token for authentication.
     *
     * @return the API token
     */
    public String getTokenAPI() {
        return tokenAPI;
    }

    /**
     * Sets the API token for authentication.
     *
     * @param tokenAPI the API token to set
     */
    public void setTokenAPI(String tokenAPI) {
        this.tokenAPI = tokenAPI;
    }
}
