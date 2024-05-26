package com.WebSite.demo;

import com.WebSite.demo.model.MyUserDetails;
import com.WebSite.demo.model.User;
import com.WebSite.demo.service.MyUserDetailService;
import com.WebSite.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyUserDetailServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private MyUserDetailService myUserDetailService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = User.builder()
                .id(1L)
                .name("testUser")
                .password("password")
                .email("testUser@example.com")
                .role("ROLE_USER")
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();
    }

    @Test
    public void testLoadUserByUsername_UserFound() {
        when(userService.read("testUser")).thenReturn(user);

        MyUserDetails userDetails = myUserDetailService.loadUserByUsername("testUser");

        assertEquals(user.getName(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertTrue(userDetails.isEnabled());

        verify(userService, times(1)).read("testUser");
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        when(userService.read("testUser")).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            myUserDetailService.loadUserByUsername("testUser");
        });

        verify(userService, times(1)).read("testUser");
    }
}
