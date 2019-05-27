package com.andrewsotirov.springboot.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World asdasd ";
    }
    @GetMapping("/workout")
    public String workout() {
        return "Workout asdas";
    }
    @GetMapping("/teaminfo")
    public String teamInfo() {
        return "Coach name: " + coachName + ", Team name: " + teamName;
    }


}
