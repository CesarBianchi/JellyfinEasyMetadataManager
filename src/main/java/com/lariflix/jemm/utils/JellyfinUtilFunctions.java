package com.lariflix.jemm.utils;

import javax.swing.table.DefaultTableModel;

/**
 * This class provides utility functions for Jemm.
* @author Cesar Bianchi
 */
public class JellyfinUtilFunctions {

    /**
     * Constructs a new JellyfinUtilFunctions object.
     */
    public JellyfinUtilFunctions() {
    }
    
    /**
     * Removes all rows from the given DefaultTableModel.
     * 
     * @param model The DefaultTableModel to be cleared.
     * @return The cleared DefaultTableModel.
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
