package com.WebSite.demo.service;

import com.WebSite.demo.dataBase.UserDao;
import com.WebSite.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserDao userDao;

    @Autowired
    UserService(UserDao userDao){
        this.userDao = userDao;
    }

    /**
     * Decode password using decoding configuration in SecurityConfiguration
     * @param user user data
     * the password shouldn't be encrypted
     */
    public void register(User user){
        userDao.register(user);
    }

    /**
     * @param name user name unique
     * @return User data copy
     */
    public User read(String name){
        return userDao.read(name);
    }

    /**
     * @param userId user id unique
     * @return User data copy
     */
    public User read(Long userId){
        return userDao.read(userId);
    }

    /**
     * Update user with the same id
     * @param user user data
     */
    public void update(User user){
        userDao.update(user);
    }

    /**
     * @param userId user id
     */
    public void delete(Long userId){
    userDao.delete(userId);
    }

}
