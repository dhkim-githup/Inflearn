package com.boot.sailing_dev.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRest {

     @RequestMapping(value = "/v1/homerest" ,  method = RequestMethod.GET)
    public String doHome(){

         String strHtml="<html><body> Hi Rest <hr> Hi. </body></html>";

        return strHtml;
    }

}
