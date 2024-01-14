package com.WebSite.demo;
import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.web.GreetingController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GreetingControllerTest {

    static MockedStatic mocked;

    @BeforeAll
    static void setUp() {
        mocked = mockStatic(LessonDao.class);}

    @AfterAll
    static void tearDown() {
        mocked.close();
    }

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();
    }

    @InjectMocks
    private GreetingController greetingController;

    private MockMvc mockMvc;

    @Test
    public void testShowHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting.html"));
    }

    @Test
    public void testSearchLessonExists() throws Exception {
        String lessonName = "Java";

        Mockito.when(LessonDao.findLessonByName(lessonName)).thenReturn(1L);

        mockMvc.perform(get("/searchLesson")
                        .param("name", lessonName))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/lesson/1"));

        Mockito.verify(LessonDao.class, times(1));
        LessonDao.findLessonByName("Java");
    }

    @Test
    public void testSearchLessonNotExists() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();

        String lessonName = "NonExistentLesson";

        Mockito.when(LessonDao.findLessonByName(lessonName)).thenReturn(null);

        mockMvc.perform(get("/searchLesson")
                        .param("name", lessonName))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting.html"));
    }
}
