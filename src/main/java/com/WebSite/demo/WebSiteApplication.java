package com.WebSite.demo;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.dataBase.UserDao;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.LessonInfo;
import com.WebSite.demo.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

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

		lessonDao.addLesson(lesson, lessonInfo);

		User newUser = User.builder()
				.name("rootroot")
				.email("miroslavdovger@gmail.com")
				.password("rootROOT!1")
				.role("ROLE_USER")
				.build();

		userDao.addUser(newUser);*/
	}

}
