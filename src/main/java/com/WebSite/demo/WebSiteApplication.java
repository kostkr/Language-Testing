package com.WebSite.demo;

import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.dataBase.UserDao;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebSiteApplication{

	public static void main(String[] args) {
		SpringApplication.run(WebSiteApplication.class, args);
		/*Lesson lesson = Lesson.builder().
				name("name").
				level(Lesson.Level.A1).
				type(Lesson.Type.Grammar).
				description("description").
				task("task").
				questions(new ArrayList<>(List.of("questionsArray"))).
				answers(new ArrayList<>(List.of("answersArray"))).
				build();
		LessonDao.addLesson(lesson);

		User newUser = User.builder()
				.name("rootroot")
				.email("miroslavdovger@gmail.com")
				.password("rootROOT!1")
				.role("ROLE_USER")
				.build();
		UserDao.addUser(newUser);*/
	}

}
