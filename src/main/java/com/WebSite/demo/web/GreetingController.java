package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String showHome(){
        return "greeting";
    }

    /**
     * search lesson and show user if it exists
     * @param lessonName
     * @return /lesson/{id}
     */
    @GetMapping("/searchLesson")
    public String searchLesson(@RequestParam("name") String lessonName){
        Long lessonId = LessonDao.findLessonByName(lessonName);

        return lessonId != null ? "redirect:/lesson/" + lessonId : "greeting";
    }
}
