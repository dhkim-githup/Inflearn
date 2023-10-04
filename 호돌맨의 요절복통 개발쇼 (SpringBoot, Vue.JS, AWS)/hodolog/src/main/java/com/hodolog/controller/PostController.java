package com.hodolog.controller;

import com.hodolog.request.PostCreate;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PostController {

    // Http Method
    // GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE, CONNECT

    @PostMapping("/posts")
    public String post(
                        @RequestBody PostCreate postCreate
            //@RequestBody String str
                        ){
        log.info("postCreate={}", postCreate.toString());
        //log.info("title={}",str);
        return "Hello World!";
    }
}
