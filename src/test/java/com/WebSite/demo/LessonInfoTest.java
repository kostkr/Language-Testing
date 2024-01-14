package com.WebSite.demo;

import com.WebSite.demo.model.LessonInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class LessonInfoTest {

    @Test
    public void testLessonInfo() {
        // Create a LessonInfo instance using the builder pattern
        LessonInfo lessonInfo = LessonInfo.builder()
                .id(1L)
                .name("English Lesson")
                .level("B1")
                .type("Reading")
                .description("This is a sample lesson.")
                .imageURL("sample-image.jpg")
                .opt("video-url")
                .build();

        LessonInfo lessonInfo1 = new LessonInfo();

        assertThat(lessonInfo1).isNotNull();

        lessonInfo.setName("newName");
        // Verify that values were set correctly
        assertEquals(1L, lessonInfo.getId());
        assertEquals("newName", lessonInfo.getName());
        assertEquals("B1", lessonInfo.getLevel());
        assertEquals("Reading", lessonInfo.getType());
        assertEquals("This is a sample lesson.", lessonInfo.getDescription());
        assertEquals("sample-image.jpg", lessonInfo.getImageURL());
        assertEquals("video-url", lessonInfo.getOpt());
    }
}
