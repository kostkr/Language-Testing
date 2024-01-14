package com.WebSite.demo;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.web.CreateLessonController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mockStatic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class CreateLessonControllerTest {

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
        mockMvc = MockMvcBuilders.standaloneSetup(createLessonController).build();
    }

    @InjectMocks
    private CreateLessonController createLessonController;

    private MockMvc mockMvc;

    @Test
    void testProcessForm() throws Exception {
        mockMvc.perform(post("/createLesson")
                        .param("name", "Test Lesson")
                        .param("level", "Beginner")
                        .param("type", "Type1")
                        .param("description", "Description")
                        .param("imageURL", "http://example.com/image.jpg")
                        .param("task", "Task")
                        .param("questions[]", "Question1", "Question2")
                        .param("answers[]", "Answer1", "Answer2"))
                .andExpect(status().isOk())
                .andExpect(view().name("createLesson.html"));
    }

    @Test
    void testShowCreateTestPage() throws Exception {
        mockMvc.perform(get("/createLesson"))
                .andExpect(status().isOk())
                .andExpect(view().name("createLesson.html"));
    }

    @Test
    public void processForm_Should_SaveNewLesson_When_ValidDataProvided() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(createLessonController).build();

        mockMvc.perform(post("/createLesson")
                        .param("name", "Math")
                        .param("level", "Beginner")
                        .param("type", "Type1")
                        .param("description", "Description1")
                        .param("imageURL", "ImageURL1")
                        .param("task", "Task1")
                        .param("questions[]", "Question1")
                        .param("answers[]", "Answer1"))
                .andExpect(status().isOk());
    }

    @Test
    public void processForm_Should_ReturnCreateLessonPage_When_InvalidDataProvided() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(createLessonController).build();

        mockMvc.perform(post("/createLesson")
                        .param("name", "")
                        .param("level", "Beginner")
                        .param("type", "Type1")
                        .param("description", "Description1")
                        .param("imageURL", "ImageURL1")
                        .param("task", "Task1")
                        .param("questions[]", "Question1")
                        .param("answers[]", "Answer1"))
                .andExpect(status().isOk());
    }
}
