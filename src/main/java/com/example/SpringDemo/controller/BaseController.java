package com.example.SpringDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping("/")
    public String helloWorld(){
        return "hellooo Worrlddd!!";
    }
}
