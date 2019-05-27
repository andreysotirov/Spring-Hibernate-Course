package com.andrewsotirov.aspect;

import com.andrewsotirov.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LoggingAspect {

    @Before("com.andrewsotirov.aspect.AopExpressions.daoPackageNoGetterSetter()")
    public void beforeAdd(JoinPoint joinPoint) {
        System.out.println("======> beforeAdd() before method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg :
                args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account){
                Account account = (Account) tempArg;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

}
