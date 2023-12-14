package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.LessonInfo;
import org.hibernate.Session;

public class LessonDao {
    public static void addLesson(Lesson lesson, LessonInfo lessonInfo){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.persist(lesson);

            lessonInfo.setId(lesson.getId());
            lesson.setLessonInfo(lessonInfo);
            session.persist(lessonInfo);

            session.getTransaction().commit();
            System.out.println("lesson added");
        }catch (Exception e){
            System.err.println("lesson not added");
        }


    }

    public static Lesson findLessonById(int lessonId){// return null if lesson doesn't exit
        Lesson lesson = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            lesson = session.get(Lesson.class, lessonId);
            session.getTransaction().commit();
        }catch (Exception e){
            System.err.println("lesson not found");
        }
        return lesson;
    }
}
