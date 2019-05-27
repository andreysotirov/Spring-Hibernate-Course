package com.andrewsotirov.springboot.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello world! Server time is " + LocalDateTime.now();
    }
}
