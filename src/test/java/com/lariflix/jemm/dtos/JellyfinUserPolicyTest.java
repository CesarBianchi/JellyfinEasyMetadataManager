package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinUserPolicyTest {

    @Test
    public void testJellyfinUserPolicy() {
        JellyfinUserPolicy userPolicy = new JellyfinUserPolicy();

        boolean isAdministrator = true;
        userPolicy.setIsAdministrator(isAdministrator);
        assertEquals(isAdministrator, userPolicy.isIsAdministrator());

        boolean isHidden = true;
        userPolicy.setIsHidden(isHidden);
        assertEquals(isHidden, userPolicy.isIsHidden());

        boolean isDisabled = true;
        userPolicy.setIsDisabled(isDisabled);
        assertEquals(isDisabled, userPolicy.isIsDisabled());

        boolean enableUserPreferenceAccess = true;
        userPolicy.setEnableUserPreferenceAccess(enableUserPreferenceAccess);
        assertEquals(enableUserPreferenceAccess, userPolicy.isEnableUserPreferenceAccess());

        boolean enableRemoteControlOfOtherUsers = true;
        userPolicy.setEnableRemoteControlOfOtherUsers(enableRemoteControlOfOtherUsers);
        assertEquals(enableRemoteControlOfOtherUsers, userPolicy.isEnableRemoteControlOfOtherUsers());

        boolean enableSharedDeviceControl = true;
        userPolicy.setEnableSharedDeviceControl(enableSharedDeviceControl);
        assertEquals(enableSharedDeviceControl, userPolicy.isEnableSharedDeviceControl());

        boolean enableLiveTvManagement = true;
        userPolicy.setEnableLiveTvManagement(enableLiveTvManagement);
        assertEquals(enableLiveTvManagement, userPolicy.isEnableLiveTvManagement());

        boolean enableLiveTvAccess = true;
        userPolicy.setEnableLiveTvAccess(enableLiveTvAccess);
        assertEquals(enableLiveTvAccess, userPolicy.isEnableLiveTvAccess());

        // Add more test cases for other methods in a similar way
    }
}