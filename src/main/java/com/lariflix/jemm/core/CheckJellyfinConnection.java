
package com.lariflix.jemm.core;

import com.lariflix.jemm.dtos.JellyfinConnectionResult;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarbianchi
 */
public class CheckJellyfinConnection {

    public void CheckJellyfinConnection() {
        
    }

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
