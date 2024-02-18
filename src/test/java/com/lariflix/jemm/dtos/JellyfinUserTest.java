package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class JellyfinUserTest {

    @Test
    public void testJellyfinUser() {
        JellyfinUser user = new JellyfinUser();

        String name = "TestName";
        user.setName(name);
        assertEquals(name, user.getName());

        String serverId = "TestServerId";
        user.setServerId(serverId);
        assertEquals(serverId, user.getServerId());

        String id = "TestId";
        user.setId(id);
        assertEquals(id, user.getId());

        boolean hasPassword = true;
        user.setHasPassword(hasPassword);
        assertEquals(hasPassword, user.isHasPassword());

        boolean hasConfiguredPassword = true;
        user.setHasConfiguredPassword(hasConfiguredPassword);
        assertEquals(hasConfiguredPassword, user.isHasConfiguredPassword());

        boolean hasConfiguredEasyPassword = true;
        user.setHasConfiguredEasyPassword(hasConfiguredEasyPassword);
        assertEquals(hasConfiguredEasyPassword, user.isHasConfiguredEasyPassword());

        boolean enableAutoLogin = true;
        user.setEnableAutoLogin(enableAutoLogin);
        assertEquals(enableAutoLogin, user.isEnableAutoLogin());

        Date lastLoginDate = new Date();
        user.setLastLoginDate(lastLoginDate);
        assertEquals(lastLoginDate, user.getLastLoginDate());

        Date lastActivityDate = new Date();
        user.setLastActivityDate(lastActivityDate);
        assertEquals(lastActivityDate, user.getLastActivityDate());

        JellyfinUserConfiguration configuration = new JellyfinUserConfiguration();
        user.setConfiguration(configuration);
        assertEquals(configuration, user.getConfiguration());

        JellyfinUserPolicy policy = new JellyfinUserPolicy();
        user.setPolicy(policy);
        assertEquals(policy, user.getPolicy());

        String primaryImageTag = "TestPrimaryImageTag";
        user.setPrimaryImageTag(primaryImageTag);
        assertEquals(primaryImageTag, user.getPrimaryImageTag());
    }
}