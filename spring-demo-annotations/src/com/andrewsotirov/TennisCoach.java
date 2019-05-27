package com.andrewsotirov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

//    @Value("${email}")
//    private String email;
//    @Value("${team}")
//    private String team;

    @Autowired
    @Qualifier("fortuneFileReader")
    private FortuneService fortuneService;

    @PostConstruct
    public void postConstruct(){
        System.out.println("post construct");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public String getTeam() {
//        return team;
//    }
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;

//    }
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;

//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
