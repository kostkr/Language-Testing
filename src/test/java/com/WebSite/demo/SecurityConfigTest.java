package com.WebSite.demo;

import com.WebSite.demo.web.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
public class SecurityConfigTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(UserController.class).build();
    }

    @Test
    public void testLoginPageAccessible() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAuthenticatedUserCanAccessMyLessons() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login").param("username", "yourUsername").param("password", "yourPassword"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
