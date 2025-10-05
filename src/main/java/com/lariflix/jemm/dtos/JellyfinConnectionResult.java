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
     * @author Cesar Bianchi
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message associated with the connection result.
     * 
     * @param message The message to set.
     * @author Cesar Bianchi
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the response code of the connection attempt.
     * 
     * @return The response code.
     * @author Cesar Bianchi
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code of the connection attempt.
     * 
     * @param responseCode The response code to set.
     * @author Cesar Bianchi
     */
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Checks if the connection attempt was successful.
     * 
     * @return True if connected, false otherwise.
     * @author Cesar Bianchi
     */
    public boolean isIsConnected() {
        return isConnected;
    }

    /**
     * Sets the connection status.
     * 
     * @param isConnected The connection status to set.
     * @author Cesar Bianchi
     */
    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public boolean getIsConnected() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
