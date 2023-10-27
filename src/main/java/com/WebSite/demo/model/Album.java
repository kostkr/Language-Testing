package com.WebSite.demo.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Album {
    private String name;
    private String level;
    ArrayList<Lesson> lessons;

}
