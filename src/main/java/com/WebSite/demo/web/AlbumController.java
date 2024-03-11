package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.AlbumDao;
import com.WebSite.demo.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumDao albumDao;

    /**
     * search album by type and level
     * @param type
     * @param level
     * @param model
     * @return album
     */
    @GetMapping()
    public String showAlbum(@RequestParam(value = "type") String type,
                            @RequestParam(value = "level") String level,
                            Model model){
        Album album = albumDao.getAlbumsByTypeLevel(type, level);
        model.addAttribute(album);
        return "album";
    }

}
