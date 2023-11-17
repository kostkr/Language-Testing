package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.AlbumDao;
import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Album;
import com.WebSite.demo.model.Lesson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @GetMapping()
    String showAlbum (@RequestParam(value = "type", required = true) String type,
                      @RequestParam(value = "level", required = true) String level,
                      Model model){
        Album album = AlbumDao.getAlbum(Lesson.Type.fromString(type), Lesson.Level.fromString(level));
        model.addAttribute(album);
        return "album";
    }

}
