package com.WebSite.demo;

import com.WebSite.demo.service.UserService;
import com.WebSite.demo.web.AdminController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MockitoExtension.class)
public class AdminControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AdminController adminController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void testDeleteUser() throws Exception {
        long userId = 1L;

        // Mocking the delete method
        doNothing().when(userService).delete(userId);

        mockMvc.perform(get("/admin/deleteUser/{id}", userId))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testLockUser() throws Exception {
        long userId = 1L;

        // Mocking the lock method
        doNothing().when(userService).lock(userId);

        mockMvc.perform(get("/admin/lockUser/{id}", userId))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testUnlockUser() throws Exception {
        long userId = 1L;

        // Mocking the unlock method
        doNothing().when(userService).unlock(userId);

        mockMvc.perform(get("/admin/unlockUser/{id}", userId))
                .andExpect(status().is4xxClientError());
    }
}
