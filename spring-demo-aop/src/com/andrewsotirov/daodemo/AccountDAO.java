package com.andrewsotirov.daodemo;

import com.andrewsotirov.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {


    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": addAccount");
    }


    public boolean doWork(){
        System.out.println(getClass() + ": doWork");
        return false;
    }

}
