
package com.lariflix.jemm.csv;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinFolder;
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
 * The JellyfinImportMetadata class is responsible for importing metadata from a CSV file into a Jellyfin instance.
 * It performs various checks to ensure the integrity of the data and updates the Jellyfin instance accordingly.
 * 
 * @since 1.2.0
 * @version 1.0
 * @see JellyfinCsvStructure
 * @author CesarBianchi
 */
public class JellyfinImportMetadata {
    private String cOriginPath = new String();
    private JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();  
    private ArrayList<String> fileLines = new ArrayList();
    private ArrayList<String> linesChanged = new ArrayList();
    private String logDiferencesFile = new String();
    private JellyfinResponseStandard processFinalResult = new JellyfinResponseStandard();
    static ConnectJellyfinAPI connectAPI = new ConnectJellyfinAPI();
    
    /**
     * Default constructor for the JellyfinImportMetadata class.
     * 
     * @since 1.2.0
     * @version 1.0
     * @author CesarBianchi
     */
    public JellyfinImportMetadata() {
    }
    
    /**
     * Constructor for the JellyfinImportMetadata class with parameters.
     * 
     * @param cPath The origin path of the CSV file.
     * @param instData The instance data for the Jellyfin instance.
     * @since 1.2.0
     * @version 1.0
     * @author CesarBianchi
     */
    public JellyfinImportMetadata(String cPath, JellyfinInstanceDetails instData) {
        this.setOriginPath(cPath);
        this.setInstanceData(instData);
        this.setLogDiferencesFile();
        
        connectAPI.setcBaseURL(instanceData.getCredentials().getBaseURL());
        connectAPI.setcTokenApi(instanceData.getCredentials().getTokenAPI());
    }

        /**
     * Gets the file lines from the CSV file.
     * 
     * @return The file lines.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public ArrayList<String> getFileLines() {
        return fileLines;
    }
    
    /**
     * Sets the file lines from the CSV file.
     * 
     * @param fileLines The file lines to set.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public void setFileLines(ArrayList<String> fileLines) {
        this.fileLines = fileLines;
    }
    
    /**
     * Gets the log differences file path.
     * 
     * @return The log differences file path.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public String getLogDiferencesFile() {
        return logDiferencesFile;
    }
    
    /**
     * Sets the log differences file path.
     * 
     * @since 1.2.0
     * @author CesarBianchi
     */
    public void setLogDiferencesFile() {
        Random rand = new Random();
        String tempDir = System.getProperty("java.io.tmpdir");
        String filename = "jemm_importcsv_differences_".concat(Integer.toString(rand.nextInt(50000)).concat(".log"));
        
        this.logDiferencesFile = tempDir.concat(filename);
    }
    
    /**
     * Sets the origin path of the CSV file.
     * 
     * @param cPath The origin path of the CSV file.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public void setOriginPath(String cPath) {
        this.cOriginPath = cPath;
    }
    
    /**
     * Gets the Jellyfin instance data.
     * 
     * @return The Jellyfin instance data.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinInstanceDetails getInstanceData() {
        return instanceData;
    }
    
    /**
     * Sets the Jellyfin instance data.
     * 
     * @param instanceData The Jellyfin instance data to set.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public void setInstanceData(JellyfinInstanceDetails instanceData) {
        this.instanceData = instanceData;
    }    

    /**
     * Gets the origin path of the CSV file.
     * 
     * @return The origin path of the CSV file.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public String getcOriginPath() {
        return cOriginPath;
    }
    
    /**
     * Gets the total number of lines to be processed.
     * 
     * @return The total number of lines to be processed.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public int getTotalLineToProcess() {
        return this.fileLines.size();
    }

    /**
     * Starts the pre-check process for importing metadata from a CSV file into a Jellyfin instance.
     * 
     * This method performs the following steps:
     * 1. Checks if the file header has the same structure as expected.
     * 2. Checks if any line of the file has more or fewer fields than expected.
     * 3. Checks if the file has one or more lines from a different server ID (Instance) or was generated from an older JEMM version.
     * 4. Creates a "From/To" differences log.
     * 
     * @return A JellyfinResponseStandard object containing the result of the process. If the process is successful, the response code and message indicate success. If the process fails, the response code and message indicate the error.
     * @since 1.2.0
     * @version 1.0
     * @author CesarBianchi
     */
    public JellyfinResponseStandard startPreCheck() {
        boolean lSuccess = false;
        JellyfinResponseStandard processStatus = new JellyfinResponseStandard();
        
        if (!this.getcOriginPath().isEmpty()){
        
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
        } else {
            processStatus.setIsSuccess(false);
            processStatus.setResponseCode("CSV_IMP_011");
            processStatus.setResponseMessage("Origin file not found");
        }
        return processStatus;
    }

