package com.boot.sailing_dev.v1.controller;

import com.boot.sailing_dev.v1.service.MenuSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuCon {



    @RequestMapping("/v1/menu")
    public String doMenu(Model model){

        // 데이타 만들기
        List<Map<String, Object>> list = new MenuSvc().doList();

        // Model 사용
        model.addAttribute("list",list);
        model.addAttribute("hello", " ========== MenuCon ======== ");

        return "/v1/menu/menu";
    }

}
