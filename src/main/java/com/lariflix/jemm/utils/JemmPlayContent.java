
package com.lariflix.jemm.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Opens Jellyfin media streams or a local HTML playback page using the desktop
 * browser.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see Desktop
 * @see JemmAleatoryName
 */
public class JemmPlayContent {

    /**
     * Creates a playback helper without opening content.
     *
     * @since 1.0
     * @see #playContent()
     */
    public JemmPlayContent() {
    }

    /**
     * Builds and opens the Jellyfin stream URL for the specified item.
     *
     * @param itemID Jellyfin identifier of the media item
     * @param itemType media type; video and audio are supported
     * @param cURL base URL of the Jellyfin server
     * @param apiKey API key used to access the stream
     * @since 1.0
     * @see #openStreamURL(String, String, String, String)
     * @see Desktop
     */
    public JemmPlayContent(String itemID, String itemType, String cURL, String apiKey) {
        this.openStreamURL(itemID, itemType, cURL, apiKey);        
    }
        
    /**
     * Creates a temporary HTML playback page and opens it in the desktop browser.
     *
     * @return {@code true} if the browser was opened; otherwise {@code false}
     * @throws IOException if the playback page cannot be copied to the temporary directory
     * @since 1.0
     * @see #createHTMLPlayFile()
     * @see Desktop
     */
    public boolean playContent() throws IOException{
        boolean finalResult = false;
        
        String playFilePath = this.createHTMLPlayFile();
        /*TO DO TO DO*/
        try {
            File fileToOpen = new File(playFilePath);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(fileToOpen.toURI());
                finalResult = true;
            }
        } catch (IOException e) {
            /*TO DO*/
        }
        return finalResult;
    }
    
    /**
     * Copies the bundled playback HTML resource to a uniquely named temporary file.
     *
     * @return path of the temporary HTML file
     * @throws IOException if copying the resource to the temporary directory fails
     * @since 1.0
     * @see Files#copy(Path, Path, java.nio.file.CopyOption...)
     */
    private String createHTMLPlayFile() throws IOException {
        String tempSODir = System.getProperty("java.io.tmpdir");
        String aleatoryName = new JemmAleatoryName().getAleatoryName(9).concat(".html");
        String fullPath = tempSODir.concat(aleatoryName);
        
        try (InputStream fileExport = JemmPlayContent.class.getResourceAsStream("/pages/basePlayContent.html")) {

            if (fileExport == null) {
                throw new RuntimeException("Recurso não encontrado");
            } else {
                Path destino = Path.of(fullPath);
                Files.copy(fileExport, destino, StandardCopyOption.REPLACE_EXISTING);
            }    
        }
        return fullPath;
    }

    /**
     * Constructs and opens the Jellyfin stream URL for video or audio content.
     * Unsupported media types are skipped; browser errors are logged to standard error.
     *
     * @param itemID Jellyfin identifier of the media item
     * @param itemType media type used to choose the stream endpoint
     * @param cURL base URL of the Jellyfin server
     * @param apiKey API key appended to the stream URL
     * @since 1.0
     * @see Desktop#browse(URI)
     * @see URI
     */
    private void openStreamURL(String itemID, String itemType, String cURL, String apiKey) {
        String baseURL = new String();
        String mediaType = new String();
        
        if (itemType.toUpperCase().trim().equals("VIDEO")){
            mediaType = "Videos";
        } else if (itemType.toUpperCase().trim().equals("AUDIO")) {
            mediaType = "Audio";
        }
        
        
        if (!mediaType.isEmpty()){ 
            baseURL = cURL;
            if ( !baseURL.substring(baseURL.length()-1, baseURL.length()).equals("/") )   {
                baseURL = baseURL.concat("/");
            }
            baseURL = baseURL.concat(mediaType);
            baseURL = baseURL.concat("/".concat(itemID));
            baseURL = baseURL.concat("/stream");
            baseURL = baseURL.concat("?api_key");
            baseURL = baseURL.concat("=".concat(apiKey));
            
            try {
                Desktop.getDesktop().browse(new URI(baseURL));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            System.out.println("Content isn't a Video or Audio. Nothing to do and skipping ...!");
        }
    }
    
}
