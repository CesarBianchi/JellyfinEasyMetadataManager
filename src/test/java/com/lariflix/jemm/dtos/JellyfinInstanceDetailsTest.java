package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinInstanceDetailsTest {

    @Test
    public void testJellyfinInstanceDetails() {
        JellyfinInstanceDetails instanceDetails = new JellyfinInstanceDetails();

        JellyfinCredentials credentials = new JellyfinCredentials();
        instanceDetails.setCredentials(credentials);
        assertEquals(credentials, instanceDetails.getCredentials());

        JellyfinUsers users = new JellyfinUsers();
        instanceDetails.setUsers(users);
        assertEquals(users, instanceDetails.getUsers());

        JellyfinUser adminUser = new JellyfinUser();
        instanceDetails.setAdminUser(adminUser);
        assertEquals(adminUser, instanceDetails.getAdminUser());

        JellyfinFolders folders = new JellyfinFolders();
        instanceDetails.setFolders(folders);
        assertEquals(folders, instanceDetails.getFolders());
    }
}