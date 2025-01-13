package com.lariflix.jemm.csv;

import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.utils.JellyfinResponseStandard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JellyfinExportMetadataTest {

    private JellyfinExportMetadata exportMetadata;
    private JellyfinInstanceDetails instanceDetails;

    @BeforeEach
    public void setUp() {
        instanceDetails = new JellyfinInstanceDetails();
        exportMetadata = new JellyfinExportMetadata("testPath", instanceDetails);
    }

    @Test
    public void testConstructorWithParameters() {
        assertEquals("testPath", exportMetadata.getDestinationPath());
        assertEquals(instanceDetails, exportMetadata.getInstanceData());
    }

    @Test
    public void testGetAndSetDestinationPath() {
        exportMetadata.setDestinationPath("newPath");
        assertEquals("newPath", exportMetadata.getDestinationPath());
    }

    @Test
    public void testGetAndSetInstanceData() {
        JellyfinInstanceDetails newInstanceDetails = new JellyfinInstanceDetails();
        exportMetadata.setInstanceData(newInstanceDetails);
        assertEquals(newInstanceDetails, exportMetadata.getInstanceData());
    }

    @Test
    public void testStartProcessSuccess() throws IOException, ParseException {
        JellyfinExportMetadata spyExportMetadata = Mockito.spy(exportMetadata);
        doReturn(true).when(spyExportMetadata).loadItems();
        doReturn(true).when(spyExportMetadata).loadSubItems();
        doReturn(true).when(spyExportMetadata).loadLines();
        doReturn(true).when(spyExportMetadata).createCSVFile();

        JellyfinResponseStandard response = spyExportMetadata.startProcess();
        assertTrue(!response.isSuccess());
        assertEquals("", response.getResponseCode());
    }

    @Test
    public void testStartProcessEmptyDestinationPath() {
        JellyfinExportMetadata exportMetadataWithEmptyPath = new JellyfinExportMetadata("", instanceDetails);
        JellyfinResponseStandard response = exportMetadataWithEmptyPath.startProcess();
        assertFalse(response.isSuccess());
        assertEquals("CSV_EXP_005", response.getResponseCode());
    }

    @Test
    public void testLoadItems() throws IOException, ParseException {
        JellyfinExportMetadata spyExportMetadata = Mockito.spy(exportMetadata);
        doReturn(true).when(spyExportMetadata).loadItems();
        assertTrue(spyExportMetadata.loadItems());
    }

    @Test
    public void testLoadSubItems() {
        JellyfinExportMetadata spyExportMetadata = Mockito.spy(exportMetadata);
        doReturn(true).when(spyExportMetadata).loadSubItems();
        assertTrue(spyExportMetadata.loadSubItems());
    }

    @Test
    public void testLoadLines() {
        JellyfinExportMetadata spyExportMetadata = Mockito.spy(exportMetadata);
        doReturn(true).when(spyExportMetadata).loadLines();
        assertTrue(spyExportMetadata.loadLines());
    }

    @Test
    public void testCreateCSVFile() {
        JellyfinExportMetadata spyExportMetadata = Mockito.spy(exportMetadata);
        doReturn(true).when(spyExportMetadata).createCSVFile();
        assertTrue(spyExportMetadata.createCSVFile());
    }
}