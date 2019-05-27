package com.andrewsotirov.thymeleaf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/hello")
    public String helloWorld(Model model){

        model.addAttribute("date", new java.util.Date());

        return "helloworld";
    }

}
