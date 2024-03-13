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
    public User read(long userId) {
        return em.find(User.class, userId);
    }

    @Transactional
    public void update(User userToUpdate) {
        em.merge(userToUpdate);
    }

    @Transactional
    public void delete(long userId) {
        User userToRemove = em.find(User.class, userId);
        em.remove(userToRemove);
    }

    @Transactional(readOnly = true)
    public boolean exists(Long userId) {
        User user = read(userId);
        return user != null;
    }

    @Transactional(readOnly = true)
    public boolean exists(String userName) {
        User user = read(userName);
        return user != null;
    }

    @Transactional
    public void lock(long userId){
        User user = read(userId);
        if(user != null) {
            user.setAccountNonLocked(false);
            em.merge(user);
        }else
            System.err.println("user not found to lock");
    }

    @Transactional
    public void unlock(long userId){
        User user = read(userId);
        if(user != null) {
            user.setAccountNonLocked(true);
            em.merge(user);
        }else
            System.err.println("user not found to unlock");
    }
}