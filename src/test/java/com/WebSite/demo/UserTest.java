package com.WebSite.demo;

import com.WebSite.demo.model.User;
import jakarta.persistence.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = User.builder()
                .id(1L)
                .name("testuser")
                .password("password")
                .email("testuser@example.com")
                .role("ROLE_USER")
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();
    }

    @Test
    public void testToString() {
        String expected = "User(id=1, name=testuser, password=password, email=testuser@example.com, role=ROLE_USER, isAccountNonExpired=true, isAccountNonLocked=true, isCredentialsNonExpired=true, isEnabled=true)";
        assertEquals(expected, user.toString());
    }

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
        assertFalse(user.isAccountNonExpired());
        assertFalse(user.isAccountNonLocked());
        assertFalse(user.isCredentialsNonExpired());
        assertFalse(user.isEnabled());

    }
}
