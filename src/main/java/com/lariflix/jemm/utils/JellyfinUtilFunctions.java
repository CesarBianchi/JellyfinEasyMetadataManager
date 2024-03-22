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
    
    
}
