package com.andrewsotirov.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions  {

    @Pointcut("execution(* com.andrewsotirov.daodemo.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.andrewsotirov.daodemo.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.andrewsotirov.daodemo.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter() {
    }

}
