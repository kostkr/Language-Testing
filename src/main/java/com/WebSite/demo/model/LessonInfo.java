package com.WebSite.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * information about lesson for users
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "lesson_info")
public class LessonInfo {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String level;

    @Column
    private String type;

    @Column
    private String description;

    @Column
    private String imageURL;

    @Column
    private String opt; // url video, url listening or text ...

    public enum Level {
        A1, A2, B1, B2, C1, C2
    }

    public enum Type{
        Reading, Listening, Grammar, Writing, Vocabulary
    }
}
