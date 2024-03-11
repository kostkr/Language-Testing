package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

    private final EntityManager em;
    private final PasswordEncoder encoder;

    @Autowired
    public UserDao(EntityManager entityManager, PasswordEncoder passwordEncoder) {
        this.em = entityManager;
        this.encoder = passwordEncoder;
    }

    @Transactional
    public void register(User user) {
        user.setPassword(this.encoder.encode(user.getPassword()));
        em.persist(user);

        System.out.println("user has registered: " + user.getName());
    }

    @Transactional(readOnly = true)
    public User read(String name) {
        return em.createQuery("FROM User WHERE name = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional(readOnly = true)
    public User read(Long userId) {
        return em.createQuery("FROM User WHERE id = :id", User.class)
                .setParameter("id", userId)
                .getSingleResult();
    }

    @Transactional
    public void update(User updatedUser) {
        User existingUser = em.find(User.class, updatedUser.getId());
        em.merge(existingUser);
    }

    @Transactional
    public void delete(Long userId) {
        User userToRemove = em.find(User.class, userId);
        if(userToRemove != null)
            em.remove(userToRemove);
    }

    @Transactional(readOnly = true)
    public boolean exists(Long userId) {
        User user = read(userId);
        return user != null;
    }

    @Transactional
    public void lock(Long userId){
        User user = read(userId);
        if(user != null)
            user.setAccountNonLocked(false);
    }

    @Transactional
    public void unlock(Long userId){
        User user = read(userId);
        if(user != null)
            user.setAccountNonLocked(true);
    }
}