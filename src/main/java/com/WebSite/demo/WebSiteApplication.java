package com.WebSite.demo;

import com.WebSite.demo.DBConnection.LessonDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebSiteApplication extends LessonDao {

	public static void main(String[] args) {
		SpringApplication.run(WebSiteApplication.class, args);
	}

}
