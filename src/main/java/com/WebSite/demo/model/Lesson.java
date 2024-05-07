package com.WebSite.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * basic lesson class,
 * Lesson consist of LessonInfo (information about lesson), task, questions and answers
 * hierarchy: /type/level/name
 * index question == index answer
 * {answer; answer; answer}{answer, answer, answer}
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "lessons")
public class Lesson{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imageURL;

    @Column(nullable = false)
    private String task;

    @Column(nullable = false)
    private String informationSource;// text, video URL or audio URL

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "lesson_questions", joinColumns = @JoinColumn(name = "lesson_id"))
    private List<String> questions;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "lesson_answers_correct", joinColumns = @JoinColumn(name = "lesson_id"))
    private List<String> answersCorrect;// {{ans1; ans2; ans3}, ... }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "lesson_answers_wrong", joinColumns = @JoinColumn(name = "lesson_id"))
    private List<String> answersWrong;

    public enum Level {
        A1, A2, B1, B2, C1, C2
    }

    public enum Type{
        Reading, Listening, Grammar, Writing, Vocabulary
    }

    public static final String separator = "; ";
}
