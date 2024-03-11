package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.Album;
import com.WebSite.demo.model.LessonInfo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class AlbumDao {

    private final EntityManager em;

    @Autowired
    public AlbumDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Transactional
    public Album getAlbumsByTypeLevel(String type, String level) {
        Album album = null;
        try {
            String hql = "SELECT l FROM LessonInfo l WHERE l.type = :type and l.level = :level";
            List<LessonInfo> lessonInfoList = em.createQuery(hql, LessonInfo.class)
                    .setParameter("type", type)
                    .setParameter("level", level)
                    .getResultList();

            album = new Album(type, level, lessonInfoList);
        } catch (Exception e) {
            System.err.println("err get Album");
        }

        return album;
    }
}
