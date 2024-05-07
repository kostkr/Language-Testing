package com.WebSite.demo;

import com.WebSite.demo.dto.Album;
import com.WebSite.demo.dto.LessonInfo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AlbumTest {

    @Test
    void testAlbum() {
        // Create LessonInfo objects for testing
        LessonInfo lessonInfo1 = LessonInfo.builder().name("Lesson 1").build();
        LessonInfo lessonInfo2 = LessonInfo.builder().name("Lesson 2").build();

        // Create an Album object
        Album album = Album.builder()
                .type("Type1")
                .level("Level1")
                .lessonInfoList(Arrays.asList(lessonInfo1, lessonInfo2))
                .build();

        // Check that the Album object is created correctly
        assertThat(album).isNotNull();
        assertThat(album.getType()).isEqualTo("Type1");
        assertThat(album.getLevel()).isEqualTo("Level1");

        // Check that lessonInfoList is not null and contains two LessonInfo objects
        List<LessonInfo> lessonInfoList = album.getLessonInfoList();
        assertThat(lessonInfoList).isNotNull().hasSize(2);

        // Check that lessonInfoList contains the expected LessonInfo objects
        assertThat(lessonInfoList).containsExactly(lessonInfo1, lessonInfo2);
    }

    @Test
    public void testSetters() {
        // Create LessonInfo instances using the builder pattern
        LessonInfo lessonInfo1 = LessonInfo.builder()
                .name("Math")
                .level("Beginner")
                .type("Type1")
                .description("Description1")
                .imageURL("ImageURL1")
                .build();

        LessonInfo lessonInfo2 = LessonInfo.builder()
                .name("Physics")
                .level("Intermediate")
                .type("Type2")
                .description("Description2")
                .imageURL("ImageURL2")
                .build();

        // Create an Album instance
        Album album = Album.builder()
                .type("AlbumType")
                .level("AlbumLevel")
                .lessonInfoList(Arrays.asList(lessonInfo1, lessonInfo2))
                .build();


        // Verify that values were set correctly
        assertEquals("AlbumType", album.getType());
        assertEquals("AlbumLevel", album.getLevel());
        assertEquals(Arrays.asList(lessonInfo1, lessonInfo2), album.getLessonInfoList());
    }
}