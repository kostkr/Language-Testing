package com.WebSite.demo.model;

import com.WebSite.demo.DBConnection.AlbumDao;
import com.WebSite.demo.DBConnection.LessonDao;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Data
@Component
public abstract class Lesson extends AlbumDao {
    private String name;
    private String level;
    private String description;
    private String task;
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    protected void addQuestion(String question){
        this.questions.add(question);
    }

    protected void addAnswer(String answer) {
        this.answers.add(answer);
    }

    public enum Level{
        A1("A1"), A2("A2"), B1("B1"), B2("B2"), C1("C1"), C2("C2");
        final private String name;
        Level(String name){
            this.name = name;
        }
        String getName(){return this.name;}
    }


}
