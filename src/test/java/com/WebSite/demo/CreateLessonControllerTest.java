package com.WebSite.demo;

import com.WebSite.demo.service.LessonService;
import com.WebSite.demo.web.CreateLessonController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(MockitoExtension.class)
public class CreateLessonControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CreateLessonController createLessonController;

    @Mock
    private LessonService lessonService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(createLessonController).build();
    }

    @Test
    public void testCreateLesson() throws Exception {
        String type = "Grammar";
        String level = "C2";
        String name = "Lesson 1";
        String description = "description";
        String imageURL = "URL";
        String task = "task";
        String informationSource = "source";
        String[] questions = {"Question 1", "Question 2"};
        String[] answersCorrectArray = {"Answer 1", "Answer 2"};
        String[] answersWrongArray = {"Wrong Answer 1", "Wrong Answer 2"};
        Integer[] questionNumberCorrect = {1, 2};
        Integer[] questionNumberWrong = {3, 4};

        // Mock the behavior of the lessonService.createLessonProxi method
        doNothing().when(lessonService).createLessonProxi(
                type, level, name, description, imageURL, task, informationSource,
                questions, answersCorrectArray, answersWrongArray, questionNumberCorrect, questionNumberWrong
        );

        mockMvc.perform(post("/createLesson")
                        .param("type", type)
                        .param("level", level)
                        .param("name", name)
                        .param("description", description)
                        .param("imageURL", imageURL)
                        .param("task", task)
                        .param("informationSource", informationSource)
                        .param("questions[]", questions)
                        .param("answersCorrect[]", answersCorrectArray)
                        .param("answersWrong[]", answersWrongArray)
                        .param("questionNumberCorrect[]", "1", "2")
                        .param("questionNumberWrong[]", "3", "4"))
                .andExpect(status().isOk())
                .andExpect(view().name("createLessonPage"));
    }

    @Test
    public void showCreateLessonPage() throws Exception {
        mockMvc.perform(get("/createLesson"))
                .andExpect(status().isOk())
                .andExpect(view().name("createLessonPage"));
    }
}
