/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lariflix.jemm.dtos;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinCredentials {
    public String baseURL = new String();
    public String tokenAPI = new String();

    public JellyfinCredentials() {
    }

    public JellyfinCredentials(String cURL, String cToken) {
        this.setBaseURL(cURL);
        this.setTokenAPI(cToken);
    }


    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getTokenAPI() {
        return tokenAPI;
    }

    public void setTokenAPI(String tokenAPI) {
        this.tokenAPI = tokenAPI;
    }
    
    
    
}
