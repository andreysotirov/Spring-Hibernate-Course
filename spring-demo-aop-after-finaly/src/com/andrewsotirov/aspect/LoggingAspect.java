package com.andrewsotirov.aspect;

import com.andrewsotirov.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class LoggingAspect {

    @After("execution(* com.andrewsotirov.daodemo.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccounts(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("=====>>>> AfterFinally on method " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.andrewsotirov.daodemo.AccountDAO.findAccounts(..))",
            throwing = "e"
    )
    public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable e){
        String method = joinPoint.getSignature().toShortString();

        System.out.println("Executing @AfterThrowing on method: " + method);
        System.out.println("Exception " + e);
    }

    @AfterReturning(
            pointcut = "execution(* com.andrewsotirov.daodemo.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>>> Executing at @AfterReturning at method " + method);

        System.out.println("\n=====>>>>> Executing at @AfterReturning result is " + result);

        convertAccountNameToUpperCase(result);

        System.out.println("\n=====>>>>> Executing at @AfterReturning result is " + result);
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
        System.out.println("======> beforeAdd() before method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg :
                args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

}
