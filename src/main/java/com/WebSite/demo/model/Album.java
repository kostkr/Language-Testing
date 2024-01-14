package com.WebSite.demo.model;

import lombok.*;

import java.util.List;

/**
 * a group of lessons sorted for users
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Album {
    String type;
    String level;
    List<LessonInfo> lessonInfoList;
}
