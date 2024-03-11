package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.Lesson;
import com.WebSite.demo.model.LessonInfo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LessonDao {

    private final EntityManager em;

    @Autowired
    public LessonDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Transactional
    public void addLesson(Lesson lesson, LessonInfo lessonInfo) {
        em.persist(lesson);

        lessonInfo.setId(lesson.getId());
        lesson.setLessonInfo(lessonInfo);
        em.persist(lessonInfo);

        System.out.println("lesson added");
    }

    @Transactional(readOnly = true)
    public Lesson findLessonById(long lessonId) {
        return em.find(Lesson.class, lessonId);
    }

    @Transactional(readOnly = true)
    public Long findLessonByName(String name) {
        LessonInfo lessonInfo = em.createQuery("FROM LessonInfo WHERE name = :name", LessonInfo.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getSingleResult();

        return lessonInfo != null ? lessonInfo.getId() : null;
    }
}
