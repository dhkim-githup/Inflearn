package com.example.security.controller;

import com.example.security.model.User;
import com.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountCon {

    private UserService userService;

    public AccountCon(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String doLogin(){
        return "account/login";
    }

    @GetMapping("/register")
    public String doRegisterGet(User user){
        return "account/register";
    }

    @PostMapping("/register")
    public String doRegisterPost(User user){
        userService.save(user);
        return "redirect:/";
    }
}
