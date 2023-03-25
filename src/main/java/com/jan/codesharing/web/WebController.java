package com.jan.codesharing.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/",produces = "text/html")
public class WebController {
    @GetMapping("/code")
    public String hello(){
        System.out.println("here");
        return "code";
    }
}
