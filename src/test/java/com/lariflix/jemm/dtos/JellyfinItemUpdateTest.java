package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class JellyfinItemUpdateTest {

    @Test
    public void testJellyfinItemUpdate() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();

        String id = "TestID";
        itemUpdate.setId(id);
        assertEquals(id, itemUpdate.getId());
    }

    @Test
    public void testSetName() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String name = "TestName";
        itemUpdate.setName(name);
        assertEquals(name, itemUpdate.getName());
    }

    @Test
    public void testSetOriginalTitle() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String originalTitle = "TestOriginalTitle";
        itemUpdate.setOriginalTitle(originalTitle);
        assertEquals(originalTitle, itemUpdate.getOriginalTitle());
    }

    @Test
    public void testSetForcedSortName() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String forcedSortName = "TestForcedSortName";
        itemUpdate.setForcedSortName(forcedSortName);
        assertEquals(forcedSortName, itemUpdate.getForcedSortName());
    }

    @Test
    public void testSetCommunityRating() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        int communityRating = 5;
        itemUpdate.setCommunityRating(communityRating);
        assertEquals(communityRating, itemUpdate.getCommunityRating());
    }

    @Test
    public void testSetCriticRating() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        int criticRating = 8;
        itemUpdate.setCriticRating(criticRating);
        assertEquals(criticRating, itemUpdate.getCriticRating());
    }

    @Test
    public void testSetIndexNumber() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        Object indexNumber = 1;
        itemUpdate.setIndexNumber(indexNumber);
        assertEquals(indexNumber, itemUpdate.getIndexNumber());
    }

    @Test
    public void testSetAirsBeforeSeasonNumber() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String airsBeforeSeasonNumber = "1";
        itemUpdate.setAirsBeforeSeasonNumber(airsBeforeSeasonNumber);
        assertEquals(airsBeforeSeasonNumber, itemUpdate.getAirsBeforeSeasonNumber());
    }

    @Test
    public void testSetAirsAfterSeasonNumber() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String airsAfterSeasonNumber = "2";
        itemUpdate.setAirsAfterSeasonNumber(airsAfterSeasonNumber);
        assertEquals(airsAfterSeasonNumber, itemUpdate.getAirsAfterSeasonNumber());
    }

    @Test
    public void testSetAirsBeforeEpisodeNumber() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String airsBeforeEpisodeNumber = "3";
        itemUpdate.setAirsBeforeEpisodeNumber(airsBeforeEpisodeNumber);
        assertEquals(airsBeforeEpisodeNumber, itemUpdate.getAirsBeforeEpisodeNumber());
    }

    @Test
    public void testSetParentIndexNumber() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        Object parentIndexNumber = 4;
        itemUpdate.setParentIndexNumber(parentIndexNumber);
        assertEquals(parentIndexNumber, itemUpdate.getParentIndexNumber());
    }

    @Test
    public void testSetDisplayOrder() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String displayOrder = "TestDisplayOrder";
        itemUpdate.setDisplayOrder(displayOrder);
        assertEquals(displayOrder, itemUpdate.getDisplayOrder());
    }

    @Test
    public void testSetAlbum() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String album = "TestAlbum";
        itemUpdate.setAlbum(album);
        assertEquals(album, itemUpdate.getAlbum());
    }

    @Test
    public void testSetOverview() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String overview = "TestOverview";
        itemUpdate.setOverview(overview);
        assertEquals(overview, itemUpdate.getOverview());
    }

    @Test
    public void testSetStatus() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String status = "TestStatus";
        itemUpdate.setStatus(status);
        assertEquals(status, itemUpdate.getStatus());
    }

    @Test
    public void testSetGenres() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        ArrayList<String> genres = new ArrayList<>();
        genres.add("Genre1");
        genres.add("Genre2");
        itemUpdate.setGenres(genres);
        assertEquals(genres, itemUpdate.getGenres());
    }

    @Test
    public void testSetTags() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        ArrayList<String> tags = new ArrayList<>();
        tags.add("Tag1");
        tags.add("Tag2");
        itemUpdate.setTags(tags);
        assertEquals(tags, itemUpdate.getTags());
    }

    @Test
    public void testSetStudios() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        ArrayList<JellyfinStudioItem> studios = new ArrayList<>();
        JellyfinStudioItem studio = new JellyfinStudioItem();
        studios.add(studio);
        itemUpdate.setStudios(studios);
        assertEquals(studios, itemUpdate.getStudios());
    }

    @Test
    public void testSetPremiereDate() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String premiereDate = "2023-01-01";
        itemUpdate.setPremiereDate(premiereDate);
        assertEquals(premiereDate, itemUpdate.getPremiereDate());
    }

    @Test
    public void testSetDateCreated() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String dateCreated = "2023-01-01";
        itemUpdate.setDateCreated(dateCreated);
        assertEquals(dateCreated, itemUpdate.getDateCreated());
    }

    @Test
    public void testSetProductionYear() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        int productionYear = 2023;
        itemUpdate.setProductionYear(productionYear);
        assertEquals(productionYear, itemUpdate.getProductionYear());
    }

    @Test
    public void testSetOfficialRating() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String officialRating = "PG-13";
        itemUpdate.setOfficialRating(officialRating);
        assertEquals(officialRating, itemUpdate.getOfficialRating());
    }

    @Test
    public void testSetCustomRating() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String customRating = "CustomRating";
        itemUpdate.setCustomRating(customRating);
        assertEquals(customRating, itemUpdate.getCustomRating());
    }

    @Test
    public void testSetPeople() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        ArrayList<JellyfinPeopleItem> people = new ArrayList<>();
        JellyfinPeopleItem person = new JellyfinPeopleItem();
        people.add(person);
        itemUpdate.setPeople(people);
        assertEquals(people, itemUpdate.getPeople());
    }

    @Test
    public void testSetLockData() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        boolean lockData = true;
        itemUpdate.setLockData(lockData);
        assertTrue(itemUpdate.isLockData());
    }

    @Test
    public void testSetLockedFields() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        ArrayList<Object> lockedFields = new ArrayList<>();
        lockedFields.add("Field1");
        lockedFields.add("Field2");
        itemUpdate.setLockedFields(lockedFields);
        assertEquals(lockedFields, itemUpdate.getLockedFields());
    }

    @Test
    public void testSetPreferredMetadataLanguage() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String preferredMetadataLanguage = "en";
        itemUpdate.setPreferredMetadataLanguage(preferredMetadataLanguage);
        assertEquals(preferredMetadataLanguage, itemUpdate.getPreferredMetadataLanguage());
    }

    @Test
    public void testSetPreferredMetadataCountryCode() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        String preferredMetadataCountryCode = "US";
        itemUpdate.setPreferredMetadataCountryCode(preferredMetadataCountryCode);
        assertEquals(preferredMetadataCountryCode, itemUpdate.getPreferredMetadataCountryCode());
    }

    @Test
    public void testSetTaglines() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        ArrayList<Object> taglines = new ArrayList<>();
        taglines.add("Tagline1");
        taglines.add("Tagline2");
        itemUpdate.setTaglines(taglines);
        assertEquals(taglines, itemUpdate.getTaglines());
    }

    @Test
    public void testSetProviderIds() {
        JellyfinItemUpdate itemUpdate = new JellyfinItemUpdate();
        JellyfinProviderIds providerIds = new JellyfinProviderIds();
        itemUpdate.setProviderIds(providerIds);
        assertEquals(providerIds, itemUpdate.getProviderIds());
    }

}