package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.AlbumDao;
import com.WebSite.demo.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @GetMapping()
    String showAlbum (@RequestParam(value = "type", required = true) String type,
                      @RequestParam(value = "level", required = true) String level,
                      Model model){
        Album album = AlbumDao.getAlbumsByTypeLevel(type, level);
        model.addAttribute(album);
        return "album";
    }

}
