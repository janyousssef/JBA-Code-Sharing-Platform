package com.jan.codesharing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
