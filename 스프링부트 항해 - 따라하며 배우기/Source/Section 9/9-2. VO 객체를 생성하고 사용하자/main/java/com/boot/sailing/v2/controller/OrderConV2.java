package com.boot.sailing.v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderConV2 {

    @RequestMapping("/v2/order")
    public String doOrder(){

        return "/v2/order/order";
    }

}
