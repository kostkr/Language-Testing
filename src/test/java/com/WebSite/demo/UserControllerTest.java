package com.WebSite.demo;

import com.WebSite.demo.service.UserService;
import com.WebSite.demo.web.UserController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MockitoExtension.class)
public class UserControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testShowLogin() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginPage"));
    }

    @Test
    public void testShowSignUp() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("signupPage"));
    }

    @Test
    public void testSignUpUser() throws Exception {
        String name = "testUser";
        String email = "test@example.com";
        String password = "testPassword";

        mockMvc.perform(post("/signup")
                        .param("name", name)
                        .param("email", email)
                        .param("password", password))
                .andExpect(status().isOk())
                .andExpect(view().name("loginPage"));
    }
}
