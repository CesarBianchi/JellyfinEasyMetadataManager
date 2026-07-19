package com.lariflix.jemm.dtos;

/**
 * This class represents the result of a connection attempt to a Jellyfin server.
 * It is used to store and manage information related to the result of a connection attempt.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinConnectionResult {
    private String message = new String();
    private int responseCode = 0;
    private boolean isConnected = false;

    /**
     * Constructs a new JellyfinConnectionResult object.
     */
    public JellyfinConnectionResult() {
    }

    /**
     * Gets the message associated with the connection result.
     * 
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message associated with the connection result.
     * 
     * @param message The message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the response code of the connection attempt.
     * 
     * @return The response code.
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code of the connection attempt.
     * 
     * @param responseCode The response code to set.
     */
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Checks if the connection attempt was successful.
     * 
     * @return True if connected, false otherwise.
     */
    public boolean isIsConnected() {
        return isConnected;
    }

    /**
     * Sets the connection status.
     * 
     * @param isConnected The connection status to set.
     */
    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public boolean getIsConnected() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
