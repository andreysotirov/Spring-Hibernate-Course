package com.andrewsotirov.aopdemo;

import com.andrewsotirov.daodemo.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;
        boolean tripWire = false;
        try {
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain Program: exception caught " + e);
        }

        System.out.println("\n\nMain Program: After Throwing    ");
        System.out.println("======");

        System.out.println(accounts);

        System.out.println("\n");

        context.close();
    }

}
