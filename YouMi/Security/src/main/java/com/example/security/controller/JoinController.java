package com.example.security.controller;

import com.example.security.dto.JoinDto;
import com.example.security.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    @Autowired
    private JoinService joinService;

    @GetMapping("/join")
    public String joinP(){
        return "/join";
    }

    @PostMapping("joinProc")
    public String joinProcess(JoinDto joinDto){
        System.out.println(joinDto);
        joinService.joinProcess(joinDto);

        return "redirect:/login";
    }
}
