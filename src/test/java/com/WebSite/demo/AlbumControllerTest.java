package com.WebSite.demo;

import com.WebSite.demo.dataBase.AlbumDao;
import com.WebSite.demo.dto.LessonInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AlbumDaoTest {

    @Mock
    private AlbumDao albumDao;

    @InjectMocks
    private AlbumDaoTest albumDaoTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindLessonsByTypeAndLevel() {
        // Arrange
        String type = "Grammar";
        String level = "A2";
        List<LessonInfo> expectedLessons = Arrays.asList(
                new LessonInfo(1L, "Lesson 1", "A2", "Grammar", "Description 1", "image1.jpg"),
                new LessonInfo(2L, "Lesson 2", "A2", "Grammar", "Description 2", "image2.jpg")
        );

        // Mocking the behavior of AlbumDao
        when(albumDao.findLessonsByTypeAndLevel(type, level)).thenReturn(expectedLessons);

        // Act
        List<LessonInfo> actualLessons = albumDaoTest.albumDao.findLessonsByTypeAndLevel(type, level);

        // Assert
        assertEquals(expectedLessons.size(), actualLessons.size());
        assertEquals(expectedLessons.get(0), actualLessons.get(0));
        assertEquals(expectedLessons.get(1), actualLessons.get(1));
    }
}
