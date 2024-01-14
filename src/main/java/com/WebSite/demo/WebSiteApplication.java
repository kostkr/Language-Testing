package com.WebSite.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the WebSiteApplication.
 */
@SpringBootApplication
public class WebSiteApplication{

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(WebSiteApplication.class, args);

		/*Thread.sleep(100);
		LessonInfo lessonInfo = LessonInfo.builder()
				.name("myname")
				.level(LessonInfo.Level.A1.name())
				.type(LessonInfo.Type.Writing.name())
				.description("mydescription")
				.imageURL("https://comparic.pl/wp-content/uploads/2021/06/doge-shiba.jpg")
				.opt("https://www.youtube-nocookie.com/embed/YdWo5zbbGnY?si=5F_L8FWP1mzGDkjM")
				.build();

		Lesson lesson = Lesson.builder()
				.task("task")
				.questions(new ArrayList<>(List.of("questionsArray")))
				.answers(new ArrayList<>(List.of("answersArray")))
				.build();

		LessonDao.addLesson(lesson, lessonInfo);

		User newUser = User.builder()
				.name("rootroot")
				.email("miroslavdovger@gmail.com")
				.password("rootROOT!1")
				.role("ROLE_USER")
				.build();
		UserDao.addUser(newUser);*/
	}

}
