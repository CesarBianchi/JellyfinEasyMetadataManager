package com.lariflix.jemm.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;


/**
 * This class represents the configuration of a user in Jellyfin.
 *
 * @author Cesar Bianchi
 * @since 1.0
 */
public class JellyfinUserConfiguration {
    @JsonProperty("AudioLanguagePreference") 
    public String AudioLanguagePreference;
    @JsonProperty("PlayDefaultAudioTrack") 
    public boolean playDefaultAudioTrack;
    @JsonProperty("SubtitleLanguagePreference") 
    public String subtitleLanguagePreference;
    @JsonProperty("DisplayMissingEpisodes") 
    public boolean displayMissingEpisodes;
    @JsonProperty("GroupedFolders") 
    public ArrayList<Object> groupedFolders;
    @JsonProperty("SubtitleMode") 
    public String subtitleMode;
    @JsonProperty("DisplayCollectionsView") 
    public boolean displayCollectionsView;
    @JsonProperty("EnableLocalPassword") 
    public boolean enableLocalPassword;
    @JsonProperty("OrderedViews") 
    public ArrayList<Object> orderedViews;
    @JsonProperty("LatestItemsExcludes") 
    public ArrayList<Object> latestItemsExcludes;
    @JsonProperty("MyMediaExcludes") 
    public ArrayList<Object> myMediaExcludes;
    @JsonProperty("HidePlayedInLatest") 
    public boolean hidePlayedInLatest;
    @JsonProperty("RememberAudioSelections") 
    public boolean rememberAudioSelections;
    @JsonProperty("RememberSubtitleSelections") 
    public boolean rememberSubtitleSelections;
    @JsonProperty("EnableNextEpisodeAutoPlay") 
    public boolean enableNextEpisodeAutoPlay;

