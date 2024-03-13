package com.WebSite.demo.dto;

import lombok.*;

import java.util.List;

/**
 * a group of lessons sorted for users
 */
@AllArgsConstructor
@Builder
@Getter
public class Album {
    String type;
    String level;
    List<LessonInfo> lessonInfoList;
}
