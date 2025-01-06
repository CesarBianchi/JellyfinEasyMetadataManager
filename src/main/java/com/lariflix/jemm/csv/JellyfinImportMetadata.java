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

import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.utils.JellyfimParameters;
import com.lariflix.jemm.utils.JellyfinResponseStandard;
import com.lariflix.jemm.utils.TransformDateFormat;
import java.awt.Desktop;
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
import java.util.ArrayList;
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
    private String logDiferencesFile = new String();
    
    public JellyfinImportMetadata(){
        
    }
    
    public JellyfinImportMetadata(String cPath, JellyfinInstanceDetails instData){
        this.setOriginPath(cPath);
        this.setInstanceData(instData);
        this.setLogDiferencesFile();
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

    public JellyfinResponseStandard startProcess() {
        boolean lSuccess = false;
        JellyfinResponseStandard processStatus = new JellyfinResponseStandard();
        
        //1st: Check if the file header had the same structure as expected.
        try {
            processStatus = this.checkHeader();
            if (processStatus.isSuccess()){
                
            
                //2nd: Check if any line of file has more or less fields than expected. Needs to be the same quantity
                processStatus = this.preCheckLines();
                if (processStatus.isSuccess()){
                
                    //3rd: Create a kind of "From/To" Log Diferences.
                    processStatus = this.compareDiferences();
                    if (processStatus.isSuccess()){
                        System.out.println("Process is done! ");
                        
                        //TEMP _ OPEN LOG FILE
                        Desktop desktop = Desktop.getDesktop();
                        File file = new File(this.getLogDiferencesFile());
                        desktop.open(file);
                        
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
        headerFromFile = this.myTokenizer(headerLine);
        
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
                    fieldsinLine = this.myTokenizer(lineContent);
                    
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
    
    private ArrayList<String> myTokenizer(String cContent){
        ArrayList<String> items = new ArrayList();

        String[] elements = cContent.split(";");
        
        for (int nI = 0; nI < elements.length; nI++){
            items.add(elements[nI]);
        }
        
        return items;
    }

    private JellyfinResponseStandard compareDiferences() {
        JellyfinItem instanceItem = new JellyfinItem();
        JellyfinResponseStandard processStatus = new JellyfinResponseStandard ();
        TransformDateFormat transformDate = new TransformDateFormat();
        ArrayList<String> fieldsinLine = new ArrayList();
        String itemID = new String();
        String parentID = new String();
        String oldValue = new String();
        String newValue = new String();
        int indexID = 0;
        int indexParentID = 0;
        
        //1st: Log the start date on log Comparsion.
        this.startLogComparsion();
        
        //2nd: For each line, compare de diferences between the Instance and the FileLine.
        for (int nI = 0; nI < this.fileLines.size();nI++){
            
            //Deserialize the line in multiple Array items (each position is a field content)                
            fieldsinLine = this.myTokenizer(this.fileLines.get(nI));
            
            //get The ID and ParentID from analyzed line
            indexID = this.getDefaultIndexNumber("Id");
            indexParentID = this.getDefaultIndexNumber("ParentId");            
            itemID = fieldsinLine.get(indexID);
            parentID = fieldsinLine.get(indexParentID);
            
            //get the Item from Jellyfin Instance (API Called)            
            instanceItem = this.getItemFromInstance(itemID,parentID);
            String lineNumber = Integer.toString(nI+1);
            
            
            //Compare all fields between instance and line content
            
            //Name
            oldValue = instanceItem.getName();
            newValue = fieldsinLine.get(getDefaultIndexNumber("Name"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"Name",oldValue,newValue);
            
            
            //OriginalTitle
            oldValue = instanceItem.getItemMetadata().getOriginalTitle();
            newValue = fieldsinLine.get(getDefaultIndexNumber("OriginalTitle"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"OriginalTitle",oldValue,newValue);
            
            //SortName
            oldValue = instanceItem.getItemMetadata().getSortName();
            newValue = fieldsinLine.get(getDefaultIndexNumber("SortName"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"SortName",oldValue,newValue);
            
            //ForcedSortName
            oldValue = instanceItem.getItemMetadata().getForcedSortName();
            newValue = fieldsinLine.get(getDefaultIndexNumber("ForcedSortName"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"ForcedSortName",oldValue,newValue);
            
            //ProductionYear
            oldValue = Integer.toString(instanceItem.getProductionYear());
            newValue = fieldsinLine.get(getDefaultIndexNumber("ProductionYear"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"ProductionYear",oldValue,newValue);
            
            //CommunityRating
            oldValue = Integer.toString(instanceItem.getCommunityRating());
            newValue = fieldsinLine.get(getDefaultIndexNumber("CommunityRating"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"CommunityRating",oldValue,newValue);
            
            //CriticRating
            oldValue = Integer.toString(instanceItem.getCriticRating());
            newValue = fieldsinLine.get(getDefaultIndexNumber("CriticRating"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"CriticRating",oldValue,newValue);
            
            //OfficialRating
            oldValue = instanceItem.getOfficialRating();
            newValue = fieldsinLine.get(getDefaultIndexNumber("OfficialRating"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"OfficialRating",oldValue,newValue);

            //PremiereDate
            oldValue = transformDate.getSimpleDateFromFull(instanceItem.getPremiereDate());
            newValue = fieldsinLine.get(getDefaultIndexNumber("PremiereDate"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"PremiereDate",oldValue,newValue);

            //DateCreated
            oldValue = transformDate.getSimpleDateFromFull(instanceItem.getItemMetadata().getDateCreated());
            newValue = fieldsinLine.get(getDefaultIndexNumber("DateCreated"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"DateCreated",oldValue,newValue);
            
            //Genres
            JellyfinCsvStructure tmpObjGenres = new JellyfinCsvStructure();
            tmpObjGenres.setGenres(instanceItem.getItemMetadata().getGenres());            
            oldValue = tmpObjGenres.getGenres();
            newValue = fieldsinLine.get(getDefaultIndexNumber("Genres"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"Genres",oldValue,newValue);
            
            //PreferredMetadataLanguage
            oldValue = instanceItem.getItemMetadata().getPreferredMetadataLanguage();
            newValue = fieldsinLine.get(getDefaultIndexNumber("PreferredMetadataLanguage"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"PreferredMetadataLanguage",oldValue,newValue);
            
            //PreferredMetadataCountryCode
            oldValue = instanceItem.getItemMetadata().getPreferredMetadataCountryCode();
            newValue = fieldsinLine.get(getDefaultIndexNumber("PreferredMetadataCountryCode"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"PreferredMetadataCountryCode",oldValue,newValue);
            
            //Studios
            JellyfinCsvStructure tmpObjStudios = new JellyfinCsvStructure();
            tmpObjStudios.setStudios(instanceItem.getItemMetadata().getStudios());
            oldValue = tmpObjStudios.getStudios();
            newValue = fieldsinLine.get(getDefaultIndexNumber("Studios"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"Studios",oldValue,newValue);
            
            //Tags
            JellyfinCsvStructure tmpObjTags = new JellyfinCsvStructure();
            tmpObjTags.setTags( instanceItem.getItemMetadata().getTags());            
            oldValue = tmpObjTags.getTags();
            newValue = fieldsinLine.get(getDefaultIndexNumber("Tags"));
            if ((oldValue == null) || (!(oldValue.equals(newValue))))
                this.registerFieldDiference(lineNumber,"Tags",oldValue,newValue);
            
        }
        
        return processStatus;
    }

    private void startLogComparsion() {
        String cMsg = new String();
        
        cMsg = cMsg.concat("###########################");
        cMsg = cMsg.concat(" /n");
        cMsg = cMsg.concat("#Import Process started...#");
        cMsg = cMsg.concat(" /n");
        cMsg = cMsg.concat("###########################");
        cMsg = cMsg.concat(" /n");
        cMsg = cMsg.concat(" /n");
        cMsg = cMsg.concat("Total number of lines analyzed: ".concat(Integer.toString(this.getTotalLineToProcess())));
        cMsg = cMsg.concat(" /n");
        
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
       
        System.out.println(logFile);
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
        
        LoadItems loadInstanceItems = new LoadItems(JellyfimParameters.FOLDERS_AND_SUBFOLDERS);
        loadInstanceItems.setJellyfinInstanceUrl(baseURL);
        loadInstanceItems.setApiToken(apiToken);
        loadInstanceItems.setcUserAdminID(adminID);
        loadInstanceItems.setcParentID(parentID);
           
        try {
            JellyfinItems insItems = loadInstanceItems.requestItems();
            
            for (int nI = 0; nI < insItems.getItems().size(); nI++){
                
                item = insItems.getItems().get(nI);
                
                if (item.getId().equals(itemID)){
                    
                    LoadItemMetadata instItemMetadata = new LoadItemMetadata(baseURL,apiToken,adminID,itemID);                    
                    JellyfinItemMetadata itemMetadata = instItemMetadata.requestItemMetadata();
                    item.setItemMetadata(itemMetadata);
            
                    break;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return item;
    }

    private void registerFieldDiference(String lineNumber, String columnName, String oldValue, String newValue) {
        String cMsg = new String();
        
        if (oldValue == null)
            oldValue = "<empty>";
        
        
        cMsg = cMsg.concat("At line ").concat(lineNumber).concat(" ");
        cMsg = cMsg.concat( "the column '").concat(columnName).concat("' ");
        cMsg = cMsg.concat(" has the original value '").concat(oldValue).concat("' ");
        cMsg = cMsg.concat(" and will be replaced by '").concat(newValue).concat("' ");
        
        this.insertLogComparsionRecord(cMsg);
    }
    
    
}
