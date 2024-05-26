package com.WebSite.demo;

import com.WebSite.demo.model.Lesson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LessonTest {

    private Lesson lesson;
    private static final String TYPE = "Reading";
    private static final String LEVEL = "A1";
    private static final String NAME = "Sample Lesson";
    private static final String DESCRIPTION = "This is a sample lesson description.";
    private static final String IMAGE_URL = "http://example.com/image.png";
    private static final String TASK = "Complete the tasks provided.";
    private static final String INFO_SOURCE = "http://example.com/video.mp4";
    private static final List<String> QUESTIONS = Arrays.asList("Question 1", "Question 2");
    private static final List<String> ANSWERS_CORRECT = Arrays.asList("Answer 1; Answer 2; Answer 3");
    private static final List<String> ANSWERS_WRONG = Arrays.asList("Wrong 1", "Wrong 2");
    private static final String WAS_CREATED_TIME = "2024-05-25T18:56:48.974Z";

    @BeforeEach
    public void setUp() {
        lesson = Lesson.builder()
                .type(TYPE)
                .level(LEVEL)
                .name(NAME)
                .description(DESCRIPTION)
                .imageURL(IMAGE_URL)
                .task(TASK)
                .informationSource(INFO_SOURCE)
                .questions(QUESTIONS)
                .answersCorrect(ANSWERS_CORRECT)
                .answersWrong(ANSWERS_WRONG)
                .wasCreatedTime(WAS_CREATED_TIME)
                .build();
    }

    @Test
    public void testGetters() {
        assertThat(lesson.getType()).isEqualTo(TYPE);
        assertThat(lesson.getLevel()).isEqualTo(LEVEL);
        assertThat(lesson.getName()).isEqualTo(NAME);
        assertThat(lesson.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(lesson.getImageURL()).isEqualTo(IMAGE_URL);
        assertThat(lesson.getTask()).isEqualTo(TASK);
        assertThat(lesson.getInformationSource()).isEqualTo(INFO_SOURCE);
        assertThat(lesson.getQuestions()).isEqualTo(QUESTIONS);
        assertThat(lesson.getAnswersCorrect()).isEqualTo(ANSWERS_CORRECT);
        assertThat(lesson.getAnswersWrong()).isEqualTo(ANSWERS_WRONG);
        assertThat(lesson.getWasCreatedTime()).isEqualTo(WAS_CREATED_TIME);
    }

    @Test
    public void testSetters() {
        lesson.setType("Listening");
        lesson.setLevel("B2");
        lesson.setName("New Lesson");
        lesson.setDescription("New description.");
        lesson.setImageURL("http://example.com/new_image.png");
        lesson.setTask("New task.");
        lesson.setInformationSource("http://example.com/new_video.mp4");
        List<String> newQuestions = Arrays.asList("New Question 1", "New Question 2");
        lesson.setQuestions(newQuestions);
        List<String> newAnswersCorrect = Arrays.asList("New Answer 1; New Answer 2; New Answer 3");
        lesson.setAnswersCorrect(newAnswersCorrect);
        List<String> newAnswersWrong = Arrays.asList("New Wrong 1", "New Wrong 2");
        lesson.setAnswersWrong(newAnswersWrong);
        String newTime = "2025-06-30T10:10:10.974Z";
        lesson.setWasCreatedTime(newTime);

        assertThat(lesson.getType()).isEqualTo("Listening");
        assertThat(lesson.getLevel()).isEqualTo("B2");
        assertThat(lesson.getName()).isEqualTo("New Lesson");
        assertThat(lesson.getDescription()).isEqualTo("New description.");
        assertThat(lesson.getImageURL()).isEqualTo("http://example.com/new_image.png");
        assertThat(lesson.getTask()).isEqualTo("New task.");
        assertThat(lesson.getInformationSource()).isEqualTo("http://example.com/new_video.mp4");
        assertThat(lesson.getQuestions()).isEqualTo(newQuestions);
        assertThat(lesson.getAnswersCorrect()).isEqualTo(newAnswersCorrect);
        assertThat(lesson.getAnswersWrong()).isEqualTo(newAnswersWrong);
        assertThat(lesson.getWasCreatedTime()).isEqualTo(newTime);
    }

    @Test
    public void testEqualsAndHashCode() {
        Lesson anotherLesson = Lesson.builder()
                .id(lesson.getId())
                .type(TYPE)
                .level(LEVEL)
                .name(NAME)
                .description(DESCRIPTION)
                .imageURL(IMAGE_URL)
                .task(TASK)
                .informationSource(INFO_SOURCE)
                .questions(QUESTIONS)
                .answersCorrect(ANSWERS_CORRECT)
                .answersWrong(ANSWERS_WRONG)
                .wasCreatedTime(WAS_CREATED_TIME)
                .build();

        assertThat(lesson).isEqualTo(anotherLesson);
        assertThat(lesson.hashCode()).isEqualTo(anotherLesson.hashCode());
    }

    @Test
    public void testToString() {
        String expectedToString = "Lesson(id=0, type=Reading, level=A1, name=Sample Lesson, description=This is a sample lesson description., imageURL=http://example.com/image.png, task=Complete the tasks provided., informationSource=http://example.com/video.mp4, questions=[Question 1, Question 2], answersCorrect=[Answer 1; Answer 2; Answer 3], answersWrong=[Wrong 1, Wrong 2], wasCreatedTime=2024-05-25T18:56:48.974Z)";
        assertThat(lesson.toString()).isEqualTo(expectedToString);
    }

    @Test
    public void testNoArgumentConstructor() {
        Lesson lesson = new Lesson();

        assertThat(lesson.getId()).isEqualTo(0);
        assertThat(lesson.getType()).isNull();
        assertThat(lesson.getLevel()).isNull();
        assertThat(lesson.getName()).isNull();
        assertThat(lesson.getDescription()).isNull();
        assertThat(lesson.getImageURL()).isNull();
        assertThat(lesson.getTask()).isNull();
        assertThat(lesson.getInformationSource()).isNull();
        assertThat(lesson.getQuestions()).isNull();
        assertThat(lesson.getAnswersCorrect()).isNull();
        assertThat(lesson.getAnswersWrong()).isNull();
        assertThat(lesson.getWasCreatedTime()).isNull();
    }
}
