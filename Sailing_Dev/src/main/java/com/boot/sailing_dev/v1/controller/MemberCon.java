package com.boot.sailing_dev.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberCon {

    @RequestMapping("/v1/member")
    public String doMember(Model model){
        return "/v1/member/member";
    }

}
