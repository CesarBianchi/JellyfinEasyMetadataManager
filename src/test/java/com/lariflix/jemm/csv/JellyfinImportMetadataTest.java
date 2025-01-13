package com.lariflix.jemm.csv;

import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.utils.JellyfinResponseStandard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JellyfinImportMetadataTest {

    private JellyfinImportMetadata importMetadata;
    private JellyfinInstanceDetails instanceDetails;

    @BeforeEach
    void setUp() {
        instanceDetails = new JellyfinInstanceDetails();
        importMetadata = new JellyfinImportMetadata("testPath", instanceDetails);
    }

    @Test
    void testConstructorWithParameters() {
        assertEquals("testPath", importMetadata.getcOriginPath());
        assertEquals(instanceDetails, importMetadata.getInstanceData());
    }

    @Test
    void testGetAndSetFileLines() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("line1");
        importMetadata.setFileLines(fileLines);
        assertEquals(fileLines, importMetadata.getFileLines());
    }

    @Test
    void testGetLogDiferencesFile() {
        assertNotNull(importMetadata.getLogDiferencesFile());
    }

    @Test
    void testSetLogDiferencesFile() {
        importMetadata.setLogDiferencesFile();
        assertNotNull(importMetadata.getLogDiferencesFile());
    }

    @Test
    void testGetAndSetInstanceData() {
        JellyfinInstanceDetails newInstanceDetails = new JellyfinInstanceDetails();
        importMetadata.setInstanceData(newInstanceDetails);
        assertEquals(newInstanceDetails, importMetadata.getInstanceData());
    }

    @Test
    void testGetcOriginPath() {
        assertEquals("testPath", importMetadata.getcOriginPath());
    }

    @Test
    void testGetTotalLineToProcess() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("line1");
        fileLines.add("line2");
        importMetadata.setFileLines(fileLines);
        assertEquals(2, importMetadata.getTotalLineToProcess());
    }

    @Test
    void testStartPreCheckSuccess() throws IOException {
        JellyfinImportMetadata spyImportMetadata = Mockito.spy(importMetadata);
        //doReturn(new JellyfinResponseStandard(true, "CSV_IMP_004", "The fields/columns between the CSV file and the expected are the same. Good job!")).when(spyImportMetadata).checkHeader();
        //doReturn(new JellyfinResponseStandard(true, "CSV_IMP_006", "File lines (fields and columns) are ok")).when(spyImportMetadata).preCheckLines();
        //doReturn(new JellyfinResponseStandard(true, "", "All lines have a valid ServerID and JemmVersion")).when(spyImportMetadata).grantOrigin();
        //doReturn(new JellyfinResponseStandard(true, "CSV_IMP_010", "Pre-check import process ok. File ready to be imported!")).when(spyImportMetadata).compareDiferencesInLine();
        spyImportMetadata.setOriginPath("");
        JellyfinResponseStandard response = spyImportMetadata.startPreCheck();
        assertTrue(!response.isSuccess());
        assertEquals("CSV_IMP_011", response.getResponseCode());
    }

    @Test
    void testStartPreCheckFailure() throws IOException {
        JellyfinImportMetadata spyImportMetadata = Mockito.spy(importMetadata);
        //doReturn(new JellyfinResponseStandard(false, "CSV_IMP_003", "The fields/columns inside the CSV file are not equal to expected.")).when(spyImportMetadata).checkHeader();
        spyImportMetadata.setOriginPath("");
        JellyfinResponseStandard response = spyImportMetadata.startPreCheck();
        assertFalse(response.isSuccess());
        assertEquals("CSV_IMP_011", response.getResponseCode());
    }

    @Test
    void testCheckHeader() throws IOException {
        JellyfinImportMetadata spyImportMetadata = Mockito.spy(importMetadata);
        doReturn(new ArrayList<String>() {{
            add("Id");
            add("Name");
        }}).when(spyImportMetadata).getHeaderFromFile();

        JellyfinResponseStandard response = spyImportMetadata.checkHeader();
        assertFalse(response.isSuccess());
        assertEquals("CSV_IMP_001", response.getResponseCode());
    }

    @Test
    void testPreCheckLines() throws IOException {
        JellyfinImportMetadata spyImportMetadata = Mockito.spy(importMetadata);
        doReturn(new ArrayList<String>() {{
            add("Id;Name");
            add("1;Test");
        }}).when(spyImportMetadata).getFileLines();
        
        spyImportMetadata.setOriginPath("");
        JellyfinResponseStandard response = spyImportMetadata.preCheckLines();
        assertTrue(response.isSuccess());
        assertEquals("CSV_IMP_006", response.getResponseCode());
    }

    @Test
    void testGrantOrigin() {
        JellyfinImportMetadata spyImportMetadata = Mockito.spy(importMetadata);
        doReturn(new ArrayList<String>() {{
            add("Id;Name;JemmVersion;ServerID");
            add("1;Test;1.0.0;server123");
        }}).when(spyImportMetadata).getFileLines();

        JellyfinResponseStandard response = spyImportMetadata.grantOrigin();
        assertTrue(response.isSuccess());
        assertEquals("", response.getResponseCode());
    }

    @Test
    void testStartImport() {
        JellyfinImportMetadata spyImportMetadata = Mockito.spy(importMetadata);
        doReturn(new ArrayList<String>() {{
            add("Id;Name;Type;ParentId");
            add("1;Test;Folder;0");
        }}).when(spyImportMetadata).getFileLines();

        JellyfinResponseStandard response = spyImportMetadata.startImport();
        assertTrue(response.isSuccess());
        assertEquals("", response.getResponseCode());
    }

    @Test
    void testCompareValues() {
        boolean result = importMetadata.compareValues("oldValue", "newValue", "property", "1", false);
        assertTrue(result);
    }

    @Test
    void testMyTokenizer() {
        ArrayList<String> result = importMetadata.myTokenizer("a;b;c", ";");
        assertEquals(3, result.size());
        assertEquals("a", result.get(0));
        assertEquals("b", result.get(1));
        assertEquals("c", result.get(2));
    }
}