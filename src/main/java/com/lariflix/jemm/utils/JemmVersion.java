
package com.lariflix.jemm.utils;

/**
 * Represents the version of Jemm (Jellyfin Easy Metadata Manager).
 * This class is used to manage the version information of the application.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 
 */
public class JemmVersion {
    /**
     * The version of the application.
     */
    private String version = new String();

    /**
     * Retrieves the current version of Jemm.
     * This method is used to get the version information of the application.
     * 
     * @return The version of Jemm.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public String getVersion() {
        this.setVersion("v1.2.4");
        return version;
    }

    /**
     * Sets the version of the JemmVersion object.
     * This method is used to set the version information of the application.
     * 
     * @param version the version to set
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    private void setVersion(String version) {
        this.version = version;
    }
}
