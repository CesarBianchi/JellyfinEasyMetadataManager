package com.lariflix.jemm.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;


/**
 * Utility class for Jellyfin related functions.
 * This class provides utility methods that can be used across the application.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinUtilFunctions {

    /**
     * Default constructor for the JellyfinUtilFunctions class.
     * This constructor is used when creating a new instance of this class without setting any initial values.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     */
    public JellyfinUtilFunctions() {
    }
    

    /**
     * Erases all rows from the given DefaultTableModel.
     * This method is used to clear a table model.
     * 
     * @param model The DefaultTableModel to be cleared.
     * @return The cleared DefaultTableModel.
     * @author Cesar Bianchi
     * @since 1.0
     */
    public DefaultTableModel eraseModel(DefaultTableModel model) {
        DefaultTableModel modelRet = model;
        
        for (int nI = 0; nI <= modelRet.getRowCount(); nI++) {
            if (modelRet.getRowCount() > 0){
                modelRet.removeRow(nI);
                nI = -1;
            }
        }
        
        return modelRet;
    }
    
    /**
     * Extracts a resource-file from a JAR and saves it to a temporary dir location.
     *
     * @param originName The name of the file to be extracted from the JAR file. This should include the path to the file inside the JAR file.
     * @param destName The name of the file to be saved. This should include the path to the location where the file should be saved.
     * @return A boolean value indicating whether the file was successfully extracted and saved. Returns true if the operation was successful, and false otherwise.
     *
     * @throws IOException If there is an error reading the file from the JAR file or writing the file to the specified location.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public boolean extractFileFromJar(String originName, String destName){
        boolean isSuccess = false;
        String destFullPathName = System.getProperty("java.io.tmpdir").concat(destName);
        
        
        InputStream initialStream = getClass().getResourceAsStream(originName);
        File file = new File(destFullPathName);
        try {
            FileUtils.copyInputStreamToFile(initialStream, file);
            isSuccess = true;
        } catch (IOException ex) {
            Logger.getLogger(JellyfinUtilFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        return isSuccess;
    }
    
    /**
     * Retrieves the local path for the JRXML files.
     *
     * This method returns a hardcoded string representing the local path for the JRXML files. 
     * This path is used for debugging purposes.
     *
     * @return A string representing the local path for the JRXML files.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public String getJRXMLLocalPath(){
        String localPathforDebug = "/Users/cesarbianchi/JaspersoftWorkspace/JellyfinEasyMetadataManager";
        
        return localPathforDebug;               
    }
    
    /**
     * Retrieves the resource path for the JRXML files.
     *
     * This method returns a hardcoded string representing the resource path for the JRXML files. 
     * This path is used to locate the JRXML files within the application's resources.
     *
     * @return A string representing the resource path for the JRXML files.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public String getJRXMLResourcePath(){
        String resourceReportPath = "/reports/jasperfiles";
        
        return resourceReportPath;                
    }
    
}
