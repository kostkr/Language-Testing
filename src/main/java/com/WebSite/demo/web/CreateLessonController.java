package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/createLesson")
public class CreateLessonController {
    /*@PostMapping
    public String processForm(
            @RequestParam("name") String name,
            @RequestParam("level") Lesson.Level level,
            @RequestParam("type") Lesson.Type type,
            @RequestParam("description") String description,
            @RequestParam("task") String task,
            @RequestParam("questions[]") String[] questionsArray,
            @RequestParam("answers[]") String[] answersArray)
    {
        Lesson lesson = Lesson.builder().
                name(name).
                level(level).
                type(type).
                description(description).
                task(task).
                questions(new ArrayList<>(List.of(questionsArray))).
                answers(new ArrayList<>(List.of(answersArray))).
                build();

        LessonDao.addLesson(lesson);

        return "createLesson";
    }*/

    @GetMapping
    public String showCreateTestPage(){
        return "createLesson";
    }
}
