
package com.lariflix.jemm.csv;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinExportMetadata {
    private String cDestinationPath = new String();
    
    public JellyfinExportMetadata(){
    }
    
    public JellyfinExportMetadata(String cPath){
        this.setcDestinationPath(cPath);
    }

    public String getcDestinationPath() {
        return cDestinationPath;
    }

    public void setcDestinationPath(String cDestinationPath) {
        this.cDestinationPath = cDestinationPath;
    }

    public boolean finalStatusIsOk() {
        return true;
    }
    
    
    
}
