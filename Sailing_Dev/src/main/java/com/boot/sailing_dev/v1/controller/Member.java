package com.boot.sailing_dev.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Member {

    @RequestMapping("/v1/member")
    public String doMember(Model model){
        return "/v1/member/member";
    }

}
