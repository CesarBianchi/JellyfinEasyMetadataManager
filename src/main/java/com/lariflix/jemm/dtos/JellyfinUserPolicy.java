/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinUserPolicy {
    @JsonProperty("IsAdministrator") 
    public boolean isAdministrator;
    @JsonProperty("IsHidden") 
    public boolean isHidden;
    @JsonProperty("IsDisabled") 
    public boolean isDisabled;
    @JsonProperty("BlockedTags") 
    public ArrayList<Object> blockedTags;
    @JsonProperty("EnableUserPreferenceAccess") 
    public boolean enableUserPreferenceAccess;
    @JsonProperty("AccessSchedules") 
    public ArrayList<Object> accessSchedules;
    @JsonProperty("BlockUnratedItems") 
    public ArrayList<Object> blockUnratedItems;
    @JsonProperty("EnableRemoteControlOfOtherUsers") 
    public boolean enableRemoteControlOfOtherUsers;
    @JsonProperty("EnableSharedDeviceControl") 
    public boolean enableSharedDeviceControl;
    @JsonProperty("EnableRemoteAccess") 
    public boolean enableRemoteAccess;
    @JsonProperty("EnableLiveTvManagement") 
    public boolean enableLiveTvManagement;
    @JsonProperty("EnableLiveTvAccess") 
    public boolean enableLiveTvAccess;
    @JsonProperty("EnableMediaPlayback") 
    public boolean enableMediaPlayback;
    @JsonProperty("EnableAudioPlaybackTranscoding") 
    public boolean enableAudioPlaybackTranscoding;
    @JsonProperty("EnableVideoPlaybackTranscoding") 
    public boolean enableVideoPlaybackTranscoding;
    @JsonProperty("EnablePlaybackRemuxing") 
    public boolean enablePlaybackRemuxing;
    @JsonProperty("ForceRemoteSourceTranscoding") 
    public boolean forceRemoteSourceTranscoding;
    @JsonProperty("EnableContentDeletion") 
    public boolean enableContentDeletion;
    @JsonProperty("EnableContentDeletionFromFolders") 
    public ArrayList<Object> enableContentDeletionFromFolders;
    @JsonProperty("EnableContentDownloading") 
    public boolean enableContentDownloading;
    @JsonProperty("EnableSyncTranscoding") 
    public boolean enableSyncTranscoding;
    @JsonProperty("EnableMediaConversion") 
    public boolean enableMediaConversion;
    @JsonProperty("EnabledDevices") 
    public ArrayList<Object> enabledDevices;
    @JsonProperty("EnableAllDevices") 
    public boolean enableAllDevices;
    @JsonProperty("EnabledChannels") 
    public ArrayList<Object> enabledChannels;
    @JsonProperty("EnableAllChannels") 
    public boolean enableAllChannels;
    @JsonProperty("EnabledFolders") 
    public ArrayList<Object> enabledFolders;
    @JsonProperty("EnableAllFolders") 
    public boolean enableAllFolders;
    @JsonProperty("InvalidLoginAttemptCount") 
    public int invalidLoginAttemptCount;
    @JsonProperty("LoginAttemptsBeforeLockout") 
    public int loginAttemptsBeforeLockout;
    @JsonProperty("MaxActiveSessions") 
    public int maxActiveSessions;
    @JsonProperty("EnablePublicSharing") 
    public boolean enablePublicSharing;
    @JsonProperty("BlockedMediaFolders") 
    public ArrayList<Object> blockedMediaFolders;
    @JsonProperty("BlockedChannels") 
    public ArrayList<Object> blockedChannels;
    @JsonProperty("RemoteClientBitrateLimit") 
    public int remoteClientBitrateLimit;
    @JsonProperty("AuthenticationProviderId") 
    public String authenticationProviderId;
    @JsonProperty("PasswordResetProviderId") 
    public String passwordResetProviderId;
    @JsonProperty("SyncPlayAccess") 
    public String syncPlayAccess;

    public JellyfinUserPolicy() {
    }

    public boolean isIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    public boolean isIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public boolean isIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public ArrayList<Object> getBlockedTags() {
        return blockedTags;
    }

    public void setBlockedTags(ArrayList<Object> blockedTags) {
        this.blockedTags = blockedTags;
    }

    public boolean isEnableUserPreferenceAccess() {
        return enableUserPreferenceAccess;
    }

    public void setEnableUserPreferenceAccess(boolean enableUserPreferenceAccess) {
        this.enableUserPreferenceAccess = enableUserPreferenceAccess;
    }

    public ArrayList<Object> getAccessSchedules() {
        return accessSchedules;
    }

    public void setAccessSchedules(ArrayList<Object> accessSchedules) {
        this.accessSchedules = accessSchedules;
    }

    public ArrayList<Object> getBlockUnratedItems() {
        return blockUnratedItems;
    }

    public void setBlockUnratedItems(ArrayList<Object> blockUnratedItems) {
        this.blockUnratedItems = blockUnratedItems;
    }

    public boolean isEnableRemoteControlOfOtherUsers() {
        return enableRemoteControlOfOtherUsers;
    }

    public void setEnableRemoteControlOfOtherUsers(boolean enableRemoteControlOfOtherUsers) {
        this.enableRemoteControlOfOtherUsers = enableRemoteControlOfOtherUsers;
    }

    public boolean isEnableSharedDeviceControl() {
        return enableSharedDeviceControl;
    }

    public void setEnableSharedDeviceControl(boolean enableSharedDeviceControl) {
        this.enableSharedDeviceControl = enableSharedDeviceControl;
    }

    public boolean isEnableRemoteAccess() {
        return enableRemoteAccess;
    }

    public void setEnableRemoteAccess(boolean enableRemoteAccess) {
        this.enableRemoteAccess = enableRemoteAccess;
    }

    public boolean isEnableLiveTvManagement() {
        return enableLiveTvManagement;
    }

    public void setEnableLiveTvManagement(boolean enableLiveTvManagement) {
        this.enableLiveTvManagement = enableLiveTvManagement;
    }

    public boolean isEnableLiveTvAccess() {
        return enableLiveTvAccess;
    }

    public void setEnableLiveTvAccess(boolean enableLiveTvAccess) {
        this.enableLiveTvAccess = enableLiveTvAccess;
    }

    public boolean isEnableMediaPlayback() {
        return enableMediaPlayback;
    }

    public void setEnableMediaPlayback(boolean enableMediaPlayback) {
        this.enableMediaPlayback = enableMediaPlayback;
    }

    public boolean isEnableAudioPlaybackTranscoding() {
        return enableAudioPlaybackTranscoding;
    }

    public void setEnableAudioPlaybackTranscoding(boolean enableAudioPlaybackTranscoding) {
        this.enableAudioPlaybackTranscoding = enableAudioPlaybackTranscoding;
    }

    public boolean isEnableVideoPlaybackTranscoding() {
        return enableVideoPlaybackTranscoding;
    }

    public void setEnableVideoPlaybackTranscoding(boolean enableVideoPlaybackTranscoding) {
        this.enableVideoPlaybackTranscoding = enableVideoPlaybackTranscoding;
    }

    public boolean isEnablePlaybackRemuxing() {
        return enablePlaybackRemuxing;
    }

    public void setEnablePlaybackRemuxing(boolean enablePlaybackRemuxing) {
        this.enablePlaybackRemuxing = enablePlaybackRemuxing;
    }

    public boolean isForceRemoteSourceTranscoding() {
        return forceRemoteSourceTranscoding;
    }

    public void setForceRemoteSourceTranscoding(boolean forceRemoteSourceTranscoding) {
        this.forceRemoteSourceTranscoding = forceRemoteSourceTranscoding;
    }

    public boolean isEnableContentDeletion() {
        return enableContentDeletion;
    }

    public void setEnableContentDeletion(boolean enableContentDeletion) {
        this.enableContentDeletion = enableContentDeletion;
    }

    public ArrayList<Object> getEnableContentDeletionFromFolders() {
        return enableContentDeletionFromFolders;
    }

    public void setEnableContentDeletionFromFolders(ArrayList<Object> enableContentDeletionFromFolders) {
        this.enableContentDeletionFromFolders = enableContentDeletionFromFolders;
    }

    public boolean isEnableContentDownloading() {
        return enableContentDownloading;
    }

    public void setEnableContentDownloading(boolean enableContentDownloading) {
        this.enableContentDownloading = enableContentDownloading;
    }

    public boolean isEnableSyncTranscoding() {
        return enableSyncTranscoding;
    }

    public void setEnableSyncTranscoding(boolean enableSyncTranscoding) {
        this.enableSyncTranscoding = enableSyncTranscoding;
    }

    public boolean isEnableMediaConversion() {
        return enableMediaConversion;
    }

    public void setEnableMediaConversion(boolean enableMediaConversion) {
        this.enableMediaConversion = enableMediaConversion;
    }

    public ArrayList<Object> getEnabledDevices() {
        return enabledDevices;
    }

    public void setEnabledDevices(ArrayList<Object> enabledDevices) {
        this.enabledDevices = enabledDevices;
    }

    public boolean isEnableAllDevices() {
        return enableAllDevices;
    }

    public void setEnableAllDevices(boolean enableAllDevices) {
        this.enableAllDevices = enableAllDevices;
    }

    public ArrayList<Object> getEnabledChannels() {
        return enabledChannels;
    }

    public void setEnabledChannels(ArrayList<Object> enabledChannels) {
        this.enabledChannels = enabledChannels;
    }

    public boolean isEnableAllChannels() {
        return enableAllChannels;
    }

    public void setEnableAllChannels(boolean enableAllChannels) {
        this.enableAllChannels = enableAllChannels;
    }

    public ArrayList<Object> getEnabledFolders() {
        return enabledFolders;
    }

    public void setEnabledFolders(ArrayList<Object> enabledFolders) {
        this.enabledFolders = enabledFolders;
    }

    public boolean isEnableAllFolders() {
        return enableAllFolders;
    }

    public void setEnableAllFolders(boolean enableAllFolders) {
        this.enableAllFolders = enableAllFolders;
    }

    public int getInvalidLoginAttemptCount() {
        return invalidLoginAttemptCount;
    }

    public void setInvalidLoginAttemptCount(int invalidLoginAttemptCount) {
        this.invalidLoginAttemptCount = invalidLoginAttemptCount;
    }

    public int getLoginAttemptsBeforeLockout() {
        return loginAttemptsBeforeLockout;
    }

    public void setLoginAttemptsBeforeLockout(int loginAttemptsBeforeLockout) {
        this.loginAttemptsBeforeLockout = loginAttemptsBeforeLockout;
    }

    public int getMaxActiveSessions() {
        return maxActiveSessions;
    }

    public void setMaxActiveSessions(int maxActiveSessions) {
        this.maxActiveSessions = maxActiveSessions;
    }

    public boolean isEnablePublicSharing() {
        return enablePublicSharing;
    }

    public void setEnablePublicSharing(boolean enablePublicSharing) {
        this.enablePublicSharing = enablePublicSharing;
    }

    public ArrayList<Object> getBlockedMediaFolders() {
        return blockedMediaFolders;
    }

    public void setBlockedMediaFolders(ArrayList<Object> blockedMediaFolders) {
        this.blockedMediaFolders = blockedMediaFolders;
    }

    public ArrayList<Object> getBlockedChannels() {
        return blockedChannels;
    }

    public void setBlockedChannels(ArrayList<Object> blockedChannels) {
        this.blockedChannels = blockedChannels;
    }

    public int getRemoteClientBitrateLimit() {
        return remoteClientBitrateLimit;
    }

    public void setRemoteClientBitrateLimit(int remoteClientBitrateLimit) {
        this.remoteClientBitrateLimit = remoteClientBitrateLimit;
    }

    public String getAuthenticationProviderId() {
        return authenticationProviderId;
    }

    public void setAuthenticationProviderId(String authenticationProviderId) {
        this.authenticationProviderId = authenticationProviderId;
    }

    public String getPasswordResetProviderId() {
        return passwordResetProviderId;
    }

    public void setPasswordResetProviderId(String passwordResetProviderId) {
        this.passwordResetProviderId = passwordResetProviderId;
    }

    public String getSyncPlayAccess() {
        return syncPlayAccess;
    }

    public void setSyncPlayAccess(String syncPlayAccess) {
        this.syncPlayAccess = syncPlayAccess;
    }
    
    
    
}
