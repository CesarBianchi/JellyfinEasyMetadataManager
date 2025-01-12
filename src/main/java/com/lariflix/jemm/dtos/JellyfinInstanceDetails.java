package com.lariflix.jemm.dtos;

/**
 * This class represents the JellyfinInstanceDetails.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinInstanceDetails {

    public JellyfinCredentials credentials = new JellyfinCredentials();
    public JellyfinUsers users = new JellyfinUsers();
    public JellyfinUser adminUser = new JellyfinUser();
    public JellyfinFolders folders = new JellyfinFolders();
    public JellyfinServerInfo serverInfo = new JellyfinServerInfo();
    public boolean isDebug = false;
    
    /**
     * Default constructor for JellyfinInstanceDetails.
     *
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinInstanceDetails() {
    }

    /**
     * Gets the users.
     *
     * @return A JellyfinUsers object representing the users.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinUsers getUsers() {
        return users;
    }

    /**
     * Sets the users.
     *
     * @param users A JellyfinUsers object containing the new users.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setUsers(JellyfinUsers users) {
        this.users = users;
    }

    /**
     * Gets the credentials.
     *
     * @return A JellyfinCredentials object representing the credentials.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinCredentials getCredentials() {
        return credentials;
    }

    /**
     * Sets the credentials.
     *
     * @param credentials A JellyfinCredentials object containing the new credentials.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setCredentials(JellyfinCredentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Gets the admin user.
     *
     * @return A JellyfinUser object representing the admin user.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinUser getAdminUser() {
        return adminUser;
    }

    /**
     * Sets the admin user.
     *
     * @param adminUser A JellyfinUser object containing the new admin user.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setAdminUser(JellyfinUser adminUser) {
        this.adminUser = adminUser;
    }

    /**
     * Gets the folders.
     *
     * @return A JellyfinFolders object representing the folders.
     * @author Cesar Bianchi
     * @since 1.0
     * @see JellyfinFolders
     */
    public JellyfinFolders getFolders() {
        return folders;
    }

    /**
     * Sets the folders.
     *
     * @param folders A JellyfinFolders object containing the new folders.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public void setFolders(JellyfinFolders folders) {
        this.folders = folders;   
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public JellyfinServerInfo getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(JellyfinServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }
    
    
    

    
    
}
