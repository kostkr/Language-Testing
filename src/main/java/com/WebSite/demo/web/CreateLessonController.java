package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.LessonInfo;
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
    /**
     * save new lesson
     * @param name
     * @param level
     * @param type
     * @param description
     * @param imageURL
     * @param task
     * @param questionsArray
     * @param answersArray
     //* @param wrongAnswersArray1
     //* @param wrongAnswersArray2
     //* @param wrongAnswersArray3
     * @return
     */
    @PostMapping
    public String processForm(
            @RequestParam("name") String name,
            @RequestParam("level") String level,
            @RequestParam("type") String type,
            @RequestParam("description") String description,
            @RequestParam("imageURL") String imageURL,
            @RequestParam(value = "opt", required = false) String opt,
            @RequestParam("task") String task,
            @RequestParam("questions[]") String[] questionsArray,
            @RequestParam("answers[]") String[] answersArray)
            //@RequestParam("wrongAnswers1[]") String[] wrongAnswersArray1),
            //@RequestParam("wrongAnswers2[]") String[] wrongAnswersArray2),
            //@RequestParam("wrongAnswers3[]") String[] wrongAnswersArray3)
    {
        LessonInfo lessonInfo = LessonInfo.builder()
                .name(name)
                .level(level)
                .type(type)
                .description(description)
                .imageURL(imageURL)
                .opt(opt != null ? opt : "null")
                .build();

        Lesson lesson = Lesson.builder()
                .task(task)
                .questions(new ArrayList<>(List.of(questionsArray)))
                .answers(new ArrayList<>(List.of(answersArray)))
                .build();

        LessonDao.addLesson(lesson, lessonInfo);

        return "createLesson.html";
    }

    @GetMapping
    public String showCreateTestPage(){
        return "createLesson.html";
    }
}
