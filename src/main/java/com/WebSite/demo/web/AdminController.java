package com.WebSite.demo.web;

import com.WebSite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class AdminController {
    UserService userService;

    @Autowired
    AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") long userId){
        userService.delete(userId);
    }

    @GetMapping("/lockUser/{id}")
    public void lockUser(@PathVariable("id") long userId){
        userService.lock(userId);
    }

    @GetMapping("/unlockUser/{id}")
    public void unlockUser(@PathVariable("id") long userId){
        userService.unlock(userId);
    }
}
