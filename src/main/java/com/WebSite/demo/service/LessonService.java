package com.WebSite.demo.service;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.YoutubeUrlConverter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LessonService {
    private final LessonDao lessonDao;
    private final YoutubeUrlConverter youtubeUrlConverter;

    LessonService(LessonDao lessonDao, YoutubeUrlConverter youtubeUrlConverter){
        this.lessonDao = lessonDao;
        this.youtubeUrlConverter = youtubeUrlConverter;
    }

    public void create(Lesson lesson) {
        lessonDao.create(lesson);
    }

    public void create(String type, String level, String name, String description, String imageURL, String task, String informationSource, String[] questions, String[] answersWrong, String[] answersCorrect) {
        Lesson newLesson = build(type, level, name, description, imageURL, task, informationSource, questions, answersWrong, answersCorrect);
        create(newLesson);
    }

    public Lesson read(long lessonId){
            return lessonDao.read(lessonId);
    }

    public Long findLessonIdByName(String lessonName){
        return lessonDao.findLessonIdByName(lessonName);
    }

    public void update(Lesson lesson) {
        lessonDao.update(lesson);
    }

    public void update(String type, String level, String name, String description, String imageURL, String task, String informationSource, String[] questions, String[] answersWrong, String[] answersCorrect) {
        Lesson newLesson = build(type, level, name, description, imageURL, task, informationSource, questions, answersWrong, answersCorrect);
        update(newLesson);
    }

    public void delete(long lessonId){
        lessonDao.delete(lessonId);
    }

    public Lesson build(String type, String level, String name, String description, String imageURL, String task, String informationSource, String[] questions, String[] answersWrong, String[] answersCorrect) {
        type = type != null ? type : "";
        level = level != null ? level : "";
        name = name != null ? name : "";
        description = description != null ? description : "";
        imageURL = imageURL != null ? imageURL : "";
        task = task != null ? task : "";
        informationSource = informationSource != null ? informationSource : "";

        List<String> questionsList = questions != null ? Arrays.asList(questions) : Collections.emptyList();
        List<String> answersWrongList = answersWrong != null ? Arrays.asList(answersWrong) : Collections.emptyList();
        List<String> answersCorrectList = answersCorrect != null ? Arrays.asList(answersCorrect) : Collections.emptyList();

        if(type.equals(Lesson.Type.Listening.toString()))
            informationSource = youtubeUrlConverter.generateEmbeddedUrl(informationSource);

        return Lesson.builder()
                .type(type)
                .level(level)
                .name(name)
                .description(description)
                .imageURL(imageURL)
                .task(task)
                .informationSource(informationSource)
                .questions(questionsList)
                .answersCorrect(answersCorrectList)
                .answersWrong(answersWrongList)
                .build();
    }
}
