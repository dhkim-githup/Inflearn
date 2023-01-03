package com.boot.sailing_dev.v1.controller;


import com.boot.sailing_dev.v1.service.MenuSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String doMenuInsPost(@RequestParam("coffee") String strCoffee,
                                @RequestParam("kind") String strKind,
                                @RequestParam("price") String strPrice){

        int i = menuSvc.doInsert(strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }

    @GetMapping("/menu_del")
    public String doDelete(@RequestParam("no") String strNo){
        int i = menuSvc.doDelete(strNo);

        return "redirect:/v1/menu";

    }


    @GetMapping("/menu_up")
    public String doUpdate(Model model,
                           @RequestParam("no") String strNo){

        Map<String,String>  map = menuSvc.doListOne(strNo);
        model.addAttribute("map", map);

        return "/v1/menu/menu_up";
    }

    @PostMapping("/menu_up")
    public String doUpdatePost(@RequestParam("no") String strNo,
                               @RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice){

        int i = menuSvc.doUpdate(strNo, strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }







}
