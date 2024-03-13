package com.WebSite.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * information about lesson
 */
@Getter
@Builder
@AllArgsConstructor
public class LessonInfo {
    private Long id;
    private String name;
    private String level;
    private String type;
    private String description;
    private String imageURL;
}