package com.andrewsotirov.aspect;

import com.andrewsotirov.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(0)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());
    @Around("execution(* com.andrewsotirov.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("=====>>>> @Around on method " + method);

        double begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        double end = System.currentTimeMillis();

        double durration = end - begin;

        logger.info("\n=========> Duration: " + durration/1000 + " seconds");

        return result;
    }

    @After("execution(* com.andrewsotirov.daodemo.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccounts(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>>>> AfterFinally on method " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.andrewsotirov.daodemo.AccountDAO.findAccounts(..))",
            throwing = "e"
    )
    public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable e) {
        String method = joinPoint.getSignature().toShortString();

        logger.info("Executing @AfterThrowing on method: " + method);
        logger.info("Exception " + e);
    }

    @AfterReturning(
            pointcut = "execution(* com.andrewsotirov.daodemo.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>>>> Executing at @AfterReturning at method " + method);

        logger.info("\n=====>>>>> Executing at @AfterReturning result is " + result);

        convertAccountNameToUpperCase(result);

        logger.info("\n=====>>>>> Executing at @AfterReturning result is " + result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        for (Account a :
                result) {
            String upperName = a.getName().toUpperCase();

            a.setName(upperName);
        }
    }


    @Before("com.andrewsotirov.aspect.AopExpressions.daoPackageNoGetterSetter()")
    public void beforeAdd(JoinPoint joinPoint) {
        logger.info("======> beforeAdd() before method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg :
                args) {
            logger.info(tempArg.toString());

            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;

                logger.info("Account name: " + account.getName());
                logger.info("Account level: " + account.getLevel());
            }
        }
    }

}
