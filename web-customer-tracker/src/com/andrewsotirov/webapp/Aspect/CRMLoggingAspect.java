package com.andrewsotirov.webapp.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.andrewsotirov.webapp.controller.*.*(..))")
    private void controllerPackage() {
    }

    @Pointcut("execution(* com.andrewsotirov.webapp.dao.*.*(..))")
    private void daoPackage() {
    }

    @Pointcut("execution(* com.andrewsotirov.webapp.service.*.*(..))")
    private void servicePackage() {
    }

    @Pointcut("controllerPackage()||daoPackage()||servicePackage()")
    private void forAppFlow() {
    }

    //@Before Advise
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @Before: calling method " + method);

        Object[] args = joinPoint.getArgs();

        for (Object o : args) {
            logger.info("======> arguments: " + o);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @AfterReturning: calling method " + method);

        logger.info("=====> result: " + result);
    }

}
