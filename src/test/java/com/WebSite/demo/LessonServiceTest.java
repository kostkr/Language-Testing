package com.WebSite.demo;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.YoutubeUrlConverter;
import com.WebSite.demo.service.LessonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LessonServiceTest {

    @Mock
    private LessonDao lessonDao;

    @Mock
    private YoutubeUrlConverter youtubeUrlConverter;

    @InjectMocks
    private LessonService lessonService;

    private Lesson lesson;

    @BeforeEach
    public void setUp() {
        lesson = Lesson.builder()
                .type("Reading")
                .level("B1")
                .name("Lesson 1")
                .description("Description 1")
                .imageURL("http://image.url")
                .task("Task 1")
                .informationSource("http://info.source")
                .questions(Arrays.asList("Question 1", "Question 2"))
                .answersCorrect(Arrays.asList("Answer 1a", "Answer 2a"))
                .answersWrong(Arrays.asList("Answer 1b", "Answer 2b"))
                .wasCreatedTime("2024-01-01T00:00:00Z")
                .build();
    }

    @Test
    public void testCreate() {
        lessonService.create(lesson);
        verify(lessonDao, times(1)).create(lesson);
    }

    @Test
    public void testRead() {
        when(lessonDao.read(1L)).thenReturn(lesson);
        Lesson foundLesson = lessonService.read(1L);
        assertEquals(lesson, foundLesson);
    }

    @Test
    public void testFindLessonIdByName() {
        when(lessonDao.findLessonIdByName("Lesson 1")).thenReturn(1L);
        Long lessonId = lessonService.findLessonIdByName("Lesson 1");
        assertEquals(1L, lessonId);
    }

    @Test
    public void testUpdate() {
        lessonService.update(lesson);
        verify(lessonDao, times(1)).update(lesson);
    }

    @Test
    public void testDelete() {
        lessonService.delete(1L);
        verify(lessonDao, times(1)).delete(1L);
    }

    @Test
    public void testBuild() {
        Lesson builtLesson = lessonService.build(
                "Listening",
                "A2",
                "Lesson 2",
                "Description 2",
                "http://image.url/2",
                "Task 2",
                "http://youtube.com/watch?v=abcd",
                new String[]{"Q1", "Q2"},
                new String[]{"AW1", "AW2"},
                new String[]{"AC1", "AC2"}
        );

        assertEquals("Listening", builtLesson.getType());
        assertEquals("A2", builtLesson.getLevel());
        assertEquals("Lesson 2", builtLesson.getName());
        assertEquals("Description 2", builtLesson.getDescription());
        assertEquals("http://image.url/2", builtLesson.getImageURL());
        assertEquals("Task 2", builtLesson.getTask());
        assertEquals(Arrays.asList("Q1", "Q2"), builtLesson.getQuestions());
        assertEquals(Arrays.asList("AC1", "AC2"), builtLesson.getAnswersCorrect());
        assertEquals(Arrays.asList("AW1", "AW2"), builtLesson.getAnswersWrong());
    }

    @Test
    public void testCreateLessonProxi() {
        String[] questions = {"Q1", "Q2"};
        String[] answersCorrectArray = {"AC1", "AC2"};
        String[] answersWrongArray = {"AW1", "AW2"};
        Integer[] questionNumberCorrect = {1, 2};
        Integer[] questionNumberWrong = {1, 2};

        lessonService.createLessonProxi(
                "Writing",
                "B2",
                "Lesson 3",
                "Description 3",
                "http://image.url/3",
                "Task 3",
                "http://youtube.com/watch?v=efgh",
                questions,
                answersCorrectArray,
                answersWrongArray,
                questionNumberCorrect,
                questionNumberWrong
        );

        ArgumentCaptor<Lesson> lessonArgumentCaptor = ArgumentCaptor.forClass(Lesson.class);
        verify(lessonDao, times(1)).create(lessonArgumentCaptor.capture());
        Lesson capturedLesson = lessonArgumentCaptor.getValue();

        assertEquals("Writing", capturedLesson.getType());
        assertEquals("B2", capturedLesson.getLevel());
        assertEquals("Lesson 3", capturedLesson.getName());
        assertEquals("Description 3", capturedLesson.getDescription());
        assertEquals("http://image.url/3", capturedLesson.getImageURL());
        assertEquals("Task 3", capturedLesson.getTask());
        assertEquals(Arrays.asList("Q1", "Q2"), capturedLesson.getQuestions());
        assertEquals(Arrays.asList("AC1", "AC2"), capturedLesson.getAnswersCorrect());
        assertEquals(Arrays.asList("AW1", "AW2"), capturedLesson.getAnswersWrong());
    }
}
