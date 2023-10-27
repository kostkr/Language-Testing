package com.WebSite.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @GetMapping
    String showReadingAlbum(){
        return "lessonAlbum";
    }

}
