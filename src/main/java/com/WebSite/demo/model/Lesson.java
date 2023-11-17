package com.WebSite.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="lesson")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Lesson{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "description")
    private String description;

    @Column(name = "task")
    private String task;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "lesson_questions", joinColumns = @JoinColumn(name = "lesson_id"))
    private List<String> questions;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "lesson_answers", joinColumns = @JoinColumn(name = "lesson_id"))
    private List<String> answers;

    public enum Level {
        A1("A1"), A2("A2"), B1("B1"), B2("B2"), C1("C1"), C2("C2");
        final public String name;

        Level(String name) {
            this.name = name;
        }
        public static Level fromString(String name) {
            for (Level level : Level.values()) {
                if (level.name.equalsIgnoreCase(name)) {
                    return level;
                }
            }
            throw new IllegalArgumentException("No constant with the specified name");
        }
    }

    public enum Type{
        Reading("Reading"), Listening("Listening"), Grammar("Grammar"),
        Writing("Writing"), Vocabulary("Vocabulary");
        final public String name;
        Type(String name){this.name = name;}

        public static Type fromString(String name) {
            for (Type type : Type.values()) {
                if (type.name.equalsIgnoreCase(name)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("No constant with the specified name");
        }
    }
}
