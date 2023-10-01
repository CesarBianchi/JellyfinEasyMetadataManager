
package com.lariflix.jemm.dtos;


public class JellyfinConnectionResult {
    private String message = new String();
    private int responseCode = 0;
    private boolean isConnected = false;

    public JellyfinConnectionResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isIsConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }
    
    
    
}
