package com.lariflix.jemm.core;

import com.lariflix.jemm.dtos.JellyfinCadGenresItems;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.dtos.JellyfinCadPeopleItems;
import com.lariflix.jemm.dtos.JellyfinCadStudioItems;
import com.lariflix.jemm.dtos.JellyfinFolderMetadata;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinUser;
import com.lariflix.jemm.dtos.JellyfinUsers;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.simple.parser.ParseException;

/**
 * This class is used to establish a connection with the Jellyfin API.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinUsers
 * @see JellyfinFolders
 * @see JellyfinFolderMetadata
 * @see JellyfinItems
 * @see JellyfinItemMetadata
 * @see JellyfinCadPeopleItems
 * @see JellyfinCadGenresItems
 * @see JellyfinCadStudioItems
 * @see JellyfinUser
 * @see JellyfinInstanceDetails
 * @see JellyfinUser
 * @see JellyfinInstanceDetails
 */
public class ConnectJellyfinAPI {

    private String cBaseURL = new String();
    private String cTokenApi = new String();
    
    /**
     * Constructor for the ConnectJellyfinAPI class.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ConnectJellyfinAPI() {
    }

    /**
     * Returns the base URL for the Jellyfin API.
     *
     * @return The base URL for the Jellyfin API.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getcBaseURL() {
        return cBaseURL;
    }

    /**
     * Sets the base URL for the Jellyfin API.
     *
     * @param cBaseURL The new base URL for the Jellyfin API.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setcBaseURL(String cBaseURL) {
        this.cBaseURL = cBaseURL;
    }

    /**
     * Returns the token for the Jellyfin API.
     *
     * @return The token for the Jellyfin API.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getcTokenApi() {
        return cTokenApi;
    }

    /**
     * Sets the token for the Jellyfin API.
     *
     * @param cTokenApi The new token for the Jellyfin API.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setcTokenApi(String cTokenApi) {
        this.cTokenApi = cTokenApi;
    }

    /**
     * Retrieves all users from the Jellyfin server.
     *
     * @return A JellyfinUsers object containing all users.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinUsers getUsers() throws IOException, MalformedURLException, ParseException{
        
        LoadUsers LoadJellyfinUsers = new LoadUsers(this.getcBaseURL(),this.getcTokenApi());
         
        JellyfinUsers allUsers = LoadJellyfinUsers.requestUsers();
        
        return allUsers;
    }
    
    /**
     * Retrieves all folders from the Jellyfin server.
     *
     * @return A JellyfinFolders object containing all folders.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinFolders getFolders() throws IOException, MalformedURLException, ParseException{
        
        LoadFolders loadedallFolders = new LoadFolders(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId());
         
        JellyfinFolders allFolders = loadedallFolders.requestFolders();
        
        //Set the return by alfabetical order
        if (allFolders.items != null && allFolders.items.size() > 0){
            allFolders.items.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
        }
        
        return allFolders;
    }
    
    /**
     * Retrieves metadata for a specific folder from the Jellyfin server.
     *
     * @param cFolderID The ID of the folder for which to retrieve metadata.
     * @return A JellyfinFolderMetadata object containing the folder's metadata.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinFolderMetadata getFolderMetadata(String cFolderID) throws IOException, MalformedURLException, ParseException{
        
        LoadFolderMetadata loadedallFolders = new LoadFolderMetadata(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId(),cFolderID);
         
        JellyfinFolderMetadata folderMetadata = loadedallFolders.requestFolderMetadata();
        
        return folderMetadata;
    }
    
    /**
     * Retrieves all items from a specific parent folder from the Jellyfin server.
     *
     * @param cParentID The ID of the parent folder from which to retrieve items.
     * @return A JellyfinItems object containing all items from the specified parent folder.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinItems getItems(String cParentID) throws IOException, MalformedURLException, ParseException{
        
        //1* - First, request all itens (without Metadata Property)
        LoadItems loadedallFolders = new LoadItems(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId(),cParentID);
        JellyfinItems folderItems = loadedallFolders.requestItems();
        
        //2* Then, for each item, request their Metadata info.
        String cItemID = new String();
        LoadItemMetadata loadedMetadata = null;
        for (int nI = 0; nI < folderItems.getItems().size(); nI++){
            
            cItemID = folderItems.getItems().get(nI).getId();
            loadedMetadata = new LoadItemMetadata(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId(),cItemID);
            
            JellyfinItemMetadata itemMetadata = loadedMetadata.requestItemMetadata();
            
            folderItems.getItems().get(nI).setItemMetadata(itemMetadata);
        }
        
        //Set the return by alfabetical order
        if (folderItems.items != null && folderItems.items.size() > 0){
            folderItems.items.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
        }
        
        
        return folderItems;
    }
    
    /**
     * Retrieves all people from the Jellyfin server.
     *
     * @return A JellyfinCadPeopleItems object containing all people.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinCadPeopleItems getPeople() throws IOException, MalformedURLException, ParseException{
        
        LoadPeople loadedPeople = new LoadPeople(this.getcBaseURL(),this.getcTokenApi());
         
        JellyfinCadPeopleItems people = loadedPeople.requestPeople();
        
        return people;
    }
    
    /**
     * Retrieves all genres from the Jellyfin server.
     *
     * @return A JellyfinCadGenresItems object containing all genres.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinCadGenresItems getGenres() throws IOException, MalformedURLException, ParseException{
        
        LoadGenres loadGenres = new LoadGenres(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId());
         
        JellyfinCadGenresItems allGenres = loadGenres.requestGenres();
        
        return allGenres;
    }
    
    /**
     * Retrieves all studios from the Jellyfin server.
     *
     * @return A JellyfinCadStudioItems object containing all studios.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinCadStudioItems getStudios() throws IOException, MalformedURLException, ParseException{
        
        LoadStudios loadStudios = new LoadStudios(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId());
         
        JellyfinCadStudioItems allStudios = loadStudios.requestStudios();
        
        return allStudios;
    }
    
    /**
     * Retrieves the admin user from the Jellyfin server.
     *
     * @return A JellyfinUser object representing the admin user.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinUser getAdminUser() throws IOException, MalformedURLException, ParseException{
        JellyfinUser admUsr = new JellyfinUser();
        
        LoadUsers LoadJellyfinUsers = new LoadUsers(this.getcBaseURL(),this.getcTokenApi());
        JellyfinUsers allUsers = LoadJellyfinUsers.requestUsers();
        JellyfinUser validateUser = new JellyfinUser();
                
        for (int nI = 0; nI <= allUsers.getUsers().size()-1;nI++){
            
            validateUser = allUsers.getUsers().get(nI);
            
            if (validateUser.getPolicy().isAdministrator){
                admUsr = validateUser;
                break;
            }
            
        }
        
        return admUsr;
    }
    
    /**
     * Posts an update to a specific item in a specific folder on the Jellyfin server.
     *
     * @param cFolderID The ID of the folder containing the item to be updated.
     * @param cItemID The ID of the item to be updated.
     * @param instanceDetails The details of the Jellyfin instance.
     * @param nOPC The operation code for the update.
     * @return The response code from the server.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the provided URL is not valid.
     * @throws ParseException If there is an error parsing the server's response.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int postUpdate(String cFolderID, String cItemID, JellyfinInstanceDetails instanceDetails, int nOPC) throws IOException, MalformedURLException, ParseException{
        
        SaveFolder updateItem = new SaveFolder(instanceDetails, cFolderID, cItemID, nOPC, this.getcBaseURL(),this.getcTokenApi());
         
        int responseCode =  updateItem.postUpdates();
        
        return responseCode;
    }
    
}
