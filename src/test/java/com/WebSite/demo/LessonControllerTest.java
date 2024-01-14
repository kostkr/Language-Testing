package com.WebSite.demo;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.LessonInfo;
import com.WebSite.demo.web.LessonController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LessonControllerTest {

    private static AutoCloseable mocked;

    @BeforeAll
    static void setUp() {
        mocked = mockStatic(LessonDao.class);}

    @AfterAll
    static void tearDown() throws Exception {
        mocked.close();
    }

    @InjectMocks
    private LessonController lessonController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(lessonController).build();
    }

    @Test
    public void testShowLessonEmpty() throws Exception {
        long lessonId = 1L;
        Lesson lesson = new Lesson();
        when(LessonDao.findLessonById(lessonId)).thenReturn(lesson);


        mockMvc.perform(get("/lesson/{id}", lessonId))
                .andExpect(status().isOk())
                .andExpect(view().name("lesson.html"))
                .andExpect(model().attributeExists("lesson"));
    }

    @Test
    public void testShowLesson() throws Exception {
        long lessonId = 2L;
        LessonInfo lessonInfo = LessonInfo.builder()
                .id(lessonId)
                .name("myname")
                .level(LessonInfo.Level.A1.name())
                .type(LessonInfo.Type.Writing.name())
                .description("mydescription")
                .imageURL("https://comparic.pl/wp-content/uploads/2021/06/doge-shiba.jpg")
                .opt("https://www.youtube-nocookie.com/embed/YdWo5zbbGnY?si=5F_L8FWP1mzGDkjM")
                .build();

        Lesson lesson = Lesson.builder()
                .id(lessonId)
                .task("task")
                .lessonInfo(lessonInfo)
                .questions(new ArrayList<>(List.of("questionsArray")))
                .answers(new ArrayList<>(List.of("answersArray")))
                .build();

        when(LessonDao.findLessonById(lessonId)).thenReturn(lesson);


        mockMvc.perform(get("/lesson/{id}", lessonId))
                .andExpect(status().isOk())
                .andExpect(view().name("lesson.html"))
                .andExpect(model().attributeExists("lesson"));
    }
}
