package com.lariflix.jemm.dtos;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinInstanceDetails {
    public JellyfinCredentials credentials = new JellyfinCredentials();
    public JellyfinUsers users = new JellyfinUsers();
    public JellyfinUser adminUser = new JellyfinUser();
    public JellyfinFolders folders = new JellyfinFolders();
    
    public JellyfinInstanceDetails() {
    }

    public JellyfinUsers getUsers() {
        return users;
    }

    public void setUsers(JellyfinUsers Users) {
        this.users = Users;
    }

    public JellyfinCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(JellyfinCredentials credentials) {
        this.credentials = credentials;
    }

    public JellyfinUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(JellyfinUser adminUser) {
        this.adminUser = adminUser;
    }

    public JellyfinFolders getFolders() {
        return folders;
    }

    public void setFolders(JellyfinFolders folders) {
        this.folders = folders;
    }

    

    
    
}
