package com.andrewsotirov.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeDemoLoggingAspect {

    @Pointcut("execution(* com.andrewsotirov.daodemo.*.*(..))")
    public void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAdd(){
        System.out.println("\n======> beforeAdd() before method");
    }

    @Before("forDaoPackage()")
    public void performAnalytics(){
        System.out.println("======> performAnalytics() before method");

    }

}
