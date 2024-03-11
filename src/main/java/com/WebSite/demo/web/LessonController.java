package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LessonController {

    private final LessonDao lessonDao;

    @Autowired
    public LessonController(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    /**
     * Show lesson to the user.
     *
     * @param id    Lesson ID
     * @param model Model to add attributes
     * @return Lesson template
     */
    @GetMapping("/lesson/{id}")
    public String showLesson(@PathVariable("id") long id, Model model) {
        Lesson lesson = lessonDao.findLessonById(id);
        model.addAttribute("lesson", lesson);
        return "lesson";
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
