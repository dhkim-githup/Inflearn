package com.boot.sailing_dev.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class HomeCon {

    @RequestMapping("/home")
    public String doHome(){
        return "/v1/home/home";
    }

}
