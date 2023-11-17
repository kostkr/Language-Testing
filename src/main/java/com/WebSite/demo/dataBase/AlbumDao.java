package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.Album;
import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.PreviewLesson;
import org.hibernate.Session;

import java.util.List;

public class AlbumDao {
    public static Album getAlbum(Lesson.Type type, Lesson.Level level){
        Session session = null;
        Album album = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String hql ="SELECT l.id, l.name, l.description FROM lesson l WHERE l.type = :type and l.level = :level";
            List<PreviewLesson> previewLessons = session.createQuery(hql, PreviewLesson.class)
                    .setParameter("type", type)
                    .setParameter("level", level)
                    .getResultList();

            album = new Album(type, level, previewLessons);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            System.err.println("err get Album");
        }finally {
            session.close();
        }

        return album;
    }
}
