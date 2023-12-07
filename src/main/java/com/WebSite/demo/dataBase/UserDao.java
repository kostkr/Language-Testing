package com.WebSite.demo.dataBase;

import com.WebSite.demo.model.User;
import org.hibernate.Session;

public class UserDao {
    public static void addUser(User user){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            System.out.println("user added");
        }catch (Exception e){
            System.err.println("err add user");
        }
    }

    public static User findByEmail(String email){// return null if lesson doesn't exit
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            user = session.createQuery("FROM client WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
            session.getTransaction().commit();
        }catch (Exception e){
            System.err.println("err find user");
        }
        return user;
    }

    public static boolean emailExists(String email){
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = session.createQuery("FROM client WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }catch (Exception e){
            System.err.println("err check email exists");
        }
        return user != null;
    }

    public static boolean userExists(String email, String password){
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = session.createQuery("FROM client WHERE email = :email AND password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();
        }catch (Exception e){
            System.err.println("err check user exists");
        }
        return user != null;
    }
}
