package com.boot.sailing_dev.v1.controller;


import com.boot.sailing_dev.v1.service.MenuSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1")
public class MenuCon {

    @Autowired
    MenuSvc menuSvc;

    @GetMapping("/menu")
    public String doMenu(Model model){

        // Data 만들기 , List , Map
        List<Map<String, Object>> list = menuSvc.doList();

        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", " ========== MenuCon ======== ");

        return "/v1/menu/menu";
    }

    @GetMapping("/menu_ins")
    public String doMenuInsGet(){

        return "/v1/menu/menu_ins";
    }

    @PostMapping("/menu_ins")
    public String doMenuInsPost(){

        return "/v1/menu/menu_ins";
    }



}