    /**
     * Default constructor for JellyfinUserConfiguration.
     *
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinUserConfiguration() {
    }

    /**
     * Returns whether the default audio track should be played.
     *
     * @return True if the default audio track should be played, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isPlayDefaultAudioTrack() {
        return playDefaultAudioTrack;
    }

    /**
     * Sets whether the default audio track should be played.
     *
     * @param playDefaultAudioTrack True to play the default audio track, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setPlayDefaultAudioTrack(boolean playDefaultAudioTrack) {
        this.playDefaultAudioTrack = playDefaultAudioTrack;
    }

    /**
     * Returns the subtitle language preference.
     *
     * @return The subtitle language preference.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getSubtitleLanguagePreference() {
        return subtitleLanguagePreference;
    }

    /**
     * Sets the subtitle language preference.
     *
     * @param subtitleLanguagePreference The new subtitle language preference.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setSubtitleLanguagePreference(String subtitleLanguagePreference) {
        this.subtitleLanguagePreference = subtitleLanguagePreference;
    }

    /**
     * Returns whether missing episodes should be displayed.
     *
     * @return True if missing episodes should be displayed, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isDisplayMissingEpisodes() {
        return displayMissingEpisodes;
    }

    /**
     * Sets whether missing episodes should be displayed.
     *
     * @param displayMissingEpisodes True to display missing episodes, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setDisplayMissingEpisodes(boolean displayMissingEpisodes) {
        this.displayMissingEpisodes = displayMissingEpisodes;
    }

    /**
     * Returns the subtitle mode.
     *
     * @return The subtitle mode.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String getSubtitleMode() {
        return subtitleMode;
    }

    /**
     * Sets the subtitle mode.
     *
     * @param subtitleMode The new subtitle mode.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setSubtitleMode(String subtitleMode) {
        this.subtitleMode = subtitleMode;
    }

    /**
     * Returns whether the collections view should be displayed.
     *
     * @return True if the collections view should be displayed, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isDisplayCollectionsView() {
        return displayCollectionsView;
    }

    /**
     * Sets whether the collections view should be displayed.
     *
     * @param displayCollectionsView True to display the collections view, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setDisplayCollectionsView(boolean displayCollectionsView) {
        this.displayCollectionsView = displayCollectionsView;
    }

    /**
     * Returns whether the local password is enabled.
     *
     * @return True if the local password is enabled, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableLocalPassword() {
        return enableLocalPassword;
    }

    /**
     * Sets whether the local password is enabled.
     *
     * @param enableLocalPassword True to enable the local password, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableLocalPassword(boolean enableLocalPassword) {
        this.enableLocalPassword = enableLocalPassword;
    }

    /**
     * Returns the grouped folders.
     *
     * @return The grouped folders.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getGroupedFolders() {
        return groupedFolders;
    }

    /**
     * Sets the grouped folders.
     *
     * @param groupedFolders The new grouped folders.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setGroupedFolders(ArrayList<Object> groupedFolders) {
        this.groupedFolders = groupedFolders;
    }

    /**
     * Returns the ordered views.
     *
     * @return The ordered views.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getOrderedViews() {
        return orderedViews;
    }

    /**
     * Sets the ordered views.
     *
     * @param orderedViews The new ordered views.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setOrderedViews(ArrayList<Object> orderedViews) {
        this.orderedViews = orderedViews;
    }

    /**
     * Returns the latest items excludes.
     *
     * @return The latest items excludes.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getLatestItemsExcludes() {
        return latestItemsExcludes;
    }

    /**
     * Sets the latest items excludes.
     *
     * @param latestItemsExcludes The new latest items excludes.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setLatestItemsExcludes(ArrayList<Object> latestItemsExcludes) {
        this.latestItemsExcludes = latestItemsExcludes;
    }

    /**
     * Returns the my media excludes.
     *
     * @return The my media excludes.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public ArrayList<Object> getMyMediaExcludes() {
        return myMediaExcludes;
    }

    /**
     * Sets the my media excludes.
     *
     * @param myMediaExcludes The new my media excludes.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setMyMediaExcludes(ArrayList<Object> myMediaExcludes) {
        this.myMediaExcludes = myMediaExcludes;
    }

    /**
     * Returns whether played items should be hidden in latest.
     *
     * @return True if played items should be hidden in latest, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isHidePlayedInLatest() {
        return hidePlayedInLatest;
    }

    /**
     * Sets whether played items should be hidden in latest.
     *
     * @param hidePlayedInLatest True to hide played items in latest, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setHidePlayedInLatest(boolean hidePlayedInLatest) {
        this.hidePlayedInLatest = hidePlayedInLatest;
    }

    /**
     * Returns whether audio selections should be remembered.
     *
     * @return True if audio selections should be remembered, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isRememberAudioSelections() {
        return rememberAudioSelections;
    }

    /**
     * Sets whether audio selections should be remembered.
     *
     * @param rememberAudioSelections True to remember audio selections, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setRememberAudioSelections(boolean rememberAudioSelections) {
        this.rememberAudioSelections = rememberAudioSelections;
    }

    /**
     * Returns whether subtitle selections should be remembered.
     *
     * @return True if subtitle selections should be remembered, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isRememberSubtitleSelections() {
        return rememberSubtitleSelections;
    }

    /**
     * Sets whether subtitle selections should be remembered.
     *
     * @param rememberSubtitleSelections True to remember subtitle selections, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setRememberSubtitleSelections(boolean rememberSubtitleSelections) {
        this.rememberSubtitleSelections = rememberSubtitleSelections;
    }

    /**
     * Returns whether the next episode should auto play.
     *
     * @return True if the next episode should auto play, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public boolean isEnableNextEpisodeAutoPlay() {
        return enableNextEpisodeAutoPlay;
    }

    /**
     * Sets whether the next episode should auto play.
     *
     * @param enableNextEpisodeAutoPlay True to enable the next episode to auto play, false otherwise.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setEnableNextEpisodeAutoPlay(boolean enableNextEpisodeAutoPlay) {
        this.enableNextEpisodeAutoPlay = enableNextEpisodeAutoPlay;
    }

    /**
     * Returns the audio language preference.
     *
     * @return The audio language preference.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public String isAudioLanguagePreference() {
        return AudioLanguagePreference;
    }

    /**
     * Sets the audio language preference.
     *
     * @param AudioLanguagePreference The new audio language preference.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setAudioLanguagePreference(String AudioLanguagePreference) {
        this.AudioLanguagePreference = AudioLanguagePreference;
    }
    
    
}
