package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.Answers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class LessonController {
    /**
     * show lesson to user
     * @param id lesson id
     * @return lesson
     */
    @GetMapping("/lesson/{id}")
    public String showLesson(@PathVariable("id") long id, Model model){
        Lesson lesson = LessonDao.findLessonById(id);
        model.addAttribute(lesson);
        //List<Answers> allAnswers = Answers.createAnswersList( lesson.getAnswers() );
        //model.addAttribute(allAnswers);
        return "lesson.html";
    }
}
