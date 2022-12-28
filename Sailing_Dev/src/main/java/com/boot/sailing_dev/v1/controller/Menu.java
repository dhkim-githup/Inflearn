package com.boot.sailing_dev.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Menu {

    @RequestMapping("/v1/menu")
    public String doMenu(){
        return "/v1/menu/menu";
    }

}
