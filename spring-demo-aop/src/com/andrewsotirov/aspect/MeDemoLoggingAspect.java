package com.andrewsotirov.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeDemoLoggingAspect {

    @Before("execution(* com.andrewsotirov.daodemo.*.*(..))")
    public void beforeAddAccount(){
        System.out.println("\n======> before method");
    }

}
