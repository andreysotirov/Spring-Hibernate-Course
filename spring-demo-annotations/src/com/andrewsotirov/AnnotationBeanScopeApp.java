package com.andrewsotirov;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println();

        boolean isEqual = (theCoach == alphaCoach);

        System.out.println(isEqual);

        context.close();
    }

}
