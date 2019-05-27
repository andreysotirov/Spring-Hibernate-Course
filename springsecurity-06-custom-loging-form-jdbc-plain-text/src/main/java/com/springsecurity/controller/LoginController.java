package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/user-login")
    public String userLogin(){

        return "user-login";
    }
    @GetMapping("/leaders")
    public String showLeaders(){

        return "leaders";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){

        return "access-denied";
    }
}
