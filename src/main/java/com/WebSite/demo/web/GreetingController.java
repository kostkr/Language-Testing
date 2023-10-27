package com.WebSite.demo.web;

import com.WebSite.demo.DBConnection.AlbumDao;
import com.WebSite.demo.model.Album;
import com.WebSite.demo.model.Lesson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GreetingController {
    @GetMapping
    public String showHome(){
        return "greeting";
    }

    @PostMapping
    public String showAlbum(@RequestParam("lessonName") String AlbumName, Model model){
        Album album = AlbumDao.getAlbum(AlbumName);
        model.addAttribute("lessonName",album.getLevel() + ' ' + album.getName().toUpperCase());
        return "lessonAlbum";
    }
}
