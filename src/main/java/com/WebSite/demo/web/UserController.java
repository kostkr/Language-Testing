package com.WebSite.demo.web;

import com.WebSite.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static com.WebSite.demo.dataBase.UserDao.*;

@Controller
@RequestMapping
public class UserController {
    @GetMapping("/login")
    public String ShowLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {

        if(userExists(email, password)){
        }else{
            userNotExists();
        }

        return "greeting";
    }

    @GetMapping("/signup")
    public String showSignUp(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password){
        User newUser = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        addUser(newUser);
        return "login";
    }

private void userNotExists(){
        // catch exception
}
}
