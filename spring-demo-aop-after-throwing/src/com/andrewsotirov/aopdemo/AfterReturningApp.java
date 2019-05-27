package com.andrewsotirov.aopdemo;

import com.andrewsotirov.daodemo.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

//        List<Account> accounts = accountDAO.findAccounts(tripWire);

        System.out.println("\n\nMain Program: After Returning");
        System.out.println("======");

//        System.out.println(accounts);

        System.out.println("\n");

        context.close();
    }

}
