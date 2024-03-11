package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    private final LessonDao lessonDao;

    @Autowired
    public GreetingController(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @GetMapping("/")
    public String showHome(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.toString());
        System.out.println(auth.isAuthenticated());
        auth.setAuthenticated(false);
        return "greeting";
    }

    /**
     * search lesson and show user if it exists
     * @param lessonName
     * @return /lesson/{id}
     */
    @GetMapping("/searchLesson")
    public String searchLesson(@RequestParam("name") String lessonName){
        Long lessonId = lessonDao.findLessonByName(lessonName);

        return lessonId != null ? "redirect:/lesson/" + lessonId : "greeting";
    }
}
