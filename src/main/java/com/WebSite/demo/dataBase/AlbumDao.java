package com.WebSite.demo.dataBase;

import com.WebSite.demo.dto.LessonInfo;
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

    @Transactional(readOnly = true)
    public List<LessonInfo> findLessonsByTypeAndLevel(String type, String level) {
        String jpql = "SELECT NEW com.WebSite.demo.dto.LessonInfo(l.id, l.name, l.level, l.type, l.description, l.imageURL) FROM Lesson l WHERE l.type = :type AND l.level = :level";
        return em.createQuery(jpql, LessonInfo.class)
                .setParameter("type", type)
                .setParameter("level", level)
                .getResultList();
    }
}
