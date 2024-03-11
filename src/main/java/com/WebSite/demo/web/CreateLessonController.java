package com.WebSite.demo.web;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.LessonInfo;
import com.WebSite.demo.model.YoutubeUrlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping("/createLesson")
public class CreateLessonController {

    private final LessonDao lessonDao;

    @Autowired
    public CreateLessonController(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

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
//     * @param wrongAnswersArray1
//     * @param wrongAnswersArray2
//     * @param wrongAnswersArray3
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
//            @RequestParam("wrongAnswers1[]") String[] wrongAnswersArray1,
//            @RequestParam("wrongAnswers2[]") String[] wrongAnswersArray2,
//            @RequestParam("wrongAnswers3[]") String[] wrongAnswersArray3)

    {
        if(type.equals("Listening")){
            opt = YoutubeUrlConverter.generateEmbeddedUrl(opt);
        }

//        List<String> jsonStrings = new ArrayList<>();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        for (int i = 0; i < answersArray.length; i++) {
//            ObjectNode jsonObject = objectMapper.createObjectNode();
//            jsonObject.put("good", answersArray[i]);
//            jsonObject.put("bad1", wrongAnswersArray1[i]);
//            jsonObject.put("bad2", wrongAnswersArray2[i]);
//            jsonObject.put("bad3", wrongAnswersArray3[i]);
//            jsonStrings.add(jsonObject.toString());
//        }

        LessonInfo lessonInfo = LessonInfo.builder()
                .name(name)
                .level(level)
                .type(type)
                .description(description)
                .imageURL(imageURL)
                .opt(opt != null ? opt : "null")
                .build();

//        Lesson lesson = Lesson.builder()
//                .task(task)
//                .questions(new ArrayList<>(List.of(questionsArray)))
//                .answers(jsonStrings)
//                .build();

        Lesson lesson = Lesson.builder()
                .task(task)
                .questions(new ArrayList<>(List.of(questionsArray)))
                .answers(new ArrayList<>(List.of(answersArray)))
                .build();

        lessonDao.addLesson(lesson, lessonInfo);

        return "createLesson";
    }

    @GetMapping
    public String showCreateTestPage(){
        return "createLesson";
    }
}
