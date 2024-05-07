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
                .build();

        // Create a Lesson instance
        List<String> questions = Arrays.asList("Q1", "Q2", "Q3");
        Lesson lesson = Lesson.builder()
                .id(1L)
                .task("Complete the reading exercise.")
                .questions(questions)
                .build();

        // Verify that values were set correctly
        assertEquals(1L, lesson.getId());
        assertEquals("Complete the reading exercise.", lesson.getTask());
        assertEquals(questions, lesson.getQuestions());
    }
}

