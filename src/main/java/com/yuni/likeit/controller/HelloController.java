package com.yuni.likeit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("likeithello")
    public String sayHello() {
        return "Hello Likeit!!";
    }
}
