
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
 *
 * @author cesarbianchi
 */
public class LoadFolderMetadata {
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String cUserAdminID = new String();
    private String fullURL = new String();
    private String cFolderID = new String();

    public LoadFolderMetadata() {
    }
    
    public LoadFolderMetadata(String jellyfinURL, String apiToken, String cAdminID, String cFoldID) {
       this.setJellyfinInstanceUrl(jellyfinURL);
       this.setApiToken(apiToken);
       this.setcUserAdminID(cAdminID);
       this.setcFolderID(cFoldID);
    }

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

    public String getcUserAdminID() {
        return cUserAdminID;
    }

    public void setcUserAdminID(String cUserAdminID) {
        this.cUserAdminID = cUserAdminID;
    }

    public String getFullURL() {
        String urlWithApiKey = new String();
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Users/");
        urlWithApiKey = urlWithApiKey.concat(this.getcUserAdminID()).concat("/");
        urlWithApiKey = urlWithApiKey.concat("Items/").concat(cFolderID);
        urlWithApiKey = urlWithApiKey.concat("?ApiKey=").concat(this.apiToken);
        
        return urlWithApiKey;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    public String getcFolderID() {
        return cFolderID;
    }

    public void setcFolderID(String cFolderID) {
        this.cFolderID = cFolderID;
    }
            
    
            
}
