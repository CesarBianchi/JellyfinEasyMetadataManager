
package com.lariflix.jemm.core;

import com.lariflix.jemm.dtos.JellyfinConnectionResult;
import com.lariflix.jemm.dtos.JellyfinCredentials;
import com.lariflix.jemm.dtos.JellyfinFolder;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinUser;
import com.lariflix.jemm.dtos.JellyfinUserConfiguration;
import com.lariflix.jemm.dtos.JellyfinUserPolicy;
import com.lariflix.jemm.dtos.JellyfinUsers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class is used to check the connection to the Jellyfin server.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinConnectionResult
 * @see JellyfinInstanceDetails
 * @see JellyfinUser
 * @see JellyfinUsers
 * @see JellyfinUserConfiguration
 * @see JellyfinUserPolicy
 * @see JellyfinFolders
 * @see JellyfinFolder
 * @see JellyfinCredentials
 */
public class CheckJellyfinConnection {

    /**
     * Constructor for the CheckJellyfinConnection class.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void CheckJellyfinConnection() {
        
    }

    /**
     * Tries to establish a connection to the Jellyfin server.
     *
     * @param cURL The URL of the Jellyfin server.
     * @param cApiKey The API key for the Jellyfin server.
     * @return A JellyfinConnectionResult object containing the result of the connection attempt.
     * @throws MalformedURLException If the provided URL is not valid.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinConnectionResult tryConnection(String cURL, String cApiKey) throws MalformedURLException {
        
        JellyfinConnectionResult connResult = new JellyfinConnectionResult();
        
        if (cURL.isEmpty()){
            connResult.setResponseCode(0);
            connResult.setIsConnected(false);
            connResult.setMessage("Empty Jellyfin URL");
        } else if (cApiKey.isEmpty()){
            connResult.setResponseCode(0);
            connResult.setIsConnected(false);
            connResult.setMessage("Empty Jellyfin ApiKey");
        } else {
            
            try {
                URL url = new URL(cURL.concat("Users?ApiKey=").concat(cApiKey));
                HttpURLConnection conn;
            
                conn = (HttpURLConnection) url.openConnection();            
                conn.setRequestMethod("GET");
                conn.connect();
            
                //Getting the response code
                int responsecode = conn.getResponseCode();
                connResult.setResponseCode(responsecode);


                if (responsecode == 200) {
                    connResult.setIsConnected(true);
                } else {
                    connResult.setIsConnected(false);
                }
                connResult.setMessage(conn.getResponseMessage());
            
            } catch (IOException ex) {
                
                String message = new String();
                
                message = "Instance not found or invalid apiKey.";
                
                if (cURL.toLowerCase().contains("https:")) {                
                    message = message.concat("\n");
                    message = message.concat("\n");
                    message = message.concat("Tip: If you are using a HTTPS connection (SSL), ");
                    message = message.concat("\n");
                    message = message.concat("make sure you have the correct SSL certificate installed on your S.O.");
                }
                 
                connResult.setIsConnected(false);
                connResult.setMessage(message);
                
                Logger.getLogger(CheckJellyfinConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return connResult;
    }
    
}
