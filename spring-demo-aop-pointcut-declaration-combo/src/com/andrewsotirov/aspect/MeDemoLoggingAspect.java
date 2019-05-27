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

    @Pointcut("execution(* com.andrewsotirov.daodemo.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.andrewsotirov.daodemo.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter(){}

    @Before("daoPackageNoGetterSetter()")
    public void beforeAdd(){
        System.out.println("\n======> beforeAdd() before method");
    }

    @Before("daoPackageNoGetterSetter()")
    public void performAnalytics(){
        System.out.println("======> performAnalytics() before method");

    }

}
