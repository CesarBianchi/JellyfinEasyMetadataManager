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
 *
 * @author cesarbianchi
 */
public class LoadPeople {
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String cUserAdminID = new String();
    private String cParentID = new String();
    private String fullURL = new String();

    public LoadPeople() {
    }
    
    public LoadPeople(String jellyfinURL, String apiToken) {
       this.setJellyfinInstanceUrl(jellyfinURL);
       this.setApiToken(apiToken);
    }

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

    public String getcParentID() {
        return cParentID;
    }

    public void setcParentID(String cParentID) {
        this.cParentID = cParentID;
    }

    public String getFullURL() {
        String urlWithApiKey = new String();
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Persons");
        urlWithApiKey = urlWithApiKey.concat("?ApiKey=").concat(this.apiToken);
        
        return urlWithApiKey;
    }

    
}
