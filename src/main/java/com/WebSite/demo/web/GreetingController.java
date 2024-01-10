package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String showHome(){
        return "greeting";
    }

    @GetMapping("/{type}/{level}")
    public String showAlbum(@PathVariable("type") String type, @PathVariable("level") String level, Model model){
        model.addAttribute("albumName", level + ' ' + type );
        return "album";
    }

    @GetMapping("/searchLesson")
    public String searchLesson(@RequestParam("name") String lessonName){
        Long lessonId = LessonDao.findLessonByName(lessonName);

        return lessonId != null ? "redirect:/lesson/" + lessonId : "greeting";
    }
}
