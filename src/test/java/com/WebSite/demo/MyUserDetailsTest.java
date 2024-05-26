package com.WebSite.demo;


import com.WebSite.demo.model.MyUserDetails;
import com.WebSite.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class MyUserDetailsTest {

    private User mockUser;
    private MyUserDetails userDetails;

    @BeforeEach
    public void setUp() {
        mockUser = Mockito.mock(User.class);
        userDetails = new MyUserDetails(mockUser);
    }

    @Test
    public void testGetPassword() {
        when(mockUser.getPassword()).thenReturn("password123");

        assertThat(userDetails.getPassword()).isEqualTo("password123");
    }

    @Test
    public void testGetUsername() {
        when(mockUser.getName()).thenReturn("john_doe");

        assertThat(userDetails.getUsername()).isEqualTo("john_doe");
    }

    @Test
    public void testIsAccountNonExpired() {
        when(mockUser.isAccountNonExpired()).thenReturn(true);

        assertThat(userDetails.isAccountNonExpired()).isTrue();

        when(mockUser.isAccountNonExpired()).thenReturn(false);

        assertThat(userDetails.isAccountNonExpired()).isFalse();
    }

    @Test
    public void testIsAccountNonLocked() {
        when(mockUser.isAccountNonLocked()).thenReturn(true);

        assertThat(userDetails.isAccountNonLocked()).isTrue();

        when(mockUser.isAccountNonLocked()).thenReturn(false);

        assertThat(userDetails.isAccountNonLocked()).isFalse();
    }

    @Test
    public void testIsCredentialsNonExpired() {
        when(mockUser.isCredentialsNonExpired()).thenReturn(true);

        assertThat(userDetails.isCredentialsNonExpired()).isTrue();

        when(mockUser.isCredentialsNonExpired()).thenReturn(false);

        assertThat(userDetails.isCredentialsNonExpired()).isFalse();
    }

    @Test
    public void testIsEnabled() {
        when(mockUser.isEnabled()).thenReturn(true);

        assertThat(userDetails.isEnabled()).isTrue();

        when(mockUser.isEnabled()).thenReturn(false);

        assertThat(userDetails.isEnabled()).isFalse();
    }
}