        /**
     * Checks if the header of the CSV file matches the expected standard header.
     * 
     * This method performs the following steps:
     * 1. Gets the standard header expected.
     * 2. Gets the header present in the file.
     * 3. Checks if the fields between the file header and the standard header are the same.
     * 
     * @return A JellyfinResponseStandard object containing the result of the check. If the headers match, the response code and message indicate success. If the headers do not match, the response code and message indicate the error.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinResponseStandard checkHeader() {
        boolean lSuccess = false;
        JellyfinResponseStandard processResult = new JellyfinResponseStandard();
        
        //1st: Get the standard header expected
        Field[] standardHeader = new JellyfinExportMetadata().getStandardHeader();
        
        //2nd: Get the header present on file.
        ArrayList<String> fileHeader = new ArrayList<>();
        try {
            fileHeader = this.getHeaderFromFile();
        } catch (IOException ex) {
            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //3rd: Check if the fields between fileHeader and standardHeader are the same.
        if (fileHeader.size() == standardHeader.length) {
    
            String field1 = new String();
            String field2 = new String();
            for (int nI = 0; nI < standardHeader.length; nI++) {
    
                field1 = standardHeader[nI].getName();
                field2 = fileHeader.get(nI);
                
                if (!field1.equals(field2)) {
                    processResult.setIsSuccess(false);
                    processResult.setResponseCode("CSV_IMP_003");
                    processResult.setResponseMessage("The fields/columns inside the CSV file are not equal to expected. Please, make sure you are using a CSV Exported File as a sample, with the same fields/columns and structure.");
                    break;
                } else {
                    processResult.setIsSuccess(true);
                    processResult.setResponseCode("CSV_IMP_004");
                    processResult.setResponseMessage("The fields/columns between the CSV file and the expected are the same. Good job!");
                }
            }
        } else if (fileHeader.size() < standardHeader.length) {
            processResult.setIsSuccess(false);
            processResult.setResponseCode("CSV_IMP_001");
            processResult.setResponseMessage("The file had fewer fields/columns than expected. Please, make sure you are using a CSV Exported File as a sample, with the same fields/columns and structure.");
        
        } else {
            processResult.setIsSuccess(false);
            processResult.setResponseCode("CSV_IMP_002");
            processResult.setResponseMessage("The file had more fields/columns than expected. Probably you added new fields in your CSV. Please, make sure you are using a CSV Exported File as a sample, with the same fields/columns and structure.");
        }
        
        return processResult;
    }
    
    public ArrayList<String> getHeaderFromFile() throws FileNotFoundException, IOException{
        ArrayList<String> headerFromFile = new ArrayList();
        String headerLine = new String();
        BufferedReader r = null;
        
        //Open and read the f1rst line of file.
        try {
            r = new BufferedReader(new FileReader(this.getcOriginPath()));       
            headerLine = r.readLine();
        } finally {
            if (r != null)
                r.close();
        }
        
        //Deserialize the line in multiple Array items
        headerFromFile = this.myTokenizer(headerLine,null);
        
        return headerFromFile;
    }

        /**
     * Checks if each line of the CSV file has the same number of fields as expected.
     * 
     * This method performs the following steps:
     * 1. Sets the default return values.
     * 2. Gets the total number of fields in the standard header.
     * 3. Checks if each line of the CSV file has the same number of fields as the standard header.
     * 
     * @return A JellyfinResponseStandard object containing the result of the check. If the lines are valid, the response code and message indicate success. If any line has an incorrect number of fields, the response code and message indicate the error.
     * @throws FileNotFoundException If the CSV file is not found.
     * @throws IOException If an I/O error occurs.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinResponseStandard preCheckLines() throws FileNotFoundException, IOException {
        JellyfinResponseStandard processResult = new JellyfinResponseStandard();
        String lineContent = new String();
        int totalFields = 0;
        int totalLines = 0;
        BufferedReader r = null;
        String cMsg = new String();
        ArrayList<String> fieldsinLine = new ArrayList();
    
        //1st: Set the default return
        processResult.setIsSuccess(true);
        processResult.setResponseCode("CSV_IMP_006");
        processResult.setResponseMessage("File lines (fields and columns) are ok");
        
        //2nd: Get the total number of fields in the standard header
        totalFields = new JellyfinExportMetadata().getStandardHeader().length;
        
        //3rd: Check if each line of the CSV file has the same number of fields as the standard header
        if (!this.getcOriginPath().isEmpty()) {
            try {            
                r = new BufferedReader(new FileReader(this.getcOriginPath()));

                while (true){
                    lineContent = r.readLine();

                    if (lineContent == null){
                        break;
                    } else {
                        totalLines++;

                        // Deserialize the line into multiple array items                
                        fieldsinLine = this.myTokenizer(lineContent, null);

                        // Check if the total fields is not equal to totalFields
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
                                // Ignore the line 1, because it is a header (Columns Titles)
                                this.fileLines.add(lineContent);
                            }
                        }
                    }
                }

            } finally {
                if (r != null)
                    r.close();
            }
        }
        
        return processResult;
    }
    
    /**
     * Tokenizes a string into an ArrayList of strings based on a specified delimiter.
     * 
     * @param cContent The string content to be tokenized.
     * @param delimiter The delimiter to be used for tokenizing the string. If null or empty, the default delimiter ";" is used.
     * @return An ArrayList of strings resulting from the tokenization.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public ArrayList<String> myTokenizer(String cContent, String delimiter){
        
        String defaultDelimiter = ";";
        
        if ((delimiter == null) || (delimiter.isEmpty())){
            delimiter = defaultDelimiter;
        }
        
        ArrayList<String> items = new ArrayList<>();
    
        String[] elements = cContent.split(delimiter);
        
        for (int nI = 0; nI < elements.length; nI++){
            items.add(elements[nI]);
        }
        
        return items;
    }

        /**
     * Compares the differences between the instance data and the file lines.
     * 
     * This method performs the following steps:
     * 1. Logs the start date of the comparison.
     * 2. For each line, compares the differences between the instance data and the file line.
     * 3. If any field has changed, adds the full line to the array "linesChanged".
     * 
     * @return A JellyfinResponseStandard object containing the result of the comparison. If the comparison is successful, the response code and message indicate success. If any line has errors, the response code and message indicate the error.
     * @since 1.2.0
     * @author CesarBianchi
     */
    private JellyfinResponseStandard compareDiferencesInLine() {
        JellyfinItem instanceItem = new JellyfinItem();
        JellyfinResponseStandard processStatus = new JellyfinResponseStandard();
        TransformDateFormat transformDate = new TransformDateFormat();
        ArrayList<String> fieldsinLine = new ArrayList<>();
        String itemID = new String();
        String parentID = new String();
        String oldValue = new String();
        String newValue = new String();
        boolean lChanged = false;
        int indexID = 0;
        int indexParentID = 0;
        
        // Set default return
        processStatus.setIsSuccess(true);
        processStatus.setResponseCode("CSV_IMP_010");
        processStatus.setResponseMessage("Pre-check import process ok. File ready to be imported!");
        
        // 1st: Log the start date on log Comparsion.
        this.startLogComparsion();
        
        // 2nd: For each line, compare the differences between the Instance and the FileLine.
        for (int nI = 0; nI < this.fileLines.size(); nI++){
            
            // Deserialize the line into multiple Array items (each position is a field content)
            fieldsinLine = this.myTokenizer(this.fileLines.get(nI), null);
            
            // Get the ID and ParentID from analyzed line
            indexID = this.getDefaultIndexNumber("Id");
            indexParentID = this.getDefaultIndexNumber("ParentId");
            itemID = fieldsinLine.get(indexID);
            parentID = fieldsinLine.get(indexParentID);
            lChanged = false;
            
            // Get the Item from Jellyfin Instance (API Called)
            instanceItem = this.getItemFromInstance(itemID, parentID);
            String lineNumber = Integer.toString(nI + 1);
            
            // Ensure that item was found in Jellyfin Instance before continuing
            if ((instanceItem != null) && (instanceItem.getId() != null) && (instanceItem.getId().equals(itemID))) {
                
                // Then compare all fields between instance and line content
                
                // Name
                oldValue = instanceItem.getName();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Name"));
                lChanged = this.compareValues(oldValue, newValue, "Name", lineNumber, lChanged);
                            
                // OriginalTitle
                oldValue = instanceItem.getItemMetadata().getOriginalTitle();
                newValue = fieldsinLine.get(getDefaultIndexNumber("OriginalTitle"));
                lChanged = this.compareValues(oldValue, newValue, "OriginalTitle", lineNumber, lChanged);
    
                // SortName
                oldValue = instanceItem.getItemMetadata().getSortName();
                newValue = fieldsinLine.get(getDefaultIndexNumber("SortName"));
                lChanged = this.compareValues(oldValue, newValue, "SortName", lineNumber, lChanged);
                
                // ForcedSortName
                oldValue = instanceItem.getItemMetadata().getForcedSortName();
                newValue = fieldsinLine.get(getDefaultIndexNumber("ForcedSortName"));
                lChanged = this.compareValues(oldValue, newValue, "ForcedSortName", lineNumber, lChanged);
    
                // ProductionYear
                oldValue = Integer.toString(instanceItem.getProductionYear());
                newValue = fieldsinLine.get(getDefaultIndexNumber("ProductionYear"));
                lChanged = this.compareValues(oldValue, newValue, "ProductionYear", lineNumber, lChanged);                                
                    
                // CommunityRating
                oldValue = Integer.toString(instanceItem.getCommunityRating());
                newValue = fieldsinLine.get(getDefaultIndexNumber("CommunityRating"));
                lChanged = this.compareValues(oldValue, newValue, "CommunityRating", lineNumber, lChanged);
                    
                // CriticRating
                oldValue = Integer.toString(instanceItem.getCriticRating());
                newValue = fieldsinLine.get(getDefaultIndexNumber("CriticRating"));
                lChanged = this.compareValues(oldValue, newValue, "CriticRating", lineNumber, lChanged);
                    
                // OfficialRating
                oldValue = instanceItem.getOfficialRating();
                newValue = fieldsinLine.get(getDefaultIndexNumber("OfficialRating"));
                lChanged = this.compareValues(oldValue, newValue, "OfficialRating", lineNumber, lChanged);
                
                // PremiereDate
                oldValue = transformDate.getSimpleDateFromFull(instanceItem.getPremiereDate());
                newValue = fieldsinLine.get(getDefaultIndexNumber("PremiereDate"));
                lChanged = this.compareValues(oldValue, newValue, "PremiereDate", lineNumber, lChanged);
                
                // DateCreated
                oldValue = transformDate.getSimpleDateFromFull(instanceItem.getItemMetadata().getDateCreated());
                newValue = fieldsinLine.get(getDefaultIndexNumber("DateCreated"));
                lChanged = this.compareValues(oldValue, newValue, "DateCreated", lineNumber, lChanged);
    
                // Genres
                JellyfinCsvStructure tmpObjGenres = new JellyfinCsvStructure();
                tmpObjGenres.setGenres(instanceItem.getItemMetadata().getGenres());            
                oldValue = tmpObjGenres.getGenres();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Genres"));                
                lChanged = this.compareValues(oldValue, newValue, "Genres", lineNumber, lChanged);
                
                // PreferredMetadataLanguage
                oldValue = instanceItem.getItemMetadata().getPreferredMetadataLanguage();
                newValue = fieldsinLine.get(getDefaultIndexNumber("PreferredMetadataLanguage"));
                lChanged = this.compareValues(oldValue, newValue, "PreferredMetadataLanguage", lineNumber, lChanged);
                    
                // PreferredMetadataCountryCode
                oldValue = instanceItem.getItemMetadata().getPreferredMetadataCountryCode();
                newValue = fieldsinLine.get(getDefaultIndexNumber("PreferredMetadataCountryCode"));
                lChanged = this.compareValues(oldValue, newValue, "PreferredMetadataCountryCode", lineNumber, lChanged);
                
                // Studios
                JellyfinCsvStructure tmpObjStudios = new JellyfinCsvStructure();
                tmpObjStudios.setStudios(instanceItem.getItemMetadata().getStudios());
                oldValue = tmpObjStudios.getStudios();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Studios"));
                lChanged = this.compareValues(oldValue, newValue, "Studios", lineNumber, lChanged);
                
                // Tags
                JellyfinCsvStructure tmpObjTags = new JellyfinCsvStructure();
                tmpObjTags.setTags(instanceItem.getItemMetadata().getTags());            
                oldValue = tmpObjTags.getTags();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Tags"));
                lChanged = this.compareValues(oldValue, newValue, "Tags", lineNumber, lChanged);
            
                // Overview
                oldValue = instanceItem.getItemMetadata().getOverview();
                newValue = fieldsinLine.get(getDefaultIndexNumber("Overview")).replace(" || ", "\n");
                lChanged = this.compareValues(oldValue, newValue, "Overview", lineNumber, lChanged);
                
                // If any field changed at line, add the full line to the array "linesChanged"
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

        /**
     * Logs the start date of the comparison process.
     * 
     * This method creates a log entry with the start date, the analyzed CSV file path, and the total number of lines to be processed.
     * 
     * @since 1.2.0
     * @author CesarBianchi
     */
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
        cMsg = cMsg.concat("CSV File analyzed: ".concat(this.getcOriginPath()));
        cMsg = cMsg.concat(" \n");
        cMsg = cMsg.concat("Total number of lines analyzed: ".concat(Integer.toString(this.getTotalLineToProcess())));
        cMsg = cMsg.concat(" \n");
        
        this.insertLogComparsionRecord(cMsg);
    }
    
    /**
     * Inserts a log entry into the log differences file.
     * 
     * This method opens the log differences file and writes the provided message to it. If the file does not exist, it creates a new one.
     * 
     * @param cMsg The message to be logged.
     * @since 1.2.0
     * @author CesarBianchi
     */
    private void insertLogComparsionRecord(String cMsg) {
        String logFile = this.getLogDiferencesFile();
        
        File f = new File(logFile);
        if(!f.exists()) { 
            try {
                //create the log diferences file.
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

    /**
     * Retrieves an item from the Jellyfin instance based on the item ID and parent ID.
     * 
     * @param itemID The ID of the item to retrieve.
     * @param parentID The ID of the parent item.
     * @return The JellyfinItem object retrieved from the instance, or null if not found.
     * @since 1.2.0
     * @author CesarBianchi
     */
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
    
                        LoadItemMetadata instItemMetadata = new LoadItemMetadata(baseURL, apiToken, adminID, itemID);                    
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

    /**
     * Registers a field difference in the log.
     * 
     * This method creates a log entry indicating the difference between the old and new values of a field.
     * 
     * @param lineNumber The line number where the difference was found.
     * @param columnName The name of the column where the difference was found.
     * @param oldValue The original value of the field.
     * @param newValue The new value of the field.
     * @since 1.2.0
     * @author CesarBianchi
     */
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
    
    /**
     * Checks the origin of the CSV file to ensure it matches the current Jellyfin instance.
     * 
     * This method performs the following steps:
     * 1. Sets the default response.
     * 2. Checks all lines of the file for unrecognized server ID or JEMM version.
     * 3. Verifies if the JEMM version and server ID in the file match the current instance.
     * 
     * @return A JellyfinResponseStandard object containing the result of the check. If the origin is valid, the response code and message indicate success. If the origin is invalid, the response code and message indicate the error.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public JellyfinResponseStandard grantOrigin() {
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
        processResult.setResponseMessage("All lines have a valid ServerID and JemmVersion");
        
        //Check all lines of file if there's unrecognized serverID or JemmVersion
        indexJemmVersion = this.getDefaultIndexNumber("JemmVersion");
        indexServerID = this.getDefaultIndexNumber("ServerID");
        
        for (int nI = 0; nI < this.fileLines.size(); nI++){
            lineContent = this.fileLines.get(nI);
            
            fieldsinLine = this.myTokenizer(lineContent,null);
            
            JemmVersion = fieldsinLine.get(indexJemmVersion);
            ServerID =  fieldsinLine.get(indexServerID);
            
            //1st: Check if JemmVersion present in line is the same as the JemmVersion running
            if (!csvUtils.checkJellyfinVersionMD5(JemmVersion, JemmVersionRunning)){
                processResult.setIsSuccess(false);
                processResult.setResponseCode("CSV_IMP_007");
                processResult.setResponseMessage("The version of JEMM used to generate this file is different from the version running. Please make sure you are using a file exported from the same version to import.");
                break;
            }
            
            //2nd: Check if ServerID present in line is the same as the ServerID where Jemm is connected
            if (!ServerID.equals(ServerIDRunning)){
                processResult.setIsSuccess(false);
                processResult.setResponseCode("CSV_IMP_008");
                processResult.setResponseMessage("The ServerID registered in this file is different from the ServerID where JEMM is connected. Probably, this file was generated from a different Jellyfin Instance. Please make sure you are using a file exported from the same server/instance to import.");
                break;
            }
        }
                
        return processResult;
    }

    /**
     * Starts the import process for importing metadata from a CSV file into a Jellyfin instance.
     * 
     * This method performs the following steps:
     * 1. Transforms each line in the `linesChanged` array into an array of fields.
     * 2. Gets the ID and ParentID, then identifies if the line refers to a Folder or an Item.
     * 3. If the line refers to a Folder, updates the folder in the main object with values changed from the file.
     * 4. If the line refers to an Item, gets the most recent data and updates the main instance object with values changed from the file.
     * 
     * @return A JellyfinResponseStandard object containing the result of the import process. If the process is successful, the response code and message indicate success. If any changes were not applied, the response code and message indicate the error.
     * @since 1.2.0
     * @version 1.0
     * @author CesarBianchi
     */
    public JellyfinResponseStandard startImport() {
        JellyfinResponseStandard processResult = new JellyfinResponseStandard();
        ArrayList<String> fieldsinLine = new ArrayList();
        boolean isFolder = false;
        String itemID = new String();
        String ParentID = new String();
        boolean lUpdated = true;
         
        for (int nI = 0; nI < this.linesChanged.size(); nI++){
    
            //1st: Transform the line into an array of fields
            fieldsinLine = this.myTokenizer(this.linesChanged.get(nI),null);
    
            //2nd: Gets the ID, ParentID and then identifies if the line refers to a Folder or an Item.
            itemID = fieldsinLine.get(getDefaultIndexNumber("Id"));
            ParentID = fieldsinLine.get(getDefaultIndexNumber("ParentId"));
            isFolder = fieldsinLine.get(getDefaultIndexNumber("Type")).toUpperCase().contains("FOLDER");
    
            if (isFolder){
                if (this.refreshFolder(itemID)){
                    //Update the folder in the main object with values changed from the file
                    this.updateFolderInMainObj(itemID,fieldsinLine);                     
                } else {
                    lUpdated = false;
                }
            } else {
                //Before updating an item, get its most recent data and update the main instance object
                if (this.refreshItensOfFolder(ParentID)) {                 
                   //Update the item in the main object with values changed from the file
                   this.updateItemInMainObj(itemID,ParentID,fieldsinLine);                    
                } else {
                   lUpdated = false;
                }
            }
        }
        
        if (lUpdated){
            processResult.setIsSuccess(true);
            processResult.setResponseCode("");
            processResult.setResponseMessage("Import Process done!");
        } else {
            processResult.setIsSuccess(false);
            processResult.setResponseCode("CSV_IMP_011");
            processResult.setResponseMessage("Import Process done. One or more changes were not applied");
        }
         
        this.setProcessFinalResult(processResult);
        return processResult;
    }
    
        /**
     * Compares the old and new values of a property and registers the difference if they are not equal.
     * 
     * @param oldValue The original value of the property.
     * @param newValue The new value of the property.
     * @param property The name of the property being compared.
     * @param lineNumber The line number where the difference was found.
     * @param lChangedBefore Indicates if a change was detected before this comparison.
     * @return true if the values are different, false otherwise.
     * @since 1.2.0
     * @author CesarBianchi
     */
    public boolean compareValues(String oldValue, String newValue, String property, String lineNumber, boolean lChangedBefore){
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
    
    /**
     * Refreshes the items of a folder based on the parent ID.
     * 
     * This method performs the following steps:
     * 1. Gets the index related to the ParentID.
     * 2. Requests metadata for the selected folder.
     * 3. Adds folder metadata attributes to the main instance object.
     * 4. Requests folder content items.
     * 5. Adds folder content items to the main instance object.
     * 
     * @param cParentID The parent ID of the folder.
     * @return true if the items were successfully refreshed, false otherwise.
     * @since 1.2.0
     * @author CesarBianchi
     */
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

    /**
     * Refreshes the metadata of a folder based on the item ID.
     * 
     * This method performs the following steps:
     * 1. Gets the index of the folder-item in the main object.
     * 2. Requests metadata for the selected folder.
     * 3. Adds folder metadata attributes to the main instance object.
     * 
     * @param itemID The ID of the folder to refresh.
     * @return true if the folder metadata was successfully refreshed, false otherwise.
     * @since 1.2.0
     * @author CesarBianchi
     */
    private boolean refreshFolder(String itemID) {
        boolean lSuccess = false;
        int nIndex = 0;
        boolean lFound = false;
        
        //1st: Get the index of the folder-item in main object
        for (int nI = 0; nI < instanceData.getFolders().getItems().size(); nI++ ){
    
            if (instanceData.getFolders().getItems().get(nI).getId().equals(itemID)){
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
                folderMetadadta = connectAPI.getFolderMetadata(itemID);
    
                //2.2 - Add folder metadata atributes to main instance object
                instanceData.getFolders().getItems().get(nIndex).setMetadata(folderMetadadta);
    
                lSuccess = true; 
                
            } catch (IOException | ParseException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lSuccess = false;
        }
        
        return lSuccess;
    }
    
        /**
     * Updates an item in the main object based on the item ID and parent ID.
     * 
     * This method performs the following steps:
     * 1. Searches for the item in the main object.
     * 2. Updates the item's metadata with the values from the CSV file.
     * 3. Updates the item on the Jellyfin instance by making an API call.
     * 
     * @param itemID The ID of the item to update.
     * @param parentID The ID of the parent item.
     * @param fieldsInLine The list of fields from the CSV file line.
     * @since 1.2.0
     * @author CesarBianchi
     */
    private void updateItemInMainObj(String itemID, String parentID, ArrayList<String> fieldsInLine) {
        JellyfinItem item = new JellyfinItem();
        
        //1st: Search the item in MainObject
        for (int nI = 0; nI < instanceData.getFolders().getItems().size(); nI++ ){
    
            if (instanceData.getFolders().getItems().get(nI).getId().equals(parentID)){
                
                for (int nJ = 0; nJ < instanceData.getFolders().getItems().get(nI).getFolderContent().getItems().size(); nJ++) {
                    item = instanceData.getFolders().getItems().get(nI).getFolderContent().getItems().get(nJ);
                    
                    if (item.getId().equals(itemID)){
                        
                        item.setName(fieldsInLine.get(getDefaultIndexNumber("Name")));
                        item.getItemMetadata().setName(fieldsInLine.get(getDefaultIndexNumber("Name")));
                        
                        item.getItemMetadata().setOriginalTitle(fieldsInLine.get(getDefaultIndexNumber("OriginalTitle")));
                        item.getItemMetadata().setSortName(fieldsInLine.get(getDefaultIndexNumber("SortName")));
                        item.getItemMetadata().setForcedSortName(fieldsInLine.get(getDefaultIndexNumber("ForcedSortName")));
                        
                        item.mySetProductionYear(fieldsInLine.get(getDefaultIndexNumber("ProductionYear")));
                        item.getItemMetadata().mySetProductionYear(fieldsInLine.get(getDefaultIndexNumber("ProductionYear")));
                        
                        item.mySetCommunityRating(fieldsInLine.get(getDefaultIndexNumber("CommunityRating")));
                        item.getItemMetadata().mySetCommunityRating(fieldsInLine.get(getDefaultIndexNumber("CommunityRating")));
                                                
                        item.mySetCriticRating(fieldsInLine.get(getDefaultIndexNumber("CriticRating")));
                        item.getItemMetadata().mySetCriticRating(fieldsInLine.get(getDefaultIndexNumber("CriticRating")));
                        
                        item.setOfficialRating(fieldsInLine.get(getDefaultIndexNumber("OfficialRating")));
                        item.getItemMetadata().setOfficialRating(fieldsInLine.get(getDefaultIndexNumber("OfficialRating")));
                        
                        item.mySetPremiereDate(fieldsInLine.get(getDefaultIndexNumber("PremiereDate")));
                        item.getItemMetadata().mySetPremiereDate(fieldsInLine.get(getDefaultIndexNumber("PremiereDate")));
                        
                        item.getItemMetadata().mySetDateCreated(fieldsInLine.get(getDefaultIndexNumber("DateCreated")));
                        
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
                        
                        item.getItemMetadata().setOverview(fieldsInLine.get(getDefaultIndexNumber("Overview")).replace(" || ", "\n"));
                        
                        //2nd: Finally, update the item on Jellyfin Instance. (Make API Call)
                        try {
                            instanceData.getFolders().getItems().get(nI).getFolderContent().getItems().set(nJ, item);
                            
                            connectAPI.postUpdate(parentID, itemID, instanceData, JellyfinParameters.JUST_ITEMS);
                            
                        } catch (IOException ex) {
                            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                
            }
        }
    }

    /**
     * Updates a folder in the main object based on the item ID.
     * 
     * This method performs the following steps:
     * 1. Searches for the folder in the main object.
     * 2. Updates the folder's metadata with the values from the CSV file.
     * 3. Updates the folder on the Jellyfin instance by making an API call.
     * 
     * @param itemID The ID of the folder to update.
     * @param fieldsInLine The list of fields from the CSV file line.
     * @since 1.2.0
     * @author CesarBianchi
     */
    private void updateFolderInMainObj(String itemID, ArrayList<String> fieldsInLine) {
        JellyfinFolder folderUpdated = new JellyfinFolder();
        
        //1st: Search the item in MainObject
        for (int nI = 0; nI < instanceData.getFolders().getItems().size(); nI++ ){
            
            if (instanceData.getFolders().getItems().get(nI).getId().equals(itemID)){
                
                folderUpdated = instanceData.getFolders().getItems().get(nI);
                
                folderUpdated.setName(fieldsInLine.get(getDefaultIndexNumber("Name")));
                folderUpdated.getMetadata().setName(fieldsInLine.get(getDefaultIndexNumber("Name")));
    
                //TO DO TO DO
                //folderUpdated.getMetadata().setOriginalTitle(fieldsInLine.get(getDefaultIndexNumber("OriginalTitle")));
                
                folderUpdated.getMetadata().setSortName(fieldsInLine.get(getDefaultIndexNumber("SortName")));
                folderUpdated.getMetadata().setForcedSortName(fieldsInLine.get(getDefaultIndexNumber("ForcedSortName")));
                folderUpdated.mySetProductionYear(fieldsInLine.get(getDefaultIndexNumber("ProductionYear")));
                folderUpdated.getMetadata().mySetProductionYear(fieldsInLine.get(getDefaultIndexNumber("ProductionYear")));
                folderUpdated.mySetCommunityRating(fieldsInLine.get(getDefaultIndexNumber("CommunityRating")));
                folderUpdated.getMetadata().mySetCommunityRating(fieldsInLine.get(getDefaultIndexNumber("CommunityRating")));
                folderUpdated.mySetCriticRating(fieldsInLine.get(getDefaultIndexNumber("CriticRating")));
                
                //TO DO TO DO
                //folderUpdated.getMetadata().mySetCriticRating(fieldsInLine.get(getDefaultIndexNumber("CriticRating")));
    
                folderUpdated.setOfficialRating(fieldsInLine.get(getDefaultIndexNumber("OfficialRating")));
                folderUpdated.getMetadata().setOfficialRating(fieldsInLine.get(getDefaultIndexNumber("OfficialRating")));
                folderUpdated.mySetPremiereDate(fieldsInLine.get(getDefaultIndexNumber("PremiereDate")));
                folderUpdated.getMetadata().mySetPremiereDate(fieldsInLine.get(getDefaultIndexNumber("PremiereDate")));
                folderUpdated.getMetadata().mySetDateCreated(fieldsInLine.get(getDefaultIndexNumber("DateCreated")));
    
                ArrayList<String> lGenres = new ArrayList();
                lGenres = this.myTokenizer(fieldsInLine.get(getDefaultIndexNumber("Genres")), " ,");
                //TO DO TO DO
                //folderUpdated.getMetadata().setGenreItems(lGenres);
                
                folderUpdated.getMetadata().setPreferredMetadataLanguage(fieldsInLine.get(getDefaultIndexNumber("PreferredMetadataLanguage")));                        
                folderUpdated.getMetadata().setPreferredMetadataCountryCode(fieldsInLine.get(getDefaultIndexNumber("PreferredMetadataCountryCode")));
    
                //TO DO TO DO
                //item.getItemMetadata().setStudios(fieldsInLine.get(getDefaultIndexNumber("Studios")));
    
                ArrayList<String> lTags = new ArrayList();
                lTags = this.myTokenizer(fieldsInLine.get(getDefaultIndexNumber("Tags")), " ,");                        
                folderUpdated.getMetadata().setTags(lTags);
    
                folderUpdated.getMetadata().setOverview(fieldsInLine.get(getDefaultIndexNumber("Overview")).replace(" || ", "\n"));
    
                //2nd: Finally, update the folder on Jellyfin Instance. (Make API Call)
                try {                            
                    instanceData.getFolders().getItems().set(nI, folderUpdated);
                    connectAPI.postUpdate(itemID, "", instanceData, JellyfinParameters.FOLDERS_AND_SUBFOLDERS);
    
                } catch (IOException ex) {
                    Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(JellyfinImportMetadata.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
    
    }

    public JellyfinResponseStandard getProcessFinalResult() {
        return processFinalResult;
    }

    public void setProcessFinalResult(JellyfinResponseStandard processFinalResult) {
        this.processFinalResult = processFinalResult;
    }

}
