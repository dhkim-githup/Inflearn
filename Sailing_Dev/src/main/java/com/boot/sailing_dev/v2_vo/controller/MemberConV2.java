package com.boot.sailing_dev.v2_vo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class MemberConV2 {

    @RequestMapping("/member")
    public String doMember(Model model){
        return "/v2/member/member";
    }

}
