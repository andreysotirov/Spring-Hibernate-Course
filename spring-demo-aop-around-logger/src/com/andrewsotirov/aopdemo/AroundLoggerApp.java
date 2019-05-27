package com.andrewsotirov.aopdemo;

import com.andrewsotirov.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundLoggerApp {

    private static Logger logger = Logger.getLogger(AroundLoggerApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Main : AroundApp");

        logger.info("Calling get getFortune()");

        String data = trafficFortuneService.getFortune();

        logger.info("Fortune is " + data);
        logger.info("Finished");

        context.close();
    }

}
