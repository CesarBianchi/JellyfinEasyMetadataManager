package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;


/**
 * This class represents the user policy in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JellyfinUser
 * @see JellyfinUserConfiguration
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

    /**
     * Default constructor for JellyfinUserPolicy.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinUserPolicy() {
    }

    /**
     * Returns whether the user is an administrator.
     *
     * @return True if the user is an administrator, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isIsAdministrator() {
        return isAdministrator;
    }

    /**
     * Sets whether the user is an administrator.
     *
     * @param isAdministrator True to set the user as an administrator, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setIsAdministrator(boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    /**
     * Returns whether the user is hidden.
     *
     * @return True if the user is hidden, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isIsHidden() {
        return isHidden;
    }

    /**
     * Sets whether the user is hidden.
     *
     * @param isHidden True to set the user as hidden, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     * Returns whether the user is disabled.
     *
     * @return True if the user is disabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isIsDisabled() {
        return isDisabled;
    }

    /**
     * Sets whether the user is disabled.
     *
     * @param isDisabled True to set the user as disabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    /**
     * Returns the blocked tags of the user.
     *
     * @return The blocked tags of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getBlockedTags() {
        return blockedTags;
    }

    /**
     * Sets the blocked tags of the user.
     *
     * @param blockedTags The new blocked tags of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setBlockedTags(ArrayList<Object> blockedTags) {
        this.blockedTags = blockedTags;
    }

    /**
     * Returns whether user preference access is enabled.
     *
     * @return True if user preference access is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableUserPreferenceAccess() {
        return enableUserPreferenceAccess;
    }

    /**
     * Sets whether user preference access is enabled.
     *
     * @param enableUserPreferenceAccess True to enable user preference access, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableUserPreferenceAccess(boolean enableUserPreferenceAccess) {
        this.enableUserPreferenceAccess = enableUserPreferenceAccess;
    }

    /**
     * Returns the access schedules of the user.
     *
     * @return The access schedules of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getAccessSchedules() {
        return accessSchedules;
    }

    /**
     * Sets the access schedules of the user.
     *
     * @param accessSchedules The new access schedules of the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setAccessSchedules(ArrayList<Object> accessSchedules) {
        this.accessSchedules = accessSchedules;
    }

    /**
     * Returns the unrated items that are blocked for the user.
     *
     * @return The unrated items that are blocked for the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getBlockUnratedItems() {
        return blockUnratedItems;
    }

    /**
     * Sets the unrated items that are blocked for the user.
     *
     * @param blockUnratedItems The new unrated items that are blocked for the user.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setBlockUnratedItems(ArrayList<Object> blockUnratedItems) {
        this.blockUnratedItems = blockUnratedItems;
    }

    /**
     * Returns whether remote control of other users is enabled.
     *
     * @return True if remote control of other users is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableRemoteControlOfOtherUsers() {
        return enableRemoteControlOfOtherUsers;
    }

    /**
     * Sets whether remote control of other users is enabled.
     *
     * @param enableRemoteControlOfOtherUsers True to enable remote control of other users, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableRemoteControlOfOtherUsers(boolean enableRemoteControlOfOtherUsers) {
        this.enableRemoteControlOfOtherUsers = enableRemoteControlOfOtherUsers;
    }

    /**
     * Returns whether shared device control is enabled.
     *
     * @return True if shared device control is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableSharedDeviceControl() {
        return enableSharedDeviceControl;
    }

    /**
     * Sets whether shared device control is enabled.
     *
     * @param enableSharedDeviceControl True to enable shared device control, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableSharedDeviceControl(boolean enableSharedDeviceControl) {
        this.enableSharedDeviceControl = enableSharedDeviceControl;
    }

    /**
     * Returns whether remote access is enabled.
     *
     * @return True if remote access is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableRemoteAccess() {
        return enableRemoteAccess;
    }

    /**
     * Sets whether remote access is enabled.
     *
     * @param enableRemoteAccess True to enable remote access, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableRemoteAccess(boolean enableRemoteAccess) {
        this.enableRemoteAccess = enableRemoteAccess;
    }

    /**
     * Returns whether Live TV management is enabled.
     *
     * @return True if Live TV management is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableLiveTvManagement() {
        return enableLiveTvManagement;
    }

    /**
     * Sets whether Live TV management is enabled.
     *
     * @param enableLiveTvManagement True to enable Live TV management, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableLiveTvManagement(boolean enableLiveTvManagement) {
        this.enableLiveTvManagement = enableLiveTvManagement;
    }

    /**
     * Returns whether Live TV access is enabled.
     *
     * @return True if Live TV access is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableLiveTvAccess() {
        return enableLiveTvAccess;
    }

    /**
     * Sets whether Live TV access is enabled.
     *
     * @param enableLiveTvAccess True to enable Live TV access, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableLiveTvAccess(boolean enableLiveTvAccess) {
        this.enableLiveTvAccess = enableLiveTvAccess;
    }

    /**
     * Returns whether media playback is enabled.
     *
     * @return True if media playback is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableMediaPlayback() {
        return enableMediaPlayback;
    }

    /**
     * Sets whether media playback is enabled.
     *
     * @param enableMediaPlayback True to enable media playback, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableMediaPlayback(boolean enableMediaPlayback) {
        this.enableMediaPlayback = enableMediaPlayback;
    }

    /**
     * Returns whether audio playback transcoding is enabled.
     *
     * @return True if audio playback transcoding is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableAudioPlaybackTranscoding() {
        return enableAudioPlaybackTranscoding;
    }

    /**
     * Sets whether audio playback transcoding is enabled.
     *
     * @param enableAudioPlaybackTranscoding True to enable audio playback transcoding, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableAudioPlaybackTranscoding(boolean enableAudioPlaybackTranscoding) {
        this.enableAudioPlaybackTranscoding = enableAudioPlaybackTranscoding;
    }

    /**
     * Returns whether video playback transcoding is enabled.
     *
     * @return True if video playback transcoding is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableVideoPlaybackTranscoding() {
        return enableVideoPlaybackTranscoding;
    }

    /**
     * Sets whether video playback transcoding is enabled.
     *
     * @param enableVideoPlaybackTranscoding True to enable video playback transcoding, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableVideoPlaybackTranscoding(boolean enableVideoPlaybackTranscoding) {
        this.enableVideoPlaybackTranscoding = enableVideoPlaybackTranscoding;
    }
    /**
     * Returns whether playback remuxing is enabled.
     *
     * @return True if playback remuxing is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnablePlaybackRemuxing() {
        return enablePlaybackRemuxing;
    }

    /**
     * Sets whether playback remuxing is enabled.
     *
     * @param enablePlaybackRemuxing True to enable playback remuxing, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnablePlaybackRemuxing(boolean enablePlaybackRemuxing) {
        this.enablePlaybackRemuxing = enablePlaybackRemuxing;
    }

    /**
     * Returns whether force remote source transcoding is enabled.
     *
     * @return True if force remote source transcoding is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isForceRemoteSourceTranscoding() {
        return forceRemoteSourceTranscoding;
    }

    /**
     * Sets whether force remote source transcoding is enabled.
     *
     * @param forceRemoteSourceTranscoding True to enable force remote source transcoding, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setForceRemoteSourceTranscoding(boolean forceRemoteSourceTranscoding) {
        this.forceRemoteSourceTranscoding = forceRemoteSourceTranscoding;
    }

    /**
     * Returns whether content deletion is enabled.
     *
     * @return True if content deletion is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableContentDeletion() {
        return enableContentDeletion;
    }

    /**
     * Sets whether content deletion is enabled.
     *
     * @param enableContentDeletion True to enable content deletion, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableContentDeletion(boolean enableContentDeletion) {
        this.enableContentDeletion = enableContentDeletion;
    }

    /**
     * Returns the folders from which content deletion is enabled.
     *
     * @return The folders from which content deletion is enabled.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getEnableContentDeletionFromFolders() {
        return enableContentDeletionFromFolders;
    }

    /**
     * Sets the folders from which content deletion is enabled.
     *
     * @param enableContentDeletionFromFolders The new folders from which content deletion is enabled.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableContentDeletionFromFolders(ArrayList<Object> enableContentDeletionFromFolders) {
        this.enableContentDeletionFromFolders = enableContentDeletionFromFolders;
    }

    /**
     * Returns whether content downloading is enabled.
     *
     * @return True if content downloading is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableContentDownloading() {
        return enableContentDownloading;
    }

    /**
     * Sets whether content downloading is enabled.
     *
     * @param enableContentDownloading True to enable content downloading, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableContentDownloading(boolean enableContentDownloading) {
        this.enableContentDownloading = enableContentDownloading;
    }

    /**
     * Returns whether sync transcoding is enabled.
     *
     * @return True if sync transcoding is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableSyncTranscoding() {
        return enableSyncTranscoding;
    }

    /**
     * Sets whether sync transcoding is enabled.
     *
     * @param enableSyncTranscoding True to enable sync transcoding, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableSyncTranscoding(boolean enableSyncTranscoding) {
        this.enableSyncTranscoding = enableSyncTranscoding;
    }

    /**
     * Returns whether media conversion is enabled.
     *
     * @return True if media conversion is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableMediaConversion() {
        return enableMediaConversion;
    }

    /**
     * Sets whether media conversion is enabled.
     *
     * @param enableMediaConversion True to enable media conversion, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableMediaConversion(boolean enableMediaConversion) {
        this.enableMediaConversion = enableMediaConversion;
    }

    /**
     * Returns the list of enabled devices.
     *
     * @return The list of enabled devices.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getEnabledDevices() {
        return enabledDevices;
    }

    /**
     * Sets the list of enabled devices.
     *
     * @param enabledDevices The new list of enabled devices.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnabledDevices(ArrayList<Object> enabledDevices) {
        this.enabledDevices = enabledDevices;
    }

    /**
     * Returns whether all devices are enabled.
     *
     * @return True if all devices are enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableAllDevices() {
        return enableAllDevices;
    }

    /**
     * Sets whether all devices are enabled.
     *
     * @param enableAllDevices True to enable all devices, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableAllDevices(boolean enableAllDevices) {
        this.enableAllDevices = enableAllDevices;
    }

    /**
     * Returns the list of enabled channels.
     *
     * @return The list of enabled channels.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getEnabledChannels() {
        return enabledChannels;
    }

    /**
     * Sets the list of enabled channels.
     *
     * @param enabledChannels The new list of enabled channels.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnabledChannels(ArrayList<Object> enabledChannels) {
        this.enabledChannels = enabledChannels;
    }

    /**
     * Returns whether all channels are enabled.
     *
     * @return True if all channels are enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableAllChannels() {
        return enableAllChannels;
    }

    /**
     * Sets whether all channels are enabled.
     *
     * @param enableAllChannels True to enable all channels, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableAllChannels(boolean enableAllChannels) {
        this.enableAllChannels = enableAllChannels;
    }

    /**
     * Returns the list of enabled folders.
     *
     * @return The list of enabled folders.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getEnabledFolders() {
        return enabledFolders;
    }

    /**
     * Sets the list of enabled folders.
     *
     * @param enabledFolders The new list of enabled folders.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnabledFolders(ArrayList<Object> enabledFolders) {
        this.enabledFolders = enabledFolders;
    }

    /**
     * Returns whether all folders are enabled.
     *
     * @return True if all folders are enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableAllFolders() {
        return enableAllFolders;
    }

    /**
     * Sets whether all folders are enabled.
     *
     * @param enableAllFolders True to enable all folders, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableAllFolders(boolean enableAllFolders) {
        this.enableAllFolders = enableAllFolders;
    }

    /**
     * Returns the number of invalid login attempts.
     *
     * @return The number of invalid login attempts.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getInvalidLoginAttemptCount() {
        return invalidLoginAttemptCount;
    }

    /**
     * Sets the number of invalid login attempts.
     *
     * @param invalidLoginAttemptCount The new number of invalid login attempts.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setInvalidLoginAttemptCount(int invalidLoginAttemptCount) {
        this.invalidLoginAttemptCount = invalidLoginAttemptCount;
    }

    /**
     * Returns the number of login attempts before lockout.
     *
     * @return The number of login attempts before lockout.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getLoginAttemptsBeforeLockout() {
        return loginAttemptsBeforeLockout;
    }

    /**
     * Sets the number of login attempts before lockout.
     *
     * @param loginAttemptsBeforeLockout The new number of login attempts before lockout.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLoginAttemptsBeforeLockout(int loginAttemptsBeforeLockout) {
        this.loginAttemptsBeforeLockout = loginAttemptsBeforeLockout;
    }

    /**
     * Returns the maximum number of active sessions.
     *
     * @return The maximum number of active sessions.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getMaxActiveSessions() {
        return maxActiveSessions;
    }

    /**
     * Sets the maximum number of active sessions.
     *
     * @param maxActiveSessions The new maximum number of active sessions.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setMaxActiveSessions(int maxActiveSessions) {
        this.maxActiveSessions = maxActiveSessions;
    }
    /**
     * Returns whether public sharing is enabled.
     *
     * @return True if public sharing is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnablePublicSharing() {
        return enablePublicSharing;
    }

    /**
     * Sets whether public sharing is enabled.
     *
     * @param enablePublicSharing True to enable public sharing, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnablePublicSharing(boolean enablePublicSharing) {
        this.enablePublicSharing = enablePublicSharing;
    }

    /**
     * Returns the list of blocked media folders.
     *
     * @return The list of blocked media folders.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getBlockedMediaFolders() {
        return blockedMediaFolders;
    }

    /**
     * Sets the list of blocked media folders.
     *
     * @param blockedMediaFolders The new list of blocked media folders.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setBlockedMediaFolders(ArrayList<Object> blockedMediaFolders) {
        this.blockedMediaFolders = blockedMediaFolders;
    }

    /**
     * Returns the list of blocked channels.
     *
     * @return The list of blocked channels.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getBlockedChannels() {
        return blockedChannels;
    }

    /**
     * Sets the list of blocked channels.
     *
     * @param blockedChannels The new list of blocked channels.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setBlockedChannels(ArrayList<Object> blockedChannels) {
        this.blockedChannels = blockedChannels;
    }

    /**
     * Returns the remote client bitrate limit.
     *
     * @return The remote client bitrate limit.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public int getRemoteClientBitrateLimit() {
        return remoteClientBitrateLimit;
    }
    /**
     * Sets the remote client bitrate limit.
     *
     * @param remoteClientBitrateLimit The new remote client bitrate limit.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setRemoteClientBitrateLimit(int remoteClientBitrateLimit) {
        this.remoteClientBitrateLimit = remoteClientBitrateLimit;
    }

    /**
     * Returns the authentication provider ID.
     *
     * @return The authentication provider ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getAuthenticationProviderId() {
        return authenticationProviderId;
    }

    /**
     * Sets the authentication provider ID.
     *
     * @param authenticationProviderId The new authentication provider ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setAuthenticationProviderId(String authenticationProviderId) {
        this.authenticationProviderId = authenticationProviderId;
    }

    /**
     * Returns the password reset provider ID.
     *
     * @return The password reset provider ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getPasswordResetProviderId() {
        return passwordResetProviderId;
    }

    /**
     * Sets the password reset provider ID.
     *
     * @param passwordResetProviderId The new password reset provider ID.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPasswordResetProviderId(String passwordResetProviderId) {
        this.passwordResetProviderId = passwordResetProviderId;
    }

    /**
     * Returns the sync play access.
     *
     * @return The sync play access.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getSyncPlayAccess() {
        return syncPlayAccess;
    }

    /**
     * Sets the sync play access.
     *
     * @param syncPlayAccess The new sync play access.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setSyncPlayAccess(String syncPlayAccess) {
        this.syncPlayAccess = syncPlayAccess;
    }
    
    
    
}
