package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.User;
import org.hibernate.Session;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDao {
    public static void addUser(User user){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            System.out.println("user added");
        }catch (Exception e){
            System.err.println("err add user");
        }
    }

    public static User findByName(String name){// return null if lesson doesn't exit
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            user = session.createQuery("FROM users WHERE name = :name", User.class)
                    .setParameter("name", name)
                    .uniqueResult();
            session.getTransaction().commit();
        }catch (Exception e){
            System.err.println("err find user");
        }
        return user;
    }
}
