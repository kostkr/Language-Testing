package com.WebSite.demo.web;

import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

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
    )
    {
        String[] answersCorrect = new String[questions.length];
        String[] answersWrong = new String[questions.length];

        int index = 0;
        StringBuilder newAnswers = new StringBuilder();
        for(int i = 0; i < answersCorrectArray.length; i++){
            if( questionNumberCorrect[i] - 1 != index){
                answersCorrect[index] = newAnswers.substring(0, newAnswers.length() - Lesson.separator.length());
                newAnswers = new StringBuilder();
                index = questionNumberCorrect[i] - 1;
            }

            newAnswers.append(answersCorrectArray[i]).append(Lesson.separator);
        }
        answersCorrect[index] = newAnswers.substring(0, newAnswers.length() - Lesson.separator.length());


        index = 0;
        newAnswers = new StringBuilder();
        for(int i = 0; i < answersWrongArray.length; i++){
            if( questionNumberCorrect[i] - 1 != index){
                answersWrong[index] = newAnswers.substring(0, newAnswers.length() - Lesson.separator.length());
                newAnswers = new StringBuilder();
                index = questionNumberWrong[i] - 1;
            }

            newAnswers.append(answersWrongArray[i]).append(Lesson.separator);

        }
        answersWrong[index] = newAnswers.substring(0, newAnswers.length() - Lesson.separator.length());

        lessonService.create(type, level, name, description, imageURL, task, informationSource, questions, answersWrong, answersCorrect);
        return "createLesson";
    }

    @GetMapping("/createLesson")
    public String showCreateLessonPage(){
        return "createLesson";
    }
}
