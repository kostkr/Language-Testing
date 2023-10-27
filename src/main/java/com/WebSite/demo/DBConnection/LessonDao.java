package com.WebSite.demo.DBConnection;

import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.ReadingLesson;

import java.util.ArrayList;

public class LessonDao {
    public static Lesson getLesson(String name){
        Lesson reading = new ReadingLesson();
        reading.setName(name);
        reading.setLevel(Lesson.Level.A2.toString());
        ArrayList<String> questions = new ArrayList<>();
        questions.add("question for test");
        reading.setQuestions(questions);
        ArrayList<String> answer = new ArrayList<>();
        answer.add("answer to test");
        reading.setAnswers(answer);
        return reading;
    }
}
