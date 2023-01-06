package com.boot.sailing_dev.v2_vo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class OrderConV2 {

    @RequestMapping("/order")
    public String doOrder(){
        return "/v2/order/order";
    }

}
