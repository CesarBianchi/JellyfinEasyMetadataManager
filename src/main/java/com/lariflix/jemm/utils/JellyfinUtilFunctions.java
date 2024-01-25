package com.lariflix.jemm.utils;

import javax.swing.table.DefaultTableModel;


/**
 * Utility class for Jellyfin related functions.
 * This class provides utility methods that can be used across the application.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 * @createdate 2024-02-01
 */
public class JellyfinUtilFunctions {

    /**
     * Default constructor for the JellyfinUtilFunctions class.
     * This constructor is used when creating a new instance of this class without setting any initial values.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     * @createdate 2024-02-01
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
     * @createdate 2024-02-01
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
    
}
