package com.boot.sailing.v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberConV2 {

    @RequestMapping("/v2/member")
    public String doMember(){

        return "/v2/member/member";
    }

}
