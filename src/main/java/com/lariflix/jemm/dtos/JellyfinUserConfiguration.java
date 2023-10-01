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

    public JellyfinUserConfiguration() {
    }

    public boolean isPlayDefaultAudioTrack() {
        return playDefaultAudioTrack;
    }

    public void setPlayDefaultAudioTrack(boolean playDefaultAudioTrack) {
        this.playDefaultAudioTrack = playDefaultAudioTrack;
    }

    public String getSubtitleLanguagePreference() {
        return subtitleLanguagePreference;
    }

    public void setSubtitleLanguagePreference(String subtitleLanguagePreference) {
        this.subtitleLanguagePreference = subtitleLanguagePreference;
    }

    public boolean isDisplayMissingEpisodes() {
        return displayMissingEpisodes;
    }

    public void setDisplayMissingEpisodes(boolean displayMissingEpisodes) {
        this.displayMissingEpisodes = displayMissingEpisodes;
    }


    public String getSubtitleMode() {
        return subtitleMode;
    }

    public void setSubtitleMode(String subtitleMode) {
        this.subtitleMode = subtitleMode;
    }

    public boolean isDisplayCollectionsView() {
        return displayCollectionsView;
    }

    public void setDisplayCollectionsView(boolean displayCollectionsView) {
        this.displayCollectionsView = displayCollectionsView;
    }

    public boolean isEnableLocalPassword() {
        return enableLocalPassword;
    }

    public void setEnableLocalPassword(boolean enableLocalPassword) {
        this.enableLocalPassword = enableLocalPassword;
    }

    public ArrayList<Object> getGroupedFolders() {
        return groupedFolders;
    }

    public void setGroupedFolders(ArrayList<Object> groupedFolders) {
        this.groupedFolders = groupedFolders;
    }

    public ArrayList<Object> getOrderedViews() {
        return orderedViews;
    }

    public void setOrderedViews(ArrayList<Object> orderedViews) {
        this.orderedViews = orderedViews;
    }

    public ArrayList<Object> getLatestItemsExcludes() {
        return latestItemsExcludes;
    }

    public void setLatestItemsExcludes(ArrayList<Object> latestItemsExcludes) {
        this.latestItemsExcludes = latestItemsExcludes;
    }

    public ArrayList<Object> getMyMediaExcludes() {
        return myMediaExcludes;
    }

    public void setMyMediaExcludes(ArrayList<Object> myMediaExcludes) {
        this.myMediaExcludes = myMediaExcludes;
    }

    public boolean isHidePlayedInLatest() {
        return hidePlayedInLatest;
    }

    public void setHidePlayedInLatest(boolean hidePlayedInLatest) {
        this.hidePlayedInLatest = hidePlayedInLatest;
    }

    public boolean isRememberAudioSelections() {
        return rememberAudioSelections;
    }

    public void setRememberAudioSelections(boolean rememberAudioSelections) {
        this.rememberAudioSelections = rememberAudioSelections;
    }

    public boolean isRememberSubtitleSelections() {
        return rememberSubtitleSelections;
    }

    public void setRememberSubtitleSelections(boolean rememberSubtitleSelections) {
        this.rememberSubtitleSelections = rememberSubtitleSelections;
    }

    public boolean isEnableNextEpisodeAutoPlay() {
        return enableNextEpisodeAutoPlay;
    }

    public void setEnableNextEpisodeAutoPlay(boolean enableNextEpisodeAutoPlay) {
        this.enableNextEpisodeAutoPlay = enableNextEpisodeAutoPlay;
    }

    public String isAudioLanguagePreference() {
        return AudioLanguagePreference;
    }

    public void setAudioLanguagePreference(String AudioLanguagePreference) {
        this.AudioLanguagePreference = AudioLanguagePreference;
    }
    
    
}
