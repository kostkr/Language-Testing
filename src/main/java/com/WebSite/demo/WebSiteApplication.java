package com.WebSite.demo;

import com.WebSite.demo.dataBase.AlbumDao;
import com.WebSite.demo.dataBase.HibernateUtil;
import com.WebSite.demo.dataBase.LessonDao;
import com.WebSite.demo.model.Album;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.PreviewLesson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebSiteApplication{

	public static void main(String[] args) {
		SpringApplication.run(WebSiteApplication.class, args);
		Lesson lesson = Lesson.builder().
				name("name").
				level(Lesson.Level.A1).
				type(Lesson.Type.Grammar).
				description("description").
				task("task").
				questions(new ArrayList<>(List.of("questionsArray"))).
				answers(new ArrayList<>(List.of("answersArray"))).
				build();
		LessonDao.addLesson(lesson);

//		Album album = AlbumDao.getAlbum(Lesson.Type.Grammar, Lesson.Level.A1);
//		System.out.println(album.getLevel().toString());
//		for(PreviewLesson previewLesson : album.getPreviewLessons()){
//			System.out.println(previewLesson.getId() + " " + previewLesson.getName() + " " + previewLesson.getDescription());
//		}
	}

}
