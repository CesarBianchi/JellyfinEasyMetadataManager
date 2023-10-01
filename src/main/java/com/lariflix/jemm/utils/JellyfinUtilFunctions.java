
package com.lariflix.jemm.utils;

import javax.swing.table.DefaultTableModel;
//Test
/**
 *
 * @author cesarbianchi
 */
public class JellyfinUtilFunctions {

    public JellyfinUtilFunctions() {
    }
    
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
