package com.andrewsotirov.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MeDemoLoggingAspect {

    @Before("com.andrewsotirov.aspect.AopExpressions.daoPackageNoGetterSetter()")
    public void beforeAdd() {
        System.out.println("======> beforeAdd() before method");
    }

}
