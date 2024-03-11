package com.WebSite.demo.web;

import com.WebSite.demo.model.User;
import com.WebSite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String ShowLogin(){
        return "login";
    }

    @GetMapping("/signup")
    public String showSignUp(){
        return "signup";
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
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isAccountNonExpired(true)
                .build();

        userService.register(newUser);
        return "login";
    }
}