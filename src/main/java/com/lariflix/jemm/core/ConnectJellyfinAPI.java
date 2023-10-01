/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author cesarbianchi
 */
public class ConnectJellyfinAPI {

    private String cBaseURL = new String();
    private String cTokenApi = new String();
    
    public ConnectJellyfinAPI() {
    }
   
    public String getcBaseURL() {
        return cBaseURL;
    }

    public void setcBaseURL(String cBaseURL) {
        this.cBaseURL = cBaseURL;
    }

    public String getcTokenApi() {
        return cTokenApi;
    }

    public void setcTokenApi(String cTokenApi) {
        this.cTokenApi = cTokenApi;
    }

    public JellyfinUsers getUsers() throws IOException, MalformedURLException, ParseException{
        
        LoadUsers LoadJellyfinUsers = new LoadUsers(this.getcBaseURL(),this.getcTokenApi());
         
        JellyfinUsers allUsers = LoadJellyfinUsers.requestUsers();
        
        return allUsers;
    }
    
    public JellyfinFolders getFolders() throws IOException, MalformedURLException, ParseException{
        
        LoadFolders loadedallFolders = new LoadFolders(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId());
         
        JellyfinFolders allFolders = loadedallFolders.requestFolders();
        
        return allFolders;
    }
    
    
    public JellyfinFolderMetadata getFolderMetadata(String cFolderID) throws IOException, MalformedURLException, ParseException{
        
        LoadFolderMetadata loadedallFolders = new LoadFolderMetadata(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId(),cFolderID);
         
        JellyfinFolderMetadata folderMetadata = loadedallFolders.requestFolderMetadata();
        
        return folderMetadata;
    }
    
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
        
        return folderItems;
    }
    
    public JellyfinCadPeopleItems getPeople() throws IOException, MalformedURLException, ParseException{
        
        LoadPeople loadedPeople = new LoadPeople(this.getcBaseURL(),this.getcTokenApi());
         
        JellyfinCadPeopleItems people = loadedPeople.requestPeople();
        
        return people;
    }
    
    public JellyfinCadGenresItems getGenres() throws IOException, MalformedURLException, ParseException{
        
        LoadGenres loadGenres = new LoadGenres(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId());
         
        JellyfinCadGenresItems allGenres = loadGenres.requestGenres();
        
        return allGenres;
    }
    
    public JellyfinCadStudioItems getStudios() throws IOException, MalformedURLException, ParseException{
        
        LoadStudios loadStudios = new LoadStudios(this.getcBaseURL(),this.getcTokenApi(),getAdminUser().getId());
         
        JellyfinCadStudioItems allStudios = loadStudios.requestStudios();
        
        return allStudios;
    }
    
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
    
    public int postUpdate(String cFolderID, String cItemID, JellyfinInstanceDetails instanceDetails, int nOPC) throws IOException, MalformedURLException, ParseException{
        
        SaveFolder updateItem = new SaveFolder(instanceDetails, cFolderID, cItemID, nOPC, this.getcBaseURL(),this.getcTokenApi());
         
        int responseCode =  updateItem.postUpdates();
        
        return responseCode;
    }
    
}
