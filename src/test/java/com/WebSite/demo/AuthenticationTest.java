package com.WebSite.demo;

import com.WebSite.demo.dataBase.UserDao;
import com.WebSite.demo.model.MyUserDetailService;
import com.WebSite.demo.model.MyUserDetails;
import com.WebSite.demo.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;

public class AuthenticationTest {

    static MockedStatic mocked;

    @BeforeAll
    static void setUp() {
        mocked = mockStatic(UserDao.class);}

    @AfterAll
    static void tearDown() {
        mocked.close();
    }

    @Test
    public void testMyUserDetailsMethods() {
        // Create a User instance
        User user = new User();
        user.setName("John Doe");
        user.setPassword("secretpassword");
        user.setRole("ROLE_USER");

        // Create a MyUserDetails instance
        MyUserDetails userDetails = new MyUserDetails(user);

        // Verify that the methods return the expected values
        assertEquals(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")), userDetails.getAuthorities());
        assertEquals("secretpassword", userDetails.getPassword());
        assertEquals("John Doe", userDetails.getUsername());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertTrue(userDetails.isEnabled());
    }

    @Test
    void loadUserByUsername_existingUser_shouldReturnUserDetails() {
        // Arrange
        MyUserDetailService userDetailService = new MyUserDetailService();
        User existingUser = new User(1L, "JohnDoe", "john@example.com", "password", "ROLE_USER");
        Mockito.when(UserDao.findByName("JohnDoe")).thenReturn(existingUser);

        UserDetails userDetails = userDetailService.loadUserByUsername("JohnDoe");

        // Assert
        assertEquals(existingUser.getName(), userDetails.getUsername());
        assertEquals(existingUser.getPassword(), userDetails.getPassword());
        assertEquals(existingUser.getRole(), userDetails.getAuthorities().iterator().next().getAuthority());
    }

    @Test
    void loadUserByUsername_nonExistingUser_shouldThrowException() {
        // Arrange
        MyUserDetailService userDetailService = new MyUserDetailService();
        Mockito.when(UserDao.findByName(anyString())).thenReturn(null);

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userDetailService.loadUserByUsername("NonExistentUser"));
    }
}
