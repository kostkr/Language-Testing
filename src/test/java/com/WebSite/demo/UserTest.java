package com.WebSite.demo;

import com.WebSite.demo.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUserGettersAndSetters() {
        // Create a User instance
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("secretpassword");
        user.setRole("ROLE_USER");

        // Verify that getters return the expected values
        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("secretpassword", user.getPassword());
        assertEquals("ROLE_USER", user.getRole());

        // You can also verify that the generated equals and hashCode methods work as expected
        User anotherUser = new User(1L, "John Doe", "john.doe@example.com", "secretpassword", "ROLE_USER");
        assertEquals(user, anotherUser);
        assertEquals(user.hashCode(), anotherUser.hashCode());
    }
}
