package com.andrewsotirov.aopdemo;

import com.andrewsotirov.daodemo.AccountDAO;
import com.andrewsotirov.daodemo.MemebershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MemebershipDAO memebershipDAO = context.getBean("memebershipDAO", MemebershipDAO.class);
        Account account = new Account();

        accountDAO.addAccount(account,true);
        accountDAO.doWork();
        System.out.println();
        accountDAO.setName("andrew");
        accountDAO.setServiceCode("gold");

        accountDAO.getName();
        accountDAO.getServiceCode();

        memebershipDAO.addMemeber();
        memebershipDAO.goToSleep();

        context.close();
    }

}
