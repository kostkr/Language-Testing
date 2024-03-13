package com.WebSite.demo;

import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.dto.LessonInfo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LessonTest {

    @Test
    public void testLesson() {
        // Create a LessonInfo instance
        LessonInfo lessonInfo = LessonInfo.builder()
                .id(1L)
                .name("English Lesson")
                .level("B1")
                .type("Reading")
                .description("This is a sample lesson.")
                .imageURL("sample-image.jpg")
                .opt("video-url")
                .build();

        // Create a Lesson instance
        List<String> questions = Arrays.asList("Q1", "Q2", "Q3");
        List<String> answers = Arrays.asList("A1", "A2", "A3");
        Lesson lesson = Lesson.builder()
                .id(1L)
                .task("Complete the reading exercise.")
                .lessonInfo(lessonInfo)
                .questions(questions)
                .answers(answers)
                .build();

        // Verify that values were set correctly
        assertEquals(1L, lesson.getId());
        assertEquals("Complete the reading exercise.", lesson.getTask());
        assertEquals(lessonInfo, lesson.getLessonInfo());
        assertEquals(questions, lesson.getQuestions());
        assertEquals(answers, lesson.getAnswers());
    }

    @Test
    public void testLessonInfoGettersAndSetters() {
        // Create a LessonInfo instance
        LessonInfo lessonInfo = new LessonInfo();
        lessonInfo.setId(1L);
        lessonInfo.setName("English Lesson");
        lessonInfo.setLevel("B1");
        lessonInfo.setType("Reading");
        lessonInfo.setDescription("This is a sample lesson.");
        lessonInfo.setImageURL("sample-image.jpg");
        lessonInfo.setOpt("video-url");

        // Verify that getters return the expected values
        assertEquals(1L, lessonInfo.getId());
        assertEquals("English Lesson", lessonInfo.getName());
        assertEquals("B1", lessonInfo.getLevel());
        assertEquals("Reading", lessonInfo.getType());
        assertEquals("This is a sample lesson.", lessonInfo.getDescription());
        assertEquals("sample-image.jpg", lessonInfo.getImageURL());
        assertEquals("video-url", lessonInfo.getOpt());
    }
}
