package com.WebSite.demo.web;

import com.WebSite.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.WebSite.demo.dataBase.UserDao.addUser;

@Controller
public class UserController {
    @GetMapping("/login")
    public String ShowLogin(){
        return "login.html";
    }

    @GetMapping("/signup")
    public String showSignUp(){
        return "signup.html";
    }

    /**
     * register a new user
     * @param name unique
     * @param email unique
     * @param password password
     * @return page to log in
     */
    @PostMapping("/signup")
    public String signUpUser(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password){
        User newUser = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .role("ROLE_USER")
                .build();

        addUser(newUser);
        return "login.html";
    }
}
