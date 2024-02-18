package com.lariflix.jemm.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JellyfinPeopleItemTest {

    @Test
    public void testJellyfinPeopleItem() {
        JellyfinPeopleItem peopleItem = new JellyfinPeopleItem();

        String name = "TestName";
        peopleItem.setName(name);
        assertEquals(name, peopleItem.getName());

        String id = "TestID";
        peopleItem.setId(id);
        assertEquals(id, peopleItem.getId());

        String role = "TestRole";
        peopleItem.setRole(role);
        assertEquals(role, peopleItem.getRole());

        String type = "TestType";
        peopleItem.setType(type);
        assertEquals(type, peopleItem.getType());
    }
}