package com.WebSite.demo.web;

import com.WebSite.demo.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateLessonController {
    private final LessonService lessonService;

    @Autowired
    public CreateLessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/createLesson")
    public String createLesson(
            @RequestParam("type") String type,
            @RequestParam("level") String level,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("imageURL") String imageURL,
            @RequestParam("task") String task,
            @RequestParam("informationSource") String informationSource,
            @RequestParam("questions[]") String[] questions,
            @RequestParam("answersCorrect[]") String[] answersCorrectArray,
            @RequestParam("answersWrong[]") String[] answersWrongArray,
            @RequestParam("questionNumberCorrect[]") Integer[] questionNumberCorrect,
            @RequestParam("questionNumberWrong[]") Integer[] questionNumberWrong
    ){
        lessonService.createLessonProxi( type, level, name, description, imageURL, task, informationSource,
                 questions, answersCorrectArray, answersWrongArray, questionNumberCorrect, questionNumberWrong);

        return "createLessonPage";
    }

    @GetMapping("/createLesson")
    public String showCreateLessonPage(){
        return "createLessonPage";
    }
}
