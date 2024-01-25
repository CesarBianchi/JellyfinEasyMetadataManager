
package com.lariflix.jemm.utils;

/**
 * Represents the version of Jemm (Jellyfin Easy Metadata Manager).
 * @author Cesar Bianchi
 */
public class JemmVersion {
    private String version = new String();

    /**
     * Retrieves the current version of Jemm.
     * 
     * @return The version of Jemm.
     */
    public String getVersion() {
        this.setVersion("v1.0.2 - (beta)");
        return version;
    }


    /**
     * Sets the version of the JemmVersion object.
     * @param version the version to set
     */
    private void setVersion(String version) {
        this.version = version;
    }
}
