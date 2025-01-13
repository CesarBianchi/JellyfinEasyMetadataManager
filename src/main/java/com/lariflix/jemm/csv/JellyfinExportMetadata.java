
package com.lariflix.jemm.csv;

import com.lariflix.jemm.core.LoadFolders;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.reports.JellyfinReportInventory;
import com.lariflix.jemm.reports.JellyfinReportInventoryItem;
import com.lariflix.jemm.reports.JellyfinReportInventoryStructure;
import com.lariflix.jemm.utils.JellyfinParameters;
import com.lariflix.jemm.utils.JellyfinResponseStandard;
import com.lariflix.jemm.utils.JemmVersion;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
import com.lariflix.jemm.utils.TransformDateFormat;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * The JellyfinExportMetadata class is responsible for exporting metadata from a Jellyfin instance to a CSV file.
 * It loads the metadata, processes it, and writes it to the specified destination path.
 * 
 * @since 1.2.0
 * @version 1.0
 * @see JellyfinCsvStructure
 * @author CesarBianchi
 */
public class JellyfinExportMetadata {
    private ArrayList<JellyfinCsvStructure> lines = new ArrayList();
    private ArrayList<String> header = new ArrayList();
    private String cDestinationPath = new String();
    private JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();  
    private JellyfinReportInventoryStructure items = new JellyfinReportInventoryStructure();
    
