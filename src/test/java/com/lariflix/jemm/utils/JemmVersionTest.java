package com.lariflix.jemm.utils;

import com.lariflix.jemm.utils.JemmVersion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JemmVersionTest {

    @Test
    public void testGetVersion() {
        JemmVersion jemmVersion = new JemmVersion();

        // Test that the getVersion method returns the correct version
        assertEquals("v1.0.3 - (beta)", jemmVersion.getVersion());
    }
}