package com.WebSite.demo.DBConnection;

import com.WebSite.demo.model.Album;
import com.WebSite.demo.model.Lesson;

import java.util.ArrayList;

public class AlbumDao{
     public static Album getAlbum(String albumName){// now return example of readingLesson to text view
        Album album = new Album();
        album.setName(albumName);
        album.setLevel("A2");
        ArrayList<Lesson> list = new ArrayList<>();
        list.add(LessonDao.getLesson(albumName));
        album.setLessons(list);

        return album;
    }
}
