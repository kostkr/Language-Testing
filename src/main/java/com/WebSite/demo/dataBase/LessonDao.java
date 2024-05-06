package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.Lesson;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class LessonDao {
    private final EntityManager em;

    @Autowired
    public LessonDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Transactional
    public void create(Lesson lesson) {
        em.persist(lesson);
    }

    @Transactional(readOnly = true)
    public Lesson read(long lessonId) {
        return em.find(Lesson.class, lessonId);
    }

    @Transactional
    public void update(Lesson lesson) {
        em.merge(lesson);
    }

    @Transactional
    public void delete(long lessonId) {
        Lesson lessonToDelete = em.find(Lesson.class, lessonId);
        em.remove(lessonToDelete);
    }

    @Transactional(readOnly = true)
    public Long findLessonIdByName(String name) {
        List<Long> results = em.createQuery("SELECT l.id FROM Lesson l WHERE l.name LIKE :name", Long.class)
                .setParameter("name", name)
                .getResultList();
        return results.isEmpty() ? 0L : results.get(0);
    }
}
