package com.jwt.example.controller;

import com.jwt.example.entity.User;
import com.jwt.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/Home")
public class HomeController {

    @Autowired
    private UserService userService;

//     @GetMapping("/user")
//    public List<User> getUser(){
//     return userService.getStore();
//    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }

}
