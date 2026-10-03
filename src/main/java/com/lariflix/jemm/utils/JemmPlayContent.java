/*
 * Copyright (C) 2026 cesarbianchi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.lariflix.jemm.utils;

import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author cesarbianchi
 */
public class JemmPlayContent {

    public JemmPlayContent() {
    }

    public JemmPlayContent(String itemID, String itemType, String cURL, String apiKey) {
        this.openStreamURL(itemID, itemType, cURL, apiKey);        
    }
        
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
