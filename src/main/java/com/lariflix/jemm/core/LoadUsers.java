/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lariflix.jemm.dtos.JellyfinUsers;
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
public class LoadUsers {
    
    private String jellyfinInstanceUrl = new String();
    private String apiToken = new String();
    private String fullURL = new String();
        
    public LoadUsers() {
    }

    public LoadUsers(String jellyfinURL, String apiToken) {
       this.setJellyfinInstanceUrl(jellyfinURL);
       this.setApiToken(apiToken);
    }
   
    public JellyfinUsers requestUsers() throws MalformedURLException, IOException, ParseException{
        
        URL url = new URL(this.getFullURL());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();
        
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            String inline = "{\n" + "    \"Users\" : ";
            Scanner scanner = new Scanner(url.openStream());

           //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
               inline += scanner.nextLine();
            }
            inline += "}";

            //Close the scanner
            scanner.close();

            //Transform the JSON String in a Object
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JellyfinUsers Users = mapper.readValue(inline, JellyfinUsers.class);


            return Users;
        }
        
        
    }

    
    public String getJellyfinInstanceUrl() {
        return jellyfinInstanceUrl;
    }

    public void setJellyfinInstanceUrl(String jellyfinInstance) {
        this.jellyfinInstanceUrl = jellyfinInstance;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getFullURL() {
        String urlWithApiKey = new String();
        
        urlWithApiKey = this.getJellyfinInstanceUrl().concat("Users").concat("?ApiKey=").concat(this.apiToken);
        
        return urlWithApiKey;
    }

    
    
}
