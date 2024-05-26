package com.WebSite.demo;

import com.WebSite.demo.dataBase.AlbumDao;
import com.WebSite.demo.dto.Album;
import com.WebSite.demo.dto.LessonInfo;
import com.WebSite.demo.service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlbumServiceTest {

    @Mock
    private AlbumDao albumDao;

    @InjectMocks
    private AlbumService albumService;

    private List<LessonInfo> lessonInfoList;

    @BeforeEach
    public void setUp() {
        LessonInfo lessonInfo1 = LessonInfo.builder()
                .id(1L)
                .name("Lesson 1")
                .level("B2")
                .type("Grammar")
                .description("description")
                .imageURL("URL")
                .build();

        LessonInfo lessonInfo2 = LessonInfo.builder()
                .id(1L)
                .name("Lesson 2")
                .level("B2")
                .type("Grammar")
                .description("description")
                .imageURL("URL")
                .build();
        
        lessonInfoList = Arrays.asList(lessonInfo1, lessonInfo2);
    }

    @Test
    public void testGetAlbum() {
        String type = "Reading";
        String level = "B1";

        when(albumDao.findLessonsByTypeAndLevel(type, level)).thenReturn(lessonInfoList);

        Album album = albumService.getAlbum(type, level);

        assertEquals(type, album.getType());
        assertEquals(level, album.getLevel());
        assertEquals(lessonInfoList, album.getLessonInfoList());

        verify(albumDao, times(1)).findLessonsByTypeAndLevel(type, level);
    }
}
