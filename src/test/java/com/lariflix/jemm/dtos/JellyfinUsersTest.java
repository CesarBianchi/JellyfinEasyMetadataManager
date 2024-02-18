package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import com.lariflix.jemm.dtos.JellyfinUser;

public class JellyfinUsersTest {

    @Test
    public void testJellyfinUsers() {
        JellyfinUsers jellyfinUsers = new JellyfinUsers();

        List<JellyfinUser> users = new ArrayList<>();
        JellyfinUser user1 = new JellyfinUser();
        user1.setName("User1");
        users.add(user1);

        JellyfinUser user2 = new JellyfinUser();
        user2.setName("User2");
        users.add(user2);

        jellyfinUsers.setUsers(users);
        assertEquals(users, jellyfinUsers.getUsers());
    }
}