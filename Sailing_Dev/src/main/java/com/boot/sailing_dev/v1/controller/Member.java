package com.boot.sailing_dev.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Member {

    @RequestMapping("/v1/member")
    public String doMember(){
        return "/v1/member/member";
    }

}
