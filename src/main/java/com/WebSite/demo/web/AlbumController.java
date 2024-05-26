package com.WebSite.demo.web;

import com.WebSite.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/album")
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
    AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping()
    public String showAlbum(@RequestParam(value = "type") String type,
                            @RequestParam(value = "level") String level,
                            Model model){
        model.addAttribute(albumService.getAlbum(type, level));
        return "album";
    }
}