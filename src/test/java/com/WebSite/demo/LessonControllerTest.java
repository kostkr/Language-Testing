package com.WebSite.demo;

import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.service.LessonService;
import com.WebSite.demo.web.LessonController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
public class LessonControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private LessonController lessonController;

    @Mock
    private LessonService lessonService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(lessonController).build();
    }

    @Test
    public void testShowLesson() throws Exception {
        long lessonId = 1L;
        Lesson lesson = new Lesson(); // Create a dummy Lesson object for the test
        lesson.setId(lessonId);
        lesson.setName("Test Lesson");

        Mockito.when(lessonService.read(lessonId)).thenReturn(lesson);

        mockMvc.perform(get("/lesson/{id}", lessonId))
                .andExpect(status().isOk())
                .andExpect(view().name("lesson"));
    }

    @Test
    public void testSearchLessonFound() throws Exception {
        String lessonName = "Test Lesson";
        long lessonId = 1L;

        Mockito.when(lessonService.findLessonIdByName(lessonName)).thenReturn(lessonId);

        mockMvc.perform(get("/searchLesson").param("name", lessonName))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchLessonNotFound() throws Exception {
        String lessonName = "Nonexistent Lesson";

        Mockito.when(lessonService.findLessonIdByName(lessonName)).thenReturn(0L);

        mockMvc.perform(get("/searchLesson").param("name", lessonName))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"));
    }
}

