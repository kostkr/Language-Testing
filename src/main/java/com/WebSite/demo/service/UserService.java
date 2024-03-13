package com.WebSite.demo.service;

import com.WebSite.demo.dataBase.UserDao;
import com.WebSite.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

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
    public User read(long userId){
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
    public void delete(long userId){
    userDao.delete(userId);
    }

    /**
     * create new user
     * @param name
     * @param email
     * @param password
     */
    private void register(String name, String email, String password, String role){
        User newUser = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .role(role)
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isAccountNonExpired(true)
                .build();

        register(newUser);
    }

    public void registerUser(String name, String email, String password){
        register(name, email, password, "ROLE_USER");
    }

    public void registerAdmin(String name, String email, String password){
        register(name, email, password, "ROLE_ADMIN");
    }

    public boolean exists(long userId){
        return userDao.exists(userId);
    }

    public void lock(long userId){
        userDao.lock(userId);
    }

    public void unlock(long userId){
        userDao.unlock(userId);
    }
}
