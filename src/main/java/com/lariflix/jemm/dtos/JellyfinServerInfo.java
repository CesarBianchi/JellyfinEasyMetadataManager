/*
 * Copyright (C) 2025 cesarbianchi
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
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinServerInfo {
    
    @JsonProperty("OperatingSystemDisplayName") 
    public String operatingSystemDisplayName;
    @JsonProperty("HasPendingRestart") 
    public boolean hasPendingRestart;
    @JsonProperty("IsShuttingDown") 
    public boolean isShuttingDown;
    @JsonProperty("SupportsLibraryMonitor") 
    public boolean supportsLibraryMonitor;
    @JsonProperty("WebSocketPortNumber") 
    public int webSocketPortNumber;
    @JsonProperty("CanSelfRestart") 
    public boolean canSelfRestart;
    @JsonProperty("CanLaunchWebBrowser") 
    public boolean canLaunchWebBrowser;
    @JsonProperty("ProgramDataPath") 
    public String programDataPath;
    @JsonProperty("WebPath") 
    public String webPath;
    @JsonProperty("ItemsByNamePath") 
    public String itemsByNamePath;
    @JsonProperty("CachePath") 
    public String cachePath;
    @JsonProperty("LogPath") 
    public String logPath;
    @JsonProperty("InternalMetadataPath") 
    public String internalMetadataPath;
    @JsonProperty("TranscodingTempPath") 
    public String transcodingTempPath;
    @JsonProperty("HasUpdateAvailable") 
    public boolean hasUpdateAvailable;
    @JsonProperty("EncoderLocation") 
    public String encoderLocation;
    @JsonProperty("SystemArchitecture") 
    public String systemArchitecture;
    @JsonProperty("LocalAddress") 
    public String localAddress;
    @JsonProperty("ServerName") 
    public String serverName;
    @JsonProperty("Version") 
    public String version;
    @JsonProperty("OperatingSystem") 
    public String operatingSystem;
    @JsonProperty("Id") 
    public String id;
    
    public JellyfinServerInfo(){
        
    }

    public String getOperatingSystemDisplayName() {
        return operatingSystemDisplayName;
    }

    public void setOperatingSystemDisplayName(String operatingSystemDisplayName) {
        this.operatingSystemDisplayName = operatingSystemDisplayName;
    }

    public boolean isHasPendingRestart() {
        return hasPendingRestart;
    }

    public void setHasPendingRestart(boolean hasPendingRestart) {
        this.hasPendingRestart = hasPendingRestart;
    }

    public boolean isIsShuttingDown() {
        return isShuttingDown;
    }

    public void setIsShuttingDown(boolean isShuttingDown) {
        this.isShuttingDown = isShuttingDown;
    }

    public boolean isSupportsLibraryMonitor() {
        return supportsLibraryMonitor;
    }

    public void setSupportsLibraryMonitor(boolean supportsLibraryMonitor) {
        this.supportsLibraryMonitor = supportsLibraryMonitor;
    }

    public int getWebSocketPortNumber() {
        return webSocketPortNumber;
    }

    public void setWebSocketPortNumber(int webSocketPortNumber) {
        this.webSocketPortNumber = webSocketPortNumber;
    }

    public boolean isCanSelfRestart() {
        return canSelfRestart;
    }

    public void setCanSelfRestart(boolean canSelfRestart) {
        this.canSelfRestart = canSelfRestart;
    }

    public boolean isCanLaunchWebBrowser() {
        return canLaunchWebBrowser;
    }

    public void setCanLaunchWebBrowser(boolean canLaunchWebBrowser) {
        this.canLaunchWebBrowser = canLaunchWebBrowser;
    }

    public String getProgramDataPath() {
        return programDataPath;
    }

    public void setProgramDataPath(String programDataPath) {
        this.programDataPath = programDataPath;
    }

    public String getWebPath() {
        return webPath;
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }

    public String getItemsByNamePath() {
        return itemsByNamePath;
    }

    public void setItemsByNamePath(String itemsByNamePath) {
        this.itemsByNamePath = itemsByNamePath;
    }

    public String getCachePath() {
        return cachePath;
    }

    public void setCachePath(String cachePath) {
        this.cachePath = cachePath;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getInternalMetadataPath() {
        return internalMetadataPath;
    }

    public void setInternalMetadataPath(String internalMetadataPath) {
        this.internalMetadataPath = internalMetadataPath;
    }

    public String getTranscodingTempPath() {
        return transcodingTempPath;
    }

    public void setTranscodingTempPath(String transcodingTempPath) {
        this.transcodingTempPath = transcodingTempPath;
    }

    public boolean isHasUpdateAvailable() {
        return hasUpdateAvailable;
    }

    public void setHasUpdateAvailable(boolean hasUpdateAvailable) {
        this.hasUpdateAvailable = hasUpdateAvailable;
    }

    public String getEncoderLocation() {
        return encoderLocation;
    }

    public void setEncoderLocation(String encoderLocation) {
        this.encoderLocation = encoderLocation;
    }

    public String getSystemArchitecture() {
        return systemArchitecture;
    }

    public void setSystemArchitecture(String systemArchitecture) {
        this.systemArchitecture = systemArchitecture;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
