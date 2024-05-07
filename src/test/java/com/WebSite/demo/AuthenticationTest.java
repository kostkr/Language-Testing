package com.WebSite.demo;

import com.WebSite.demo.dataBase.UserDao;
import com.WebSite.demo.model.User;
import com.WebSite.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        User newUser = User.builder()
                .name("testUser")
                .email("test@example.com")
                .password("password")
                .role("ROLE_USER")
                .build();

        when(userDao.exists(newUser.getName())).thenReturn(false);

        userService.register(newUser);

        verify(userDao, times(1)).register(newUser);
    }

    @Test
    void testReadByName() {
        String userName = "testUser";
        User expectedUser = User.builder()
                .name(userName)
                .email("test@example.com")
                .password("password")
                .role("ROLE_USER")
                .build();

        when(userDao.read(userName)).thenReturn(expectedUser);

        User actualUser = userService.read(userName);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testExistsByName() {
        String userName = "testUser";
        when(userDao.exists(userName)).thenReturn(true);

        assertTrue(userService.exists(userName));
    }

    @Test
    void testLock() {
        long userId = 1L;

        userService.lock(userId);

        verify(userDao, times(1)).lock(userId);
    }

    @Test
    void testUnlock() {
        long userId = 1L;

        userService.unlock(userId);

        verify(userDao, times(1)).unlock(userId);
    }
}
