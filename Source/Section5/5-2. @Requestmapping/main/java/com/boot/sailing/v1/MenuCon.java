package com.boot.sailing.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuCon {

    @RequestMapping("/v1/menu")
    public String doMenu(){

        return "/v1/menu/menu";
    }

}
