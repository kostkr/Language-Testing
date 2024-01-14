package com.WebSite.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * basic lesson class,
 * Lesson consist of LessonInfo (information about lesson), task, questions and answers
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public class Lesson{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String task;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_info_id")
    private LessonInfo lessonInfo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "lesson_questions", joinColumns = @JoinColumn(name = "lesson_id"))
    private List<String> questions;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "lesson_answers", joinColumns = @JoinColumn(name = "lesson_id"))
    private List<String> answers;
}
