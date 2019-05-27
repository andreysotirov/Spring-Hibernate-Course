package com.andrewsotirov.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AnalyticsAspect {

    @Before("com.andrewsotirov.aspect.AopExpressions.daoPackageNoGetterSetter()")
    public void performAnalytics() {
        System.out.println("======> performAnalytics() before method");
    }

}
