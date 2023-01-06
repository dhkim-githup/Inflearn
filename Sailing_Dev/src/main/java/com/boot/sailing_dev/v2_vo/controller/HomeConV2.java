package com.boot.sailing_dev.v2_vo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class HomeConV2 {

    @RequestMapping("/home")
    public String doHome(){
        return "/v2/home/home";
    }

}
