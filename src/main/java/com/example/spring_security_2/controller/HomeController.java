package com.example.spring_security_2.controller;

import com.example.spring_security_2.entity.User;
import com.example.spring_security_2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return authService.verify(user);
    }

    @GetMapping("/")
    public String home() {
        return "public Home";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin Dashboard";
    }

    @GetMapping("/user/profile")
    public String profile() {
        return "user Profile";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }


}
