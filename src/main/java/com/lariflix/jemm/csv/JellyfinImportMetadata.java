/*
 * Copyright (C) 2025 cesarbianchi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.lariflix.jemm.csv;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinFolderMetadata;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.forms.MainWindow;
import com.lariflix.jemm.utils.JellyfinParameters;
import com.lariflix.jemm.utils.JellyfinResponseStandard;
import com.lariflix.jemm.utils.JemmVersion;
import com.lariflix.jemm.utils.TransformDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinImportMetadata {
    private String cOriginPath = new String();
    private JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();  
    private ArrayList<String> fileLines = new ArrayList();
    private ArrayList<String> linesChanged = new ArrayList();
    private String logDiferencesFile = new String();
    static ConnectJellyfinAPI connectAPI = new ConnectJellyfinAPI();
        
    private final int JUST_FOLDER_ITEM = 1;
    private final int FOLDER_AND_CONTENT = 2;
    private final int JUST_CONTENT_ITEM = 3;
    
    
    public JellyfinImportMetadata(){
        
    }
    
    public JellyfinImportMetadata(String cPath, JellyfinInstanceDetails instData){
        this.setOriginPath(cPath);
        this.setInstanceData(instData);
        this.setLogDiferencesFile();
        
        connectAPI.setcBaseURL(instanceData.getCredentials().getBaseURL());
        connectAPI.setcTokenApi(instanceData.getCredentials().getTokenAPI());
        
    }

    public ArrayList<String> getFileLines() {
        return fileLines;
    }

    public void setFileLines(ArrayList<String> fileLines) {
        this.fileLines = fileLines;
    }

    public String getLogDiferencesFile() {
        return logDiferencesFile;
    }

    public void setLogDiferencesFile() {
        Random rand = new Random();
        String tempDir = System.getProperty("java.io.tmpdir");
        String filename = "jemm_importcsv_differences_".concat(Integer.toString(rand.nextInt(50000)).concat(".log"));
        
        this.logDiferencesFile = tempDir.concat(filename);
    }

    
    
    private void setOriginPath(String cPath) {
        this.cOriginPath = cPath;
    }

    public JellyfinInstanceDetails getInstanceData() {
        return instanceData;
    }

    public void setInstanceData(JellyfinInstanceDetails instanceData) {
        this.instanceData = instanceData;
    }

    public String getcOriginPath() {
        return cOriginPath;
    }
    
    public int getTotalLineToProcess() {
        return this.fileLines.size();
    }

    public JellyfinResponseStandard startPreCheck() {
        boolean lSuccess = false;
        JellyfinResponseStandard processStatus = new JellyfinResponseStandard();
        
        //1st: Check if the file header had the same structure as expected.
        try {
            processStatus = this.checkHeader();
            if (processStatus.isSuccess()){
                
                //2nd: Check if any line of file has more or less fields than expected. Needs to be the same quantity
                processStatus = this.preCheckLines();
                if (processStatus.isSuccess()){
                
                    //3rd: Check if the file has one or more lines from different serverID (Instance) or
                    //was generated from older jemm version
                    processStatus = this.grantOrigin();
                    if (processStatus.isSuccess()){
                    
                        //4th: Create a kind of "From/To" Log Diferences.
                        processStatus = this.compareDiferencesInLine();                        
                    }
                }
            }    
        } catch (IOException ex) {
            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return processStatus;
    }

    private JellyfinResponseStandard checkHeader(){
        boolean lSuccess = false;
        JellyfinResponseStandard processResult = new JellyfinResponseStandard();
        
        //1st: Get the standard header expected
        Field[] standardHeader = new JellyfinExportMetadata().getStandardHeader();
        
        //2nd: Get the header present on file.
        ArrayList<String> fileHeader = new ArrayList();
        try {
            fileHeader = this.getHeaderFromFile();
        } catch (IOException ex) {
            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //3rd: Check if the fields between fileHeader and standardHeader are the same.
        if (fileHeader.size() == standardHeader.length){

            String field1 = new String();
            String field2 = new String();
            for (int nI = 0; nI < standardHeader.length; nI++){

                field1 = standardHeader[nI].getName();
                field2 = fileHeader.get(nI);
                
                if (!field1.equals(field2)){
                    processResult.setIsSuccess(false);
                    processResult.setResponseCode("CSV_IMP_003");
                    processResult.setResponseMessage("The fields/columns inside the CSV file are not equals to expected. Please, make sure you are using a CSV Exported File as a sample, with the same fields/columns and structure.");
                    break;
                } else {
                    processResult.setIsSuccess(true);
                    processResult.setResponseCode("CSV_IMP_004");
                    processResult.setResponseMessage("The fields/columns between the CSV file and to expected are the same. Good job!");
                }
                
            }
        } else if (fileHeader.size() < standardHeader.length) {
            processResult.setIsSuccess(false);
            processResult.setResponseCode("CSV_IMP_001");
            processResult.setResponseMessage("The file had less fields/columns than expected. Please, make sure you are using a CSV Exported File as a sample, with the same fields/columns and structure.");
        
        } else {
            processResult.setIsSuccess(false);
            processResult.setResponseCode("CSV_IMP_002");
            processResult.setResponseMessage("The file had more fields/columns than expected. Probably you add new fields in your CSV. Please, make sure you are using a CSV Exported File as a sample, with the same fields/columns and structure.");
        }
        
        return processResult;
    }
    
    private ArrayList<String> getHeaderFromFile() throws FileNotFoundException, IOException{
        ArrayList<String> headerFromFile = new ArrayList();
        String headerLine = new String();
        BufferedReader r = null;
        
        //Open and read the f1rst line of file.
        try {
            r = new BufferedReader(new FileReader(this.getcOriginPath()));       
            headerLine = r.readLine();
        } finally {
            r.close();
        }
        
        //Deserialize the line in multiple Array items
        headerFromFile = this.myTokenizer(headerLine,null);
        
        return headerFromFile;
    }

    private JellyfinResponseStandard preCheckLines() throws FileNotFoundException, IOException {
        JellyfinResponseStandard processResult = new JellyfinResponseStandard();
        String lineContent = new String();
        int totalFields = 0;
        int totalLines = 0;
        BufferedReader r = null;
        String cMsg = new String();
        ArrayList<String> fieldsinLine = new ArrayList();

        //1st: Set de fefault return
        processResult.setIsSuccess(true);
        processResult.setResponseCode("CSV_IMP_006");
        processResult.setResponseMessage("File lines (fields and columns) are ok");
        
        //2nd: Get the number total of Fields in StandardHeader
        totalFields = new JellyfinExportMetadata().getStandardHeader().length;
        
        //3rd: Check if there's the same total of fields in each line of CSV File.
        try {            
            r = new BufferedReader(new FileReader(this.getcOriginPath()));       
            
            while (true){
                lineContent = r.readLine();
                
                if (lineContent == null){
                    break;
                } else {
                    totalLines++;
                    
                    //Deserialize the line in multiple Array items                
                    fieldsinLine = this.myTokenizer(lineContent,null);
                    
                    //Check if the total fields isn't equal to totalFields
                    if (fieldsinLine.size() != totalFields){
                        cMsg = "The file line number ".concat(Integer.toString(totalLines)).concat(" ");
                        cMsg = cMsg.concat("has ").concat(Integer.toString(fieldsinLine.size())).concat(" fields/columns ");
                        cMsg = cMsg.concat("but expected ").concat(Integer.toString(totalFields));
                        cMsg = cMsg.concat(" fields/columns \n");
                        
                        processResult.setIsSuccess(false);
                        processResult.setResponseCode("CSV_IMP_005");
                        processResult.setResponseMessage(cMsg);
                        break;
                    } else {
                        if (totalLines > 1){
                            //Ignore the line 1, because is a header (Columns Titles)
                            this.fileLines.add(lineContent);
                        }
                    }
                }
            }
            
            
        } finally {
            r.close();
        }
        
        return processResult;
    }
    
    private ArrayList<String> myTokenizer(String cContent, String delimiter){
        
        String defaultDelimiter = ";";
        
        if ((delimiter == null) || (delimiter.isEmpty())){
            delimiter = defaultDelimiter;
        }
        
        ArrayList<String> items = new ArrayList();

        String[] elements = cContent.split(delimiter);
        
        for (int nI = 0; nI < elements.length; nI++){
            items.add(elements[nI]);
        }
        
        return items;
    }

    private JellyfinResponseStandard compareDiferencesInLine() {
        JellyfinItem instanceItem = new JellyfinItem();
        JellyfinResponseStandard processStatus = new JellyfinResponseStandard ();
        TransformDateFormat transformDate = new TransformDateFormat();
        ArrayList<String> fieldsinLine = new ArrayList();
        String itemID = new String();
        String parentID = new String();
        String oldValue = new String();
        String newValue = new String();
        boolean lChanged = false;
        int indexID = 0;
        int indexParentID = 0;
        
        //Set default return
        processStatus.setIsSuccess(true);
        processStatus.setResponseCode("CSV_IMP_010");
        processStatus.setResponseMessage("File ok");
        
        //1st: Log the start date on log Comparsion.
        this.startLogComparsion();
        
        //2nd: For each line, compare de diferences between the Instance and the FileLine.
        for (int nI = 0; nI < this.fileLines.size();nI++){
            
            //Deserialize the line in multiple Array items (each position is a field content)                
            fieldsinLine = this.myTokenizer(this.fileLines.get(nI),null);
            
            //get The ID and ParentID from analyzed line
            indexID = this.getDefaultIndexNumber("Id");
            indexParentID = this.getDefaultIndexNumber("ParentId");            
            itemID = fieldsinLine.get(indexID);
            parentID = fieldsinLine.get(indexParentID);
            lChanged = false;
            
            //get the Item from Jellyfin Instance (API Called)            
            instanceItem = this.getItemFromInstance(itemID,parentID);
            String lineNumber = Integer.toString(nI+1);
            
            //Grant that item was found in Jellyfin Instance before continue
            if ((instanceItem != null) && (instanceItem.getId() != null) && (instanceItem.getId().equals(itemID))) {
                
                //Then Compare all fields between instance and line content
                
                
                //Name
                oldValue = instanceItem.getName();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Name"));
                lChanged = this.compareValues(oldValue, newValue, "Name", lineNumber, lChanged);
                            
                //OriginalTitle
                oldValue = instanceItem.getItemMetadata().getOriginalTitle();
                newValue = fieldsinLine.get(getDefaultIndexNumber("OriginalTitle"));
                lChanged = this.compareValues(oldValue, newValue, "OriginalTitle", lineNumber, lChanged);

                //SortName
                oldValue = instanceItem.getItemMetadata().getSortName();
                newValue = fieldsinLine.get(getDefaultIndexNumber("SortName"));
                lChanged = this.compareValues(oldValue, newValue, "SortName", lineNumber, lChanged);
                
                //ForcedSortName
                oldValue = instanceItem.getItemMetadata().getForcedSortName();
                newValue = fieldsinLine.get(getDefaultIndexNumber("ForcedSortName"));
                lChanged = this.compareValues(oldValue, newValue, "ForcedSortName", lineNumber, lChanged);

                //ProductionYear
                oldValue = Integer.toString(instanceItem.getProductionYear());
                newValue = fieldsinLine.get(getDefaultIndexNumber("ProductionYear"));
                lChanged = this.compareValues(oldValue, newValue, "ProductionYear", lineNumber, lChanged);                                
                    
                //CommunityRating
                oldValue = Integer.toString(instanceItem.getCommunityRating());
                newValue = fieldsinLine.get(getDefaultIndexNumber("CommunityRating"));
                lChanged = this.compareValues(oldValue, newValue, "CommunityRating", lineNumber, lChanged);
                    
                //CriticRating
                oldValue = Integer.toString(instanceItem.getCriticRating());
                newValue = fieldsinLine.get(getDefaultIndexNumber("CriticRating"));
                lChanged = this.compareValues(oldValue, newValue, "CriticRating", lineNumber, lChanged);
                    
                //OfficialRating
                oldValue = instanceItem.getOfficialRating();
                newValue = fieldsinLine.get(getDefaultIndexNumber("OfficialRating"));
                lChanged = this.compareValues(oldValue, newValue, "OfficialRating", lineNumber, lChanged);
                
                //PremiereDate
                oldValue = transformDate.getSimpleDateFromFull(instanceItem.getPremiereDate());
                newValue = fieldsinLine.get(getDefaultIndexNumber("PremiereDate"));
                lChanged = this.compareValues(oldValue, newValue, "PremiereDate", lineNumber, lChanged);
                
                //DateCreated
                oldValue = transformDate.getSimpleDateFromFull(instanceItem.getItemMetadata().getDateCreated());
                newValue = fieldsinLine.get(getDefaultIndexNumber("DateCreated"));
                lChanged = this.compareValues(oldValue, newValue, "DateCreated", lineNumber, lChanged);

                //Genres
                JellyfinCsvStructure tmpObjGenres = new JellyfinCsvStructure();
                tmpObjGenres.setGenres(instanceItem.getItemMetadata().getGenres());            
                oldValue = tmpObjGenres.getGenres();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Genres"));                
                lChanged = this.compareValues(oldValue, newValue, "Genres", lineNumber, lChanged);
                
                //PreferredMetadataLanguage
                oldValue = instanceItem.getItemMetadata().getPreferredMetadataLanguage();
                newValue = fieldsinLine.get(getDefaultIndexNumber("PreferredMetadataLanguage"));
                lChanged = this.compareValues(oldValue, newValue, "PreferredMetadataLanguage", lineNumber, lChanged);
                    
                //PreferredMetadataCountryCode
                oldValue = instanceItem.getItemMetadata().getPreferredMetadataCountryCode();
                newValue = fieldsinLine.get(getDefaultIndexNumber("PreferredMetadataCountryCode"));
                lChanged = this.compareValues(oldValue, newValue, "PreferredMetadataCountryCode", lineNumber, lChanged);
                
                //Studios
                JellyfinCsvStructure tmpObjStudios = new JellyfinCsvStructure();
                tmpObjStudios.setStudios(instanceItem.getItemMetadata().getStudios());
                oldValue = tmpObjStudios.getStudios();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Studios"));
                lChanged = this.compareValues(oldValue, newValue, "Studios", lineNumber, lChanged);
                
                //Tags
                JellyfinCsvStructure tmpObjTags = new JellyfinCsvStructure();
                tmpObjTags.setTags( instanceItem.getItemMetadata().getTags());            
                oldValue = tmpObjTags.getTags();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Tags"));
                lChanged = this.compareValues(oldValue, newValue, "Tags", lineNumber, lChanged);
            
                //If have any field changed at line, add the full line to te array "linesChanged"
                if (lChanged){
                    this.linesChanged.add(this.fileLines.get(nI));
                }

                
            } else {
                String cInvalidIDMsg = new String();
                cInvalidIDMsg = cInvalidIDMsg.concat("At line ").concat(lineNumber);
                cInvalidIDMsg = cInvalidIDMsg.concat(" the ID ").concat(itemID);
                cInvalidIDMsg = cInvalidIDMsg.concat(" or the ParentID ").concat(parentID);
                cInvalidIDMsg = cInvalidIDMsg.concat(" is invalid. Make sure the selected CSV file is from the same Jellyfin Instance. ");
                this.insertLogComparsionRecord(cInvalidIDMsg);
                
                processStatus.setIsSuccess(false);
                processStatus.setResponseCode("CSV_IMP_009");
                processStatus.setResponseMessage("One or more lines has errors. The import process was stopped. Please check log file at ".concat(this.getLogDiferencesFile()));
            }
            
              
        }

        return processStatus;
    }

    private void startLogComparsion() {
        String cMsg = new String();
        
        Date dateNow = new Date();
        String date = new SimpleDateFormat("dd/MM/yyyy").format(dateNow);
        String hour = new SimpleDateFormat("HH:mm:ss").format(dateNow);

        
        
        cMsg = cMsg.concat("###########################");
        cMsg = cMsg.concat(" \n");
        cMsg = cMsg.concat("#Import Process started...#");
        cMsg = cMsg.concat(" \n");
        cMsg = cMsg.concat("###########################");
        cMsg = cMsg.concat(" \n");
        cMsg = cMsg.concat(" \n");
        cMsg = cMsg.concat("Log file generated at ".concat(date+" "+hour));
        cMsg = cMsg.concat(" \n");
        cMsg = cMsg.concat("Total number of lines analyzed: ".concat(Integer.toString(this.getTotalLineToProcess())));
        cMsg = cMsg.concat(" \n");
        
        this.insertLogComparsionRecord(cMsg);
        
    }

    private void insertLogComparsionRecord(String cMsg) {
        String logFile = this.getLogDiferencesFile();
        
        File f = new File(logFile);
        if(!f.exists()) { 
            try {
                //create the log diferences file.\
                PrintWriter writer = new PrintWriter(logFile, "UTF-8");
                writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //open the file and write it
        boolean lappend = true;
        try {
            FileWriter fstream = new FileWriter(logFile, lappend);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(cMsg.concat(" \n"));
            out.close();        
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    private int getDefaultIndexNumber(String fieldNameSearch){
        int index = -1;
        Field[] standardHeader = new JellyfinExportMetadata().getStandardHeader();
        
        for (int nI = 0; nI< standardHeader.length; nI++){
            if (standardHeader[nI].getName().equals(fieldNameSearch)){
                index = nI;                
                break;
            }            
        }
        
        return index;
    }

    private JellyfinItem getItemFromInstance(String itemID, String parentID) {
        JellyfinItem item = null;
        String baseURL = this.instanceData.getCredentials().getBaseURL();
        String apiToken = this.instanceData.getCredentials().getTokenAPI();
        String adminID = this.instanceData.getAdminUser().getId();
        
        LoadItems loadInstanceItems = new LoadItems(JellyfinParameters.FOLDERS_AND_SUBFOLDERS);
        loadInstanceItems.setJellyfinInstanceUrl(baseURL);
        loadInstanceItems.setApiToken(apiToken);
        loadInstanceItems.setcUserAdminID(adminID);
        loadInstanceItems.setcParentID(parentID);
           
        try {
            JellyfinItems insItems = loadInstanceItems.requestItems();
            
            for (int nI = 0; nI < insItems.getItems().size(); nI++){
                
                try {
                    item = insItems.getItems().get(nI);

                    if (item.getId().equals(itemID)){

                        LoadItemMetadata instItemMetadata = new LoadItemMetadata(baseURL,apiToken,adminID,itemID);                    
                        JellyfinItemMetadata itemMetadata = instItemMetadata.requestItemMetadata();
                        item.setItemMetadata(itemMetadata);

                        break;
                    }
                } catch (IOException ex) {
                    
                }
            }
            
        } catch (IOException ex) {
            //Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            //Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return item;
    }

    private void registerFieldDiference(String lineNumber, String columnName, String oldValue, String newValue) {
        String cMsg = new String();
        
        if (oldValue == null){
            oldValue = "<empty>";
        }
        
        cMsg = cMsg.concat("At line ").concat(lineNumber).concat(" ");
        cMsg = cMsg.concat("the column '").concat(columnName).concat("' ");
        cMsg = cMsg.concat("has the original value equal '").concat(oldValue).concat("' ");
        cMsg = cMsg.concat("and will be replaced by '").concat(newValue).concat("' ");
        
        this.insertLogComparsionRecord(cMsg);
    }

    private JellyfinResponseStandard grantOrigin() {
        JellyfinResponseStandard processResult = new JellyfinResponseStandard();
        String lineContent = new String();
        ArrayList<String> fieldsinLine = new ArrayList();
        int indexJemmVersion = 0;
        int indexServerID = 0;
        String JemmVersion = new String();
        String ServerID = new String();
        JellyfinCsvStructure csvUtils = new JellyfinCsvStructure();
        String JemmVersionRunning = new JemmVersion().getVersion();
        String ServerIDRunning = instanceData.getAdminUser().getServerId();
        
        //Set the default response
        processResult.setIsSuccess(true);
        processResult.setResponseCode("");
        processResult.setResponseMessage("All lines has a valid ServerID and JemmVersion");
        
        //Check all lines of file if there's unrecognized serverID or JemmVersion
        indexJemmVersion = this.getDefaultIndexNumber("JemmVersion");
        indexServerID = this.getDefaultIndexNumber("ServerID");
        
        for (int nI = 0; nI < this.fileLines.size(); nI++){
            lineContent = this.fileLines.get(nI);
            
            fieldsinLine = this.myTokenizer(lineContent,null);
            
            JemmVersion = fieldsinLine.get(indexJemmVersion);
            ServerID =  fieldsinLine.get(indexServerID);
            
            //1st: Check if JemmVersion present in line is the same of JemmVersion running
            if (!csvUtils.checkJellyfinVersionMD5(JemmVersion, JemmVersionRunning)){
                processResult.setIsSuccess(false);
                processResult.setResponseCode("CSV_IMP_007");
                processResult.setResponseMessage("The version of JEMM used to generate this file is different of version at running. Please make sure you are using a file exported from same version to import.");
                break;
            }
            
            //2nd: Check if ServerID present in line is the same of ServerID where Jemm is connected
            if (!ServerID.equals(ServerIDRunning)){
                processResult.setIsSuccess(false);
                processResult.setResponseCode("CSV_IMP_008");
                processResult.setResponseMessage("The ServerID registered in this file is different of ServerID where JEMM is connected. Probably, this file was generated from a different Jellyfin Instance. Please make sure you are using a file exported from same server/instance to import.");
                break;
            }
            
            
        }
                
        return processResult;
    }

    public JellyfinResponseStandard startImport() {
         JellyfinResponseStandard processResult = new JellyfinResponseStandard();
         ArrayList<String> fieldsinLine = new ArrayList();
         boolean isFolder = false;
         String itemID = new String();
         String ParentID = new String();
         
         for (int nI = 0; nI < this.linesChanged.size(); nI++){
         
             //1st: Transoform the line in fields array
             fieldsinLine = this.myTokenizer(this.linesChanged.get(nI),null);
             
             //2nd: Gets the ID, ParentID e then Identify if the line is refered to a Folder or a Item.
             itemID = fieldsinLine.get(getDefaultIndexNumber("Id"));
             ParentID = fieldsinLine.get(getDefaultIndexNumber("ParentId"));
             isFolder = fieldsinLine.get(getDefaultIndexNumber("Type")).toUpperCase().contains("FOLDER");
             
             if (isFolder){
                 
             } else {
                 //Before update an item, get their most recent data and update main instance object
                 if (this.refreshItensOfFolder(ParentID)) {;
                 
                    //Update item in the main object with values changed from file
                    this.updateItemInMainObj(itemID,ParentID,fieldsinLine);
                    
                 } else {
                     //TO DO TO DO
                 }
             }
                     
             
         }
         
         return processResult;
    }
    
    private boolean compareValues(String oldValue, String newValue, String property, String lineNumber, boolean lChangedBefore){
        boolean lChanged = false;
        
        if (oldValue == null){
            oldValue = "null";
        }
        
        if (!(oldValue.equals(newValue))) {
            this.registerFieldDiference(lineNumber,property,oldValue,newValue);
            lChanged = true;
        } else {
            if (lChangedBefore){
                lChanged = true;
            } else {
                lChanged = false;
            }
        }    
        
        return lChanged;
    }

    private boolean refreshItensOfFolder(String cParentID) {
        int nIndex = 0;
        boolean updateSuccess = false;
        boolean lFound = false;

        //1st: Get the index related ParentID
        for (int nI = 0; nI < instanceData.getFolders().getItems().size(); nI++ ){

            if (instanceData.getFolders().getItems().get(nI).getId().equals(cParentID)){
                nIndex = nI;
                lFound = true;
                break;
            }
        }


        //2nd: - Request Metadata for Selected Folder
        if (lFound) {
            JellyfinFolderMetadata folderMetadadta = null;        
            try {

                //2.1 - Request Folder Metadata
                folderMetadadta = connectAPI.getFolderMetadata(cParentID);

                //2.2 - Add folder metadata atributes to main instance object
                instanceData.getFolders().getItems().get(nIndex).setMetadata(folderMetadadta);

                //2.3 - Request Folder Content Items 
                JellyfinItems folderItems = new JellyfinItems();
                folderItems = connectAPI.getItems(cParentID);

                //2.4 - Add Folder Content Item to main instance object
                instanceData.getFolders().getItems().get(nIndex).setFolderContent(folderItems);

                if (folderItems != null){
                    updateSuccess = true; 
                }

            } catch (IOException | ParseException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            updateSuccess = false;
        }
        return updateSuccess;            
    }

    private void updateItemInMainObj(String itemID, String parentID,ArrayList<String> fieldsInLine) {
        JellyfinItem item = new JellyfinItem();
        
        //1st: Search the item in MainObject
        for (int nI = 0; nI < instanceData.getFolders().getItems().size(); nI++ ){

            if (instanceData.getFolders().getItems().get(nI).getId().equals(parentID)){
                
                for (int nJ = 0; nJ < instanceData.getFolders().getItems().get(nI).getFolderContent().getItems().size(); nJ++) {
                    item = instanceData.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ);
                    
                    if (item.getId().equals(itemID)){
                        /*
                        item.setName(fieldsInLine.get(getDefaultIndexNumber("Name")));
                        item.getItemMetadata().setOriginalTitle(fieldsInLine.get(getDefaultIndexNumber("OriginalTitle")));
                        item.getItemMetadata().setSortName(fieldsInLine.get(getDefaultIndexNumber("SortName")));
                        item.getItemMetadata().setForcedSortName(fieldsInLine.get(getDefaultIndexNumber("ForcedSortName")));
                        
                        item.setProductionYear(fieldsInLine.get(getDefaultIndexNumber("ProductionYear")));
                        item.getItemMetadata().setProductionYear(fieldsInLine.get(getDefaultIndexNumber("ProductionYear")));
                        
                        item.setCommunityRating(fieldsInLine.get(getDefaultIndexNumber("CommunityRating")));
                        item.getItemMetadata().setCommunityRating(fieldsInLine.get(getDefaultIndexNumber("CommunityRating")));
                                                
                        item.setCriticRating(fieldsInLine.get(getDefaultIndexNumber("CriticRating")));
                        item.getItemMetadata().setCriticRating(fieldsInLine.get(getDefaultIndexNumber("CriticRating")));
                        
                        item.setOfficialRating(fieldsInLine.get(getDefaultIndexNumber("OfficialRating")));
                        item.getItemMetadata().setOfficialRating(fieldsInLine.get(getDefaultIndexNumber("OfficialRating")));
                        
                        item.setPremiereDate(fieldsInLine.get(getDefaultIndexNumber("PremiereDate")));
                        item.getItemMetadata().setPremiereDate(fieldsInLine.get(getDefaultIndexNumber("PremiereDate")));
                        
                        item.getItemMetadata().setDateCreated(fieldsInLine.get(getDefaultIndexNumber("DateCreated")));
                        
                        ArrayList<String> lGenres = new ArrayList();
                        lGenres = this.myTokenizer(fieldsInLine.get(getDefaultIndexNumber("Genres")), " ,");
                        item.getItemMetadata().setGenres(lGenres);
                        
                        item.getItemMetadata().setPreferredMetadataLanguage(fieldsInLine.get(getDefaultIndexNumber("PreferredMetadataLanguage")));                        
                        item.getItemMetadata().setPreferredMetadataCountryCode(fieldsInLine.get(getDefaultIndexNumber("PreferredMetadataCountryCode")));
                        
                        //TO DO TO DO
                        //item.getItemMetadata().setStudios(fieldsInLine.get(getDefaultIndexNumber("Studios")));
                        
                        
                        ArrayList<String> lTags = new ArrayList();
                        lTags = this.myTokenizer(fieldsInLine.get(getDefaultIndexNumber("Tags")), " ,");                        
                        item.getItemMetadata().setTags(lTags);
                        
                        //2nd: Finally, update the item on Jellyfin Instance. (Make API Call)
                        try {                            
                            connectAPI.postUpdate(parentID, itemID, instanceData,JUST_CONTENT_ITEM);
                        } catch (IOException ex) {
                            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                    }
                    
                }
                
            }
        }
        
    }
    
}
