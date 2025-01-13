package com.lariflix.jemm.csv;

import com.lariflix.jemm.dtos.JellyfinStudioItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JellyfinCsvStructureTest {

    private JellyfinCsvStructure csvStructure;

    @BeforeEach
    void setUp() {
        csvStructure = new JellyfinCsvStructure();
    }

    @Test
    void testGetAndSetId() {
        String id = "123";
        csvStructure.setId(id);
        assertEquals(id, csvStructure.getId());
    }

    @Test
    void testGetAndSetParentId() {
        String parentId = "456";
        csvStructure.setParentId(parentId);
        assertEquals(parentId, csvStructure.getParentId());
    }

    @Test
    void testGetAndSetName() {
        String name = "Test Name";
        csvStructure.setName(name);
        assertEquals(name, csvStructure.getName());
    }

    @Test
    void testGetAndSetOriginalTitle() {
        String originalTitle = "Original Title";
        csvStructure.setOriginalTitle(originalTitle);
        assertEquals(originalTitle, csvStructure.getOriginalTitle());
    }

    @Test
    void testGetAndSetSortName() {
        String sortName = "Sort Name";
        csvStructure.setSortName(sortName);
        assertEquals(sortName, csvStructure.getSortName());
    }

    @Test
    void testGetAndSetForcedSortName() {
        String forcedSortName = "Forced Sort Name";
        csvStructure.setForcedSortName(forcedSortName);
        assertEquals(forcedSortName, csvStructure.getForcedSortName());
    }

    @Test
    void testGetAndSetType() {
        String type = "Movie";
        csvStructure.setType(type);
        assertEquals(type, csvStructure.getType());
    }

    @Test
    void testGetAndSetCollectionType() {
        String collectionType = "Box Set";
        csvStructure.setCollectionType(collectionType);
        assertEquals(collectionType, csvStructure.getCollectionType());
    }

    @Test
    void testGetAndSetProductionYear() {
        String productionYear = "2021";
        csvStructure.setProductionYear(productionYear);
        assertEquals(productionYear, csvStructure.getProductionYear());
    }

    @Test
    void testGetAndSetCommunityRating() {
        String communityRating = "8.5";
        csvStructure.setCommunityRating(communityRating);
        assertEquals(communityRating, csvStructure.getCommunityRating());
    }

    @Test
    void testGetAndSetCriticRating() {
        String criticRating = "7.5";
        csvStructure.setCriticRating(criticRating);
        assertEquals(criticRating, csvStructure.getCriticRating());
    }

    @Test
    void testGetAndSetOfficialRating() {
        String officialRating = "PG-13";
        csvStructure.setOfficialRating(officialRating);
        assertEquals(officialRating, csvStructure.getOfficialRating());
    }

    @Test
    void testGetAndSetPremiereDate() {
        String premiereDate = "2021-12-25";
        csvStructure.setPremiereDate(premiereDate);
        assertEquals(premiereDate, csvStructure.getPremiereDate());
    }

    @Test
    void testGetAndSetDateCreated() {
        String dateCreated = "2021-01-01";
        csvStructure.setDateCreated(dateCreated);
        assertEquals(dateCreated, csvStructure.getDateCreated());
    }

    @Test
    void testGetAndSetGenres() {
        String genres = "Action, Adventure";
        csvStructure.setGenres(genres);
        assertEquals(genres, csvStructure.getGenres());
    }

    @Test
    void testSetGenresFromList() {
        ArrayList<String> genres = new ArrayList<>();
        genres.add("Action");
        genres.add("Adventure");
        csvStructure.setGenres(genres);
        assertEquals("Action, Adventure", csvStructure.getGenres());
    }

    @Test
    void testGetAndSetPreferredMetadataLanguage() {
        String language = "en";
        csvStructure.setPreferredMetadataLanguage(language);
        assertEquals(language, csvStructure.getPreferredMetadataLanguage());
    }

    @Test
    void testGetAndSetPreferredMetadataCountryCode() {
        String countryCode = "US";
        csvStructure.setPreferredMetadataCountryCode(countryCode);
        assertEquals(countryCode, csvStructure.getPreferredMetadataCountryCode());
    }

    @Test
    void testGetAndSetStudios() {
        ArrayList<JellyfinStudioItem> studios = new ArrayList<>();
        JellyfinStudioItem studio = new JellyfinStudioItem();
        studio.setName("Warner Bros.");
        studios.add(studio);
        csvStructure.setStudios(studios);
        assertEquals("Warner Bros.", csvStructure.getStudios());
    }

    @Test
    void testGetAndSetTags() {
        String tags = "Tag1, Tag2";
        csvStructure.setTags(tags);
        assertEquals(tags, csvStructure.getTags());
    }

    @Test
    void testSetTagsFromList() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("Tag1");
        tags.add("Tag2");
        csvStructure.setTags(tags);
        assertEquals("Tag1, Tag2", csvStructure.getTags());
    }

    @Test
    void testGetAndSetLocationType() {
        String locationType = "Physical";
        csvStructure.setLocationType(locationType);
        assertEquals(locationType, csvStructure.getLocationType());
    }

    @Test
    void testGetAndSetMediaType() {
        String mediaType = "Video";
        csvStructure.setMediaType(mediaType);
        assertEquals(mediaType, csvStructure.getMediaType());
    }

    @Test
    void testGetAndSetIsHD() {
        String isHD = "True";
        csvStructure.setIsHD(isHD);
        assertEquals(isHD, csvStructure.getIsHD());
    }

    @Test
    void testSetIsHDFromBoolean() {
        csvStructure.setIsHD(true);
        assertEquals("True", csvStructure.getIsHD());
        csvStructure.setIsHD(false);
        assertEquals("False", csvStructure.getIsHD());
    }

    @Test
    void testGetAndSetPath() {
        String path = "/path/to/file";
        csvStructure.setPath(path);
        assertEquals(path, csvStructure.getPath());
    }

    @Test
    void testRemoveInvalidChars() {
        String input = "Invalid;Chars";
        String expected = "InvalidChars";
        assertEquals(expected, csvStructure.removeInvalidChars(input));
    }

    @Test
    void testGetAndSetJemmVersion() {
        String version = "1.0.0";
        csvStructure.setJemmVersion(version);
        assertNotNull(csvStructure.getJemmVersion());
    }

    @Test
    void testCheckJellyfinVersionMD5() {
        String version = "1.0.0";
        csvStructure.setJemmVersion(version);
        assertTrue(csvStructure.checkJellyfinVersionMD5(csvStructure.getJemmVersion(), version));
    }

    @Test
    void testGetAndSetServerID() {
        String serverID = "server123";
        csvStructure.setServerID(serverID);
        assertEquals(serverID, csvStructure.getServerID());
    }

    @Test
    void testGetAndSetOverview() {
        String overview = "This is an overview.";
        csvStructure.setOverview(overview);
        assertEquals("This is an overview.", csvStructure.getOverview());
    }

    @Test
    void testGetOverviewWithSkips() {
        String overview = "This is an overview.";
        csvStructure.setOverview(overview);
        assertEquals("This is an overview.", csvStructure.getOverviewWithSkips());
    }
}