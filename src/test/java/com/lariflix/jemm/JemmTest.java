package com.lariflix.jemm;

import com.lariflix.jemm.Jemm;
import com.lariflix.jemm.dtos.JellyfinCredentials;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JemmTest {

    @Test
    public void testMain() {
        String[] args = {"http://testurl.com", "testToken"};
        Jemm.main(args);

        JellyfinInstanceDetails instanceData = Jemm.getInstanceData();
        JellyfinCredentials credentials = instanceData.getCredentials();

        assertEquals("http://testurl.com", credentials.getBaseURL());
        assertEquals("testToken", credentials.getTokenAPI());
    }
}