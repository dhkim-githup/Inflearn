package com.boot.sailing_dev.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Menu {

    @RequestMapping("/v1/menu")
    public String doMenu(Model model){

        // 데이타 만들기
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String,Object> map = new HashMap<>();
        map.put("No", "1");
        map.put("name", "아이스아메");
        map.put("kind", "커피");
        map.put("price", "5,000");
        map.put("reg_day", "2020.10.29");
        map.put("mod_day", "2021.10.29");
        list.add(map);

        map.clear();

        map.put("No", "2");
        map.put("name", "카푸치노");
        map.put("kind", "커피");
        map.put("price", "6,000");
        map.put("reg_day", "2020.10.29");
        map.put("mod_day", "2021.10.29");

        list.add(map);

        // Model 사용
        model.addAttribute("where"," - Member Controller");
        model.addAttribute("list",list);

        return "/v1/menu/menu";
    }

}
