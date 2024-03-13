package com.WebSite.demo.service;

import com.WebSite.demo.dataBase.AlbumDao;
import com.WebSite.demo.dto.Album;
import com.WebSite.demo.dto.LessonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumDao albumDao;

    @Autowired
    AlbumService(AlbumDao albumDao){
        this.albumDao = albumDao;
    }

    public Album getAlbum(String type, String level){
        List<LessonInfo> lessonInfoList = albumDao.findLessonsByTypeAndLevel(type, level);
        return Album.builder()
                .type(type)
                .level(level)
                .lessonInfoList(lessonInfoList)
                .build();
    }
}