    /**
     * Default constructor for the JellyfinExportMetadata class.
     * 
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinExportMetadata() {
    }
    
    /**
     * Constructor for the JellyfinExportMetadata class with parameters.
     * 
     * @param cPath The destination path for the CSV file.
     * @param instData The instance data for the Jellyfin instance.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinExportMetadata(String cPath, JellyfinInstanceDetails instData) {
        this.setDestinationPath(cPath);
        this.setInstanceData(instData);
        this.loadHeader();
    }

    /**
     * Gets the destination path for the CSV file.
     * 
     * @return The destination path.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public String getDestinationPath() {
        return cDestinationPath;
    }
    
    /**
     * Sets the destination path for the CSV file.
     * 
     * @param cDestinationPath The destination path to set.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public void setDestinationPath(String cDestinationPath) {
        this.cDestinationPath = cDestinationPath;
    }
    
    /**
     * Gets the instance data for the Jellyfin instance.
     * 
     * @return The instance data.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinInstanceDetails getInstanceData() {
        return instanceData;
    }
    
    /**
     * Sets the instance data for the Jellyfin instance.
     * 
     * @param instanceData The instance data to set.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public void setInstanceData(JellyfinInstanceDetails instanceData) {
        this.instanceData = instanceData;
    }
    
    
    /**
     * Starts the process of exporting metadata from the Jellyfin instance to a CSV file.
     * 
     * This method performs the following steps:
     * 1. Checks if the destination path is not empty.
     * 2. Loads the items from the Jellyfin instance.
     * 3. Loads the sub-items for each item.
     * 4. Transforms the items and sub-items into lines for the CSV file.
     * 5. Creates the CSV file with the collected lines.
     * 
     * If any step fails, it sets the appropriate response code and message in the process result.
     * 
     * @return A JellyfinResponseStandard object containing the result of the process. If the process is successful, the response code is "CSV_EXP_001" and the response message indicates the file was generated successfully. If the process fails, the response code and message indicate the error.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinResponseStandard startProcess() {
        JellyfinResponseStandard processResult = new JellyfinResponseStandard();
        
        if (!this.getDestinationPath().isEmpty()){
            try {
                if (this.loadItems()){
                    
                    if (this.loadSubItems()){
                        
                        if (this.loadLines()){
                            
                            if (this.lines.size() > 0){
                                if (this.createCSVFile()){
                                    processResult.setIsSuccess(true);
                                    processResult.setResponseCode("CSV_EXP_001");
                                    processResult.setResponseMessage("The export file was successfully generated on ".concat(cDestinationPath));
                                } else {
                                    
                                }
                            }
                        } else {
                            processResult.setIsSuccess(false);
                            processResult.setResponseCode("CSV_EXP_002");
                            processResult.setResponseMessage("Error while trying transform object into a ArrayList. There's no a valid folder or Item to do it available on Jellyfin Instance!");
                        }
                    } else {
                        processResult.setIsSuccess(false);
                        processResult.setResponseCode("CSV_EXP_003");
                        processResult.setResponseMessage("Error while trying request subItems. Jellyfin Instance maybe is empty!");
                    }
                } else {
                    processResult.setIsSuccess(false);
                    processResult.setResponseCode("CSV_EXP_004");
                    processResult.setResponseMessage("Error while trying request subItems. Jellyfin Instance maybe is empty!");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(JellyfinExportMetadata.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(JellyfinExportMetadata.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        } else {
            processResult.setIsSuccess(false);
            processResult.setResponseCode("CSV_EXP_005");
            processResult.setResponseMessage("Error while trying create Export File. Destination path is empty!");
        }
        
        return processResult;
    }

    /**
     * Loads the items from the Jellyfin instance.
     * 
     * This method performs the following steps:
     * 1. Initializes a LoadFolders object to load folders and subfolders from the Jellyfin instance.
     * 2. Sets the Jellyfin instance URL, API token, and admin user ID for the LoadFolders object.
     * 3. Requests the folders from the Jellyfin instance.
     * 4. For each folder, initializes a JellyfinReportInventoryItem object and sets its item.
     * 5. Initializes a LoadItemMetadata object to load metadata for each item.
     * 6. Sets the Jellyfin instance URL, API token, admin user ID, and item ID for the LoadItemMetadata object.
     * 7. Requests the item metadata from the Jellyfin instance and sets it for the JellyfinReportInventoryItem object.
     * 8. Adds the JellyfinReportInventoryItem object to the items list.
     * 9. Sorts the items list by name in ascending order.
     * 
     * @return true if the items were loaded successfully, false otherwise.
     * @throws IOException If an I/O error occurs.
     * @throws MalformedURLException If the URL is malformed.
     * @throws ParseException If a parsing error occurs.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public boolean loadItems() throws IOException, MalformedURLException, ParseException {
        boolean lSuccess = false;
        
        LoadFolders loadItems = new LoadFolders(JellyfinParameters.FOLDERS_AND_SUBFOLDERS);
        loadItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadItems.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinFolders folders = loadItems.requestFolders();
        
        for(int nI = 0; nI < folders.getItems().size();nI++){            
            JellyfinReportInventoryItem item = new JellyfinReportInventoryItem();
            item.setItem( folders.getItems().get(nI) );
            
            //load itemMetadata
            LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
            loadItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            loadItemMetadata.setcItemID(item.getId());            
            JellyfinItemMetadata itemMetadata = loadItemMetadata.requestItemMetadata();            
            item.setItemMetadata(itemMetadata);
            
            items.add(item);
            lSuccess = true;
        }
        
        items.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
        
        return lSuccess;
    }
    
     /**
     * Loads the sub-items for each item from the Jellyfin instance.
     * 
     * This method performs the following steps:
     * 1. Initializes a LoadItems object to load sub-items from the Jellyfin instance.
     * 2. Sets the Jellyfin instance URL, API token, and admin user ID for the LoadItems object.
     * 3. For each item, sets the parent ID for the LoadItems object and requests the sub-items from the Jellyfin instance.
     * 4. Sets the sub-items for each item.
     * 5. For each sub-item, initializes a LoadItemMetadata object to load metadata for the sub-item.
     * 6. Sets the Jellyfin instance URL, API token, admin user ID, and sub-item ID for the LoadItemMetadata object.
     * 7. Requests the sub-item metadata from the Jellyfin instance and sets it for the sub-item.
     * 
     * @return true if the sub-items were loaded successfully, false otherwise.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public boolean loadSubItems() {
        boolean lSuccess = false;
        
        LoadItems loadSubItems = new LoadItems(JellyfinParameters.JUST_ITEMS);
        loadSubItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadSubItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadSubItems.setcUserAdminID(instanceData.adminUser.getId());
        
        lSuccess = true;
        
        for (int nI = 0; nI < items.size(); nI++){
            
            loadSubItems.setcParentID(items.get(nI).getId());            
            try {
                JellyfinItems subItems = loadSubItems.requestItems();
                
                items.get(nI).setSubItems(subItems);
                
                //load subitems metadata                
                for (int nJ = 0; nJ < items.get(nI).getSubItems().size(); nJ++){ 
                    LoadItemMetadata loadsubItemMetadata = new LoadItemMetadata();
                    loadsubItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
                    loadsubItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
                    loadsubItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
    
                    String subItemID = items.get(nI).getSubItems().get(nJ).getId();                            
    
                    loadsubItemMetadata.setcItemID(subItemID);                
                    JellyfinItemMetadata subItemMetadata = loadsubItemMetadata.requestItemMetadata();                                
    
                    items.get(nI).getSubItems().get(nJ).setSubItemMetadata(subItemMetadata);
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       return lSuccess;
    }

    /**
     * Loads the header for the CSV file.
     * 
     * This method retrieves the standard header fields from the JellyfinCsvStructure class
     * and adds their names to the header list.
     * 
     * @since 1.2.0
     * @author CesarBianchi
     */
    private void loadHeader() {
        Field[] declaredFields = getStandardHeader();
        
        for (int nI = 0; nI < declaredFields.length; nI++){
            this.header.add(declaredFields[nI].getName());
        }
    }
    
