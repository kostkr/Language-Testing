package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.Lesson;
import org.hibernate.Session;

import java.util.List;

public class LessonDao {
    public static void addLesson(Lesson lesson){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(lesson);
            session.getTransaction().commit();
            System.out.println("lesson added");
        }catch (Exception e){
            session.getTransaction().rollback();
            System.err.println("err add lesson");
        }finally {
            session.close();
        }
    }

    public static Lesson getLessonById(int lessonId){// return null if lesson doesn't exit
        Session session = null;
        Lesson lesson = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            lesson = session.get(Lesson.class, lessonId);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            System.err.println("err get lesson");
        }finally {
            session.close();
        }
        return lesson;
    }
}
