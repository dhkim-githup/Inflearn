package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCon {

    @GetMapping("/")
    public String doIndex(){
        return "index";
    }
}
