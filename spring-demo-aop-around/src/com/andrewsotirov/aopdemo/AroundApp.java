package com.andrewsotirov.aopdemo;

import com.andrewsotirov.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main : AroundApp");

        System.out.println("Calling get getFortune()");

        String data = trafficFortuneService.getFortune();

        System.out.println("Fortune is " + data);
        System.out.println("Finished");

        context.close();
    }

}
