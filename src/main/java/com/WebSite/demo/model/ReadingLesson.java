package com.WebSite.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReadingLesson extends Lesson {
    private String text;
}
