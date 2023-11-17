package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LessonController {
    @GetMapping("/lesson/{id}")
    public String showLesson(@PathVariable("id") int id, Model model){
        Lesson lesson = LessonDao.getLessonById(id);
        model.addAttribute(lesson);
        return "lesson";
    }
}