    /**
     * Retrieves the standard header fields from the JellyfinCsvStructure class.
     * 
     * @return An array of Field objects representing the standard header fields.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public Field[] getStandardHeader(){
        JellyfinCsvStructure csvStructure = new JellyfinCsvStructure();        
        Field[] declaredFields = csvStructure.getClass().getDeclaredFields();
        
        return declaredFields;
    }
    
        /**
     * Loads the lines for the CSV file from the items and sub-items.
     * 
     * This method performs the following steps:
     * 1. Initializes a JellyfinCsvStructure object and a TransformDateFormat object.
     * 2. Iterates over the items list and processes each item.
     * 3. For each item, sets the fields of the JellyfinCsvStructure object with the item's metadata.
     * 4. Adds the JellyfinCsvStructure object to the lines list.
     * 5. Iterates over the sub-items of each item and processes each sub-item.
     * 6. For each sub-item, sets the fields of the JellyfinCsvStructure object with the sub-item's metadata.
     * 7. Adds the JellyfinCsvStructure object to the lines list.
     * 
     * @return true if the lines were loaded successfully, false otherwise.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public boolean loadLines() {
        boolean lSuccess = false;
        
        JellyfinCsvStructure line = new JellyfinCsvStructure();
        TransformDateFormat transformDate = new TransformDateFormat();
        
        for (int nI = 0; nI < items.size(); nI++){
            
            // Do not add items type like "Playlist"
            // Otherwise, items can be duplicated in destination file
            if (!items.get(nI).getType().toUpperCase().contains("PLAYLIST")) {
                // Get parent record first and then, their childs            
                line.setId(items.get(nI).getId());            
                line.setParentId(items.get(nI).getItemMetadata().getParentId());
                line.setName(items.get(nI).getName());
                line.setOriginalTitle(items.get(nI).getItemMetadata().getOriginalTitle());
                line.setSortName(items.get(nI).getItemMetadata().getSortName());                       
                line.setForcedSortName(items.get(nI).getItemMetadata().getForcedSortName());
                line.setType(items.get(nI).getType());
                line.setCollectionType(items.get(nI).getCollectionType());
                line.setProductionYear(String.valueOf(items.get(nI).getProductionYear()));
                line.setCommunityRating(String.valueOf(items.get(nI).getCommunityRating()));
                line.setCriticRating(String.valueOf(items.get(nI).getCriticRating()));
                line.setOfficialRating(String.valueOf(items.get(nI).getOfficialRating()));
                line.setPremiereDate(transformDate.getSimpleDateFromFull(items.get(nI).getPremiereDate()));
                line.setDateCreated(transformDate.getSimpleDateFromFull(items.get(nI).getItemMetadata().getDateCreated()));
                line.setGenres(items.get(nI).getItemMetadata().getGenres());
                line.setPreferredMetadataLanguage(items.get(nI).getItemMetadata().getPreferredMetadataLanguage());
                line.setPreferredMetadataCountryCode(items.get(nI).getItemMetadata().getPreferredMetadataCountryCode());
                line.setStudios(items.get(nI).getItemMetadata().getStudios());
                line.setTags(items.get(nI).getTags());            
                line.setLocationType(items.get(nI).getLocationType());
                line.setMediaType(items.get(nI).getItemMetadata().getMediaType());
                line.setIsHD(items.get(nI).getItemMetadata().isIsHD());            
                line.setPath(items.get(nI).getItemMetadata().getPath());
                line.setJemmVersion(new JemmVersion().getVersion());
                line.setServerID(instanceData.getAdminUser().getServerId());
                line.setOverview(items.get(nI).getItemMetadata().getOverview());
    
                lines.add(line);
                line = new JellyfinCsvStructure();
                lSuccess = true;
    
                // Get the Childs Items
                for (int nJ = 0; nJ < items.get(nI).getSubItems().size(); nJ++){
                    line.setId(items.get(nI).getSubItems().get(nJ).getId());
                    line.setParentId(items.get(nI).getSubItems().get(nJ).getParentId());
                    line.setName(items.get(nI).getSubItems().get(nJ).getName());                
                    line.setOriginalTitle(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getOriginalTitle());                
                    line.setSortName(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getSortName());                
                    line.setForcedSortName(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getForcedSortName());
                    line.setType(items.get(nI).getSubItems().get(nJ).getType());
                    line.setCollectionType("<unavaiable>"); // There's no in subItems. Only Parents                
                    line.setProductionYear(String.valueOf(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getProductionYear()));                
                    line.setCommunityRating(String.valueOf(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getCommunityRating()));
                    line.setCriticRating(String.valueOf(items.get(nI).getSubItems().get(nJ).getCriticRating()));                
                    line.setOfficialRating(String.valueOf(items.get(nI).getSubItems().get(nJ).getOfficialRating()));                
                    line.setPremiereDate(transformDate.getSimpleDateFromFull(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getPremiereDate()));
                    line.setDateCreated(transformDate.getSimpleDateFromFull(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getDateCreated()));                
                    line.setGenres(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getGenres());                
                    line.setPreferredMetadataLanguage(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getPreferredMetadataLanguage());
                    line.setPreferredMetadataCountryCode(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getPreferredMetadataCountryCode());
                    line.setStudios(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getStudios());
                    line.setTags(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getTags());
                    line.setLocationType(items.get(nI).getSubItems().get(nJ).getLocationType());
                    line.setMediaType(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getMediaType());
                    line.setIsHD(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().isIsHD());
                    line.setPath(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getPath());
                    line.setJemmVersion(new JemmVersion().getVersion());
                    line.setServerID(instanceData.getAdminUser().getServerId());
                    line.setOverview(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getOverview());
    
                    lines.add(line);
                    line = new JellyfinCsvStructure();
                }
            }            
        }
        return lSuccess;
    }

    /**
     * Creates the CSV file with the collected metadata.
     * 
     * This method performs the following steps:
     * 1. Prints the header as the first line of the file.
     * 2. Prints all collected lines.
     * 3. Closes the file and opens it with the default application.
     * 
     * @return true if the CSV file was created successfully, false otherwise.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public boolean createCSVFile() {
        boolean lSuccess = false;        
        BufferedWriter writer;
        String lineToBeAdded = new String();
        String delimiter = new String(";");
        JellyfinCsvStructure newLine = new JellyfinCsvStructure();
        
        try {
            writer = new BufferedWriter(new FileWriter(this.getDestinationPath()));
            
            // Print the header as the first line of the file.
            for (int nI = 0; nI < this.header.size(); nI++){
                lineToBeAdded = lineToBeAdded.concat(header.get(nI));
                
                if (nI+1 != this.header.size()){
                    lineToBeAdded = lineToBeAdded.concat(delimiter);
                }                
            }            
            writer.write(lineToBeAdded);            
            writer.newLine();
            lineToBeAdded = "";
            
            // Then, print all collected lines
            for (int nI = 0; nI < this.lines.size(); nI++){
                
                newLine = this.lines.get(nI);
                lineToBeAdded = "";
                
                lineToBeAdded = lineToBeAdded.concat(newLine.getId()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getParentId()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getName()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getOriginalTitle()).concat(delimiter);                
                lineToBeAdded = lineToBeAdded.concat(newLine.getSortName()).concat(delimiter);                
                lineToBeAdded = lineToBeAdded.concat(newLine.getForcedSortName()).concat(delimiter);                
                lineToBeAdded = lineToBeAdded.concat(newLine.getType()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getCollectionType()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getProductionYear()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getCommunityRating()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getCriticRating()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getOfficialRating()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getPremiereDate()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getDateCreated()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getGenres()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getPreferredMetadataLanguage()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getPreferredMetadataCountryCode()).concat(delimiter);                
                lineToBeAdded = lineToBeAdded.concat(newLine.getStudios()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getTags()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getLocationType()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getMediaType()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getIsHD()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getPath()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getJemmVersion()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getServerID()).concat(delimiter);
                lineToBeAdded = lineToBeAdded.concat(newLine.getOverview());
                
                writer.write(lineToBeAdded);
                writer.newLine();
                lineToBeAdded = "";
            }
            
            // Finally, close the file and open it.
            writer.close();
            Desktop desktop = Desktop.getDesktop();
            File file = new File(this.getDestinationPath());
            if (file.exists()) {
                desktop.open(file);
            }
            lSuccess = true;
            
        } catch (IOException ex) {
            Logger.getLogger(JellyfinExportMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lSuccess;
    }
    
}
