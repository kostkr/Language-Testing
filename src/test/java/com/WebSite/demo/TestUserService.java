package com.WebSite.demo;


import com.WebSite.demo.dataBase.UserDao;
import com.WebSite.demo.model.User;
import com.WebSite.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestUserService {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = User.builder()
                .id(1L)
                .name("testUser")
                .email("test@example.com")
                .password("password")
                .role("ROLE_USER")
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isAccountNonExpired(true)
                .build();
    }

    @Test
    public void testRegister() {
        doNothing().when(userDao).register(user);
        userService.register(user);
        verify(userDao, times(1)).register(user);
    }

    @Test
    public void testReadByName() {
        when(userDao.read("testUser")).thenReturn(user);
        User foundUser = userService.read("testUser");
        assertThat(foundUser).isEqualTo(user);
    }

    @Test
    public void testReadById() {
        when(userDao.read(1L)).thenReturn(user);
        User foundUser = userService.read(1L);
        assertThat(foundUser).isEqualTo(user);
    }

    @Test
    public void testUpdate() {
        doNothing().when(userDao).update(user);
        userService.update(user);
        verify(userDao, times(1)).update(user);
    }

    @Test
    public void testDelete() {
        doNothing().when(userDao).delete(1L);
        userService.delete(1L);
        verify(userDao, times(1)).delete(1L);
    }

    @Test
    public void testExistsById() {
        when(userDao.exists(1L)).thenReturn(true);
        boolean exists = userService.exists(1L);
        assertThat(exists).isTrue();
    }

    @Test
    public void testExistsByName() {
        when(userDao.exists("testUser")).thenReturn(true);
        boolean exists = userService.exists("testUser");
        assertThat(exists).isTrue();
    }

    @Test
    public void testLock() {
        doNothing().when(userDao).lock(1L);
        userService.lock(1L);
        verify(userDao, times(1)).lock(1L);
    }

    @Test
    public void testUnlock() {
        doNothing().when(userDao).unlock(1L);
        userService.unlock(1L);
        verify(userDao, times(1)).unlock(1L);
    }

    @Test
    public void testRegisterUser() {
        String name = "newUser";
        String email = "new@example.com";
        String password = "newPassword";
        when(userDao.exists(name)).thenReturn(false);
        doNothing().when(userDao).register(any(User.class));
        userService.registerUser(name, email, password);
        verify(userDao, times(1)).register(any(User.class));
    }

    @Test
    public void testRegisterAdmin() {
        String name = "adminUser";
        String email = "admin@example.com";
        String password = "adminPassword";
        when(userDao.exists(name)).thenReturn(false);
        doNothing().when(userDao).register(any(User.class));
        userService.registerAdmin(name, email, password);
        verify(userDao, times(1)).register(any(User.class));
    }
}
