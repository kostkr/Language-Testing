package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.Album;
import com.WebSite.demo.model.LessonInfo;
import org.hibernate.Session;

import java.util.List;

public class AlbumDao {
    public static Album getAlbumsByTypeLevel(String type, String level){
        Album album = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            String hql ="SELECT l FROM lesson_info l WHERE l.type = :type and l.level = :level";
            List<LessonInfo> lessonInfoList = session.createQuery(hql, LessonInfo.class)
                    .setParameter("type", type)
                    .setParameter("level", level)
                    .getResultList();

            album = new Album(type, level, lessonInfoList);
            session.getTransaction().commit();
        }catch (Exception e){
            System.err.println("err get Album");
        }

        return album;
    }
}
