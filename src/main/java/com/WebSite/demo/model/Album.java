package com.WebSite.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * a group of lessons sorted for users
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Album {
    String type;
    String level;
    List<LessonInfo> lessonInfoList;
}
