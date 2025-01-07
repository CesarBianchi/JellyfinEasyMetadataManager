
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
import com.lariflix.jemm.utils.JellyfimParameters;
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
 *
 * @author cesarbianchi
 */
public class JellyfinExportMetadata {
    private ArrayList<JellyfinCsvStructure> lines = new ArrayList();
    private ArrayList<String> header = new ArrayList();
    private String cDestinationPath = new String();
    private JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();  
    private JellyfinReportInventoryStructure items = new JellyfinReportInventoryStructure();
    
    public JellyfinExportMetadata(){
    }
    
    public JellyfinExportMetadata(String cPath, JellyfinInstanceDetails instData){
        this.setDestinationPath(cPath);
        this.setInstanceData(instData);
        this.loadHeader();
    }

    public String getDestinationPath() {
        return cDestinationPath;
    }

    public void setDestinationPath(String cDestinationPath) {
        this.cDestinationPath = cDestinationPath;
    }

    public JellyfinInstanceDetails getInstanceData() {
        return instanceData;
    }

    public void setInstanceData(JellyfinInstanceDetails instanceData) {
        this.instanceData = instanceData;
    }
    
    
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

    private boolean loadItems() throws IOException, MalformedURLException, ParseException{
        boolean lSuccess = false;
        
        LoadFolders loadItems = new LoadFolders(JellyfimParameters.FOLDERS_AND_SUBFOLDERS);
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
    
    private boolean loadSubItems(){
        boolean lSuccess = false;
        
        LoadItems loadSubItems = new LoadItems(JellyfimParameters.JUST_ITEMS);
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

    private void loadHeader() {
        Field[] declaredFields = getStandardHeader();
        
        for (int nI = 0; nI < declaredFields.length; nI++){
            this.header.add(declaredFields[nI].getName());
        }
        
    }

    public Field[] getStandardHeader(){
        JellyfinCsvStructure csvStructure = new JellyfinCsvStructure();        
        Field[] declaredFields = csvStructure.getClass().getDeclaredFields();
        
        return declaredFields;
    }
    
    private boolean loadLines() {
        boolean lSuccess = false;
        
        JellyfinCsvStructure line = new JellyfinCsvStructure();
        TransformDateFormat transformDate = new TransformDateFormat();
        
        for (int nI = 0; nI < items.size(); nI++){
            
            //Get parent record first and then, their childs            
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
            line.setJemmVersion( new JemmVersion().getVersion());
            line.setServerID(instanceData.getAdminUser().getServerId());
            
            lines.add(line);
            line = new JellyfinCsvStructure();
            lSuccess = true;
            
            //Get the Childs Items
            for (int nJ = 0; nJ < items.get(nI).getSubItems().size(); nJ++){
                line.setId(items.get(nI).getSubItems().get(nJ).getId());
                line.setParentId(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getParentId());
                line.setName(items.get(nI).getSubItems().get(nJ).getName());                
                line.setOriginalTitle(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getOriginalTitle());                
                line.setSortName(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getSortName());                
                line.setForcedSortName(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getForcedSortName());
                line.setType(items.get(nI).getSubItems().get(nJ).getType());
                line.setCollectionType("<unavaiable>"); //There's no in subItems. Only Parents                
                line.setProductionYear(String.valueOf(items.get(nI).getSubItems().get(nJ).getProductionYear()));                
                line.setCommunityRating(String.valueOf(items.get(nI).getSubItems().get(nJ).getCommunityRating()));
                line.setCriticRating(String.valueOf(items.get(nI).getSubItems().get(nJ).getCriticRating()));                
                line.setOfficialRating(String.valueOf(items.get(nI).getSubItems().get(nJ).getOfficialRating()));                
                line.setPremiereDate(transformDate.getSimpleDateFromFull(items.get(nI).getSubItems().get(nJ).getPremiereDate()));
                line.setDateCreated(transformDate.getSimpleDateFromFull(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getDateCreated() ));                
                line.setGenres(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getGenres());                
                line.setPreferredMetadataLanguage(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getPreferredMetadataLanguage());
                line.setPreferredMetadataCountryCode(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getPreferredMetadataCountryCode());
                line.setStudios(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getStudios());
                line.setTags(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getTags());
                line.setLocationType(items.get(nI).getSubItems().get(nJ).getLocationType());
                line.setMediaType(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getMediaType());
                line.setIsHD(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().isIsHD());
                line.setPath(items.get(nI).getSubItems().get(nJ).getSubItemMetadata().getPath());
                line.setJemmVersion( new JemmVersion().getVersion());
                line.setServerID(instanceData.getAdminUser().getServerId());
                
                lines.add(line);
                line = new JellyfinCsvStructure();
            }
            
            
        }
        return lSuccess;
    }

    private boolean createCSVFile() {
        boolean lSuccess = false;        
        BufferedWriter writer;
        String lineToBeAdded = new String();
        String delimiter = new String(";");
        JellyfinCsvStructure newLine = new JellyfinCsvStructure();
        
        try {
            writer = new BufferedWriter(new FileWriter(this.getDestinationPath()));
            
            //1* Print the "header" as a f1rst line of file.
            for (int nI = 0; nI < this.header.size(); nI++){
                lineToBeAdded = lineToBeAdded.concat(header.get(nI));
                
                if (nI+1 != this.header.size()){
                    lineToBeAdded = lineToBeAdded.concat(delimiter);
                }                
            }            
            writer.write(lineToBeAdded);            
            writer.newLine();
            lineToBeAdded = "";
            
            //2* Then, print all collected lines
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
                lineToBeAdded = lineToBeAdded.concat(newLine.getServerID());
                
                writer.write(lineToBeAdded);
                writer.newLine();
                lineToBeAdded = "";
            }
            
            //3* Finally, close the file and open it.
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
