package com.WebSite.demo.web;

import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
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
        Lesson lesson = lessonService.read(id);
        model.addAttribute("lesson", lesson);
        return "lesson";
    }

    @GetMapping("/searchLesson")
    public String searchLesson(@RequestParam("name") String lessonName){
        Long lessonId = lessonService.findLessonIdByName(lessonName);
        return lessonId != 0L ? "redirect:/lesson/" + lessonId : "greeting";
    }
}