package com.WebSite.demo;

import com.WebSite.demo.dataBase.AlbumDao;
import com.WebSite.demo.model.Album;
import com.WebSite.demo.web.AlbumController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class AlbumControllerTest {

    static MockedStatic mocked;

    @BeforeAll
    static void setUp() {
        mocked = mockStatic(AlbumDao.class);}

    @AfterAll
    static void tearDown() {
        mocked.close();
    }

    @Mock
    private Model model;

    @InjectMocks
    private AlbumController albumController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowAlbum() {
        String type = "Grammar";
        String level = "A2";
        Album expectedAlbum = new Album();

        when(AlbumDao.getAlbumsByTypeLevel(type, level)).thenReturn(expectedAlbum);

        String result = albumController.showAlbum(type, level, model);

        assertEquals("album.html", result);
    }
}
